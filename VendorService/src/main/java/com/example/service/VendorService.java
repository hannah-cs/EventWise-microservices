package com.example.service;

import com.example.model.Vendor;
import com.example.repository.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {
    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public List<Vendor> getVendors(){
        return vendorRepository.findAll();
    }

    public Optional<Vendor> getVendor(Integer id){
        return vendorRepository.findById(id);
    }

    public void createVendor(Vendor newVendor){
        vendorRepository.save(newVendor);
    }

    public boolean isAvailable(Integer id) {
        Optional<Vendor> vendorOptional = vendorRepository.findById(id);
        return vendorOptional.map(Vendor::isAvailable).orElse(false);
    }

    public Optional<Vendor> updateVendorServices(Integer id, List<String> newServices) {
        Optional<Vendor> vendorOptional = vendorRepository.findById(id);

        if (vendorOptional.isPresent()) {
            Vendor vendor = vendorOptional.get();
            vendor.setServicesOffered(newServices);
            vendorRepository.save(vendor);
        }

        return vendorOptional;
    }


}
