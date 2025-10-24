package com.event.event.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.event.event.Model.Evententity;
import com.event.event.repository.Eventrepository;


@Service
public class Eventservice {

    @Autowired
    private Eventrepository repo;

    // Get all events
    public List<Evententity> getallevents() {
        return repo.findAll();
    }

    // Get event by ID
    public Optional<Evententity> geteventbyid(int id) {
        return repo.findById(id);
    }

    // Add event
    public Evententity addevent(Evententity e) {
        return repo.save(e);
    }

    // Full Update (PUT)
    public Evententity updateevent(int id, Evententity e) {
        Optional<Evententity> event = repo.findById(id);
        if (event.isPresent()) {
            Evententity entity = event.get();
            entity.setName(e.getName());
            entity.setLocation(e.getLocation());
            entity.setDate(e.getDate());
            entity.setOrganizer(e.getOrganizer());
            return repo.save(entity);
        }
        return null;
    }

    // Partial Update (PATCH)
    public Evententity updatepartially(int id, Evententity e) {
        Optional<Evententity> event = repo.findById(id);
        if (event.isPresent()) {
            Evententity entity = event.get();
            if (e.getName() != null) entity.setName(e.getName());
            if (e.getDate() != null) entity.setDate(e.getDate());
            if (e.getLocation() != null) entity.setLocation(e.getLocation());
            if (e.getOrganizer() != null) entity.setOrganizer(e.getOrganizer());
            return repo.save(entity);
        }
        return null;
    }

    // Delete by ID
    public String deletebyid(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Deleted successfully: " + id;
        }
        return "ID not found";
    }

    // Delete all
    public String deleteall() {
        repo.deleteAll();
        return "Deleted all successfully";
    }
}
