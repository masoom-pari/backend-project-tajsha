package com.tajsha.service;

import com.tajsha.model.Vendor;
import com.tajsha.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    // Database se saare vendors ki list lana
    public List<Vendor> getAllVendors() {

        return vendorRepository.findAll();
    }

    // Naya vendor add karna
    public Vendor saveVendor(Vendor vendor) {

        return vendorRepository.save(vendor);
    }
/// Delete karne ke liye
public void deleteVendor(Long id) {
    vendorRepository.deleteById(id);
}

    // Update karne ke liye
    public Vendor updateVendor(Long id, Vendor vendorDetails) {
        Vendor vendor = vendorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendor nahi mila!"));

        vendor.setName(vendorDetails.getName());
        vendor.setCategory(vendorDetails.getCategory());
        vendor.setPrice(vendorDetails.getPrice());

        return vendorRepository.save(vendor);
    }



}