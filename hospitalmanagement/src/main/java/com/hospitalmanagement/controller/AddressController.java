package com.hospitalmanagement.controller;

import com.hospitalmanagement.entity.Address;
import com.hospitalmanagement.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/addresses")
@CrossOrigin(origins = "*")
public class AddressController {

    @Autowired
    private AddressService addressService;

    //  Add Address
    @PostMapping
    public ResponseEntity<Address> addAddress(@RequestBody Address address) {
        return ResponseEntity.ok(addressService.addAddress(address));
    }

    //  Get All Addresses
    @GetMapping
    public ResponseEntity<List<Address>> getAll() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    //  Get Address by ID
    @GetMapping("/{id}")
    public ResponseEntity<Address> getById(@PathVariable int id) {
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

    //  Update Address
    @PutMapping("/{id}")
    public ResponseEntity<Address> update(@PathVariable int id, @RequestBody Address address) {
        return ResponseEntity.ok(addressService.updateAddress(id, address));
    }

    //  Delete Address by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        addressService.deleteAddressById(id);
        return ResponseEntity.noContent().build();
    }

    //  Delete All
    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        addressService.deleteAllAddresses();
        return ResponseEntity.noContent().build();
    }
}
