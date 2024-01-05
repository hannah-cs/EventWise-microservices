package com.example.service;

import com.example.model.Event;
import com.example.repository.EventRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final WebClient webClient;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
        this.webClient = WebClient.builder().baseUrl("http://localhost:8082").build();
    }

    public boolean isClientExists(Integer clientId) {
        try {
            if (clientId != null) {
                return webClient.get()
                        .uri("http://localhost:8080/api/client/" + clientId)
                        .retrieve()
                        .toBodilessEntity()
                        .map(responseEntity -> responseEntity.getStatusCode().is2xxSuccessful())
                        .block();
            } else {
                return false;
            }
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }


    public boolean isVendorAvailable(Integer vendorId) {
        return webClient.get()
                .uri("http://localhost:8081/api/vendor/availability/" + vendorId)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }
    public List<Event> getEvents(){
        return eventRepository.findAll();
    }

    public Optional<Event> getEvent(Integer id){
        Optional<Event> event = eventRepository.findById(id);
        return event;
    }

    public ResponseEntity<String> createEvent(Event newEvent){
        Integer clientId = newEvent.getClientId();
        Integer vendorId = newEvent.getVendorId();
        if (isClientExists(clientId)){
            if (isVendorAvailable(vendorId)) {
                eventRepository.save(newEvent);
                return ResponseEntity.ok("Successfully created event.");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Vendor not available");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
    }

    public ResponseEntity<String> updateEvent(Integer eventId, Event updatedEvent) {
        Optional<Event> existingEventOptional = eventRepository.findById(eventId);

        if (existingEventOptional.isPresent()) {
            Event existingEvent = existingEventOptional.get();
            existingEvent.setEventName(updatedEvent.getEventName());
            existingEvent.setEventDate(updatedEvent.getEventDate());
            existingEvent.setVendorId(updatedEvent.getVendorId());
            existingEvent.setClientId(updatedEvent.getClientId());

            eventRepository.save(existingEvent);
            return ResponseEntity.ok("Event updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found");
        }
    }
}
