package com.example.controller;

import com.example.model.Vendor;
import com.example.service.VendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {
    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    public List<Vendor> getVendors(){
        return vendorService.getVendors();
    }

    @GetMapping("/{id}")
    public Optional<Vendor> getVendor(@PathVariable("id") Integer id){
        return vendorService.getVendor(id);
    }

    @PostMapping
    public void createVendor(@RequestBody Vendor newVendor){
        vendorService.createVendor(newVendor);
    }

    @PutMapping("/{id}")
    public void updateServices(@PathVariable("id") Integer id, @RequestBody List<String> newServices){
        vendorService.updateVendorServices(id, newServices);
    }

    @GetMapping("/availability/{id}")
    public boolean isAvailable(@PathVariable("id") Integer id){
        return vendorService.isAvailable(id);
    }
}
