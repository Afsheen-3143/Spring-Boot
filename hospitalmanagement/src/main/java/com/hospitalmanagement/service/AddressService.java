package com.hospitalmanagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.hospitalmanagement.entity.Address;
import com.hospitalmanagement.entity.Patient;
import com.hospitalmanagement.repository.AddressRepo;
import com.hospitalmanagement.repository.PatientRepo;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private PatientRepo patientRepo;

    public Address addAddress(Address address) {
        if (address.getCity() == null || address.getPincode() == null ||
            address.getState() == null || address.getStreet() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Address fields cannot be empty");
        }

        if (address.getPatient() != null) {
            int patientId = address.getPatient().getPatientId();
            Patient patient = patientRepo.findById(patientId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found"));
            address.setPatient(patient);
        }

        return addressRepo.save(address);
    }

    public List<Address> getAllAddresses() {
        return addressRepo.findAll();
    }

    public Address getAddressById(int id) {
        return addressRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found"));
    }

    public Address updateAddress(int id, Address updatedAddress) {
        Address existing = getAddressById(id);
        existing.setCity(updatedAddress.getCity());
        existing.setPincode(updatedAddress.getPincode());
        existing.setState(updatedAddress.getState());
        existing.setStreet(updatedAddress.getStreet());

        if (updatedAddress.getPatient() != null) {
            int patientId = updatedAddress.getPatient().getPatientId();
            Patient patient = patientRepo.findById(patientId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found"));
            existing.setPatient(patient);
        }

        return addressRepo.save(existing);
    }

    public void deleteAddressById(int id) {
        if (!addressRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address ID not found");
        }
        addressRepo.deleteById(id);
    }

    public void deleteAllAddresses() {
        addressRepo.deleteAll();
    }
}
