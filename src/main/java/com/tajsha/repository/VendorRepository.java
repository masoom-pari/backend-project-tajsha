package com.tajsha.repository;

import com.tajsha.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
//    Vendor updateVendor(Long id, Vendor vendorDetails);
    // Is interface ke zariye hum database mein data save aur fetch karenge
}