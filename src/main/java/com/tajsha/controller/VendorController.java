package com.tajsha.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import com.tajsha.model.Vendor;
import com.tajsha.service.VendorService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/vendors")
//@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @GetMapping
    public List<Vendor> getVendors() {

        return vendorService.getAllVendors();
    }

    @PostMapping
    public Vendor addVendor(@RequestBody Vendor vendor) {

        return vendorService.saveVendor(vendor);
    }

    // DELETE request yahan aayegi
    @DeleteMapping("/{id}")
    public void deleteVendor(@PathVariable Long id) {
        vendorService.deleteVendor(id);
    }

    // PUT (Update) request yahan aayegi
    @PutMapping("/{id}")
    public Vendor updateVendor(@PathVariable Long id, @RequestBody Vendor vendorDetails) {
        return vendorService.updateVendor(id, vendorDetails);
    }
}

