package com.example.controller;

import com.example.model.Event;
import com.example.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/event")
public class EventController {
    public EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getEvents(){
        return eventService.getEvents();
    }

    @GetMapping("/{id}")
    public Optional<Event> getEvent(@PathVariable("id") Integer id){
        return eventService.getEvent(id);
    }

    @PostMapping
    public void createEvent(Event newEvent){
        eventService.createEvent(newEvent);
    }

    @PutMapping
    public void updateEvent(Integer id, Event event){
        eventService.updateEvent(id, event);
    }

}
