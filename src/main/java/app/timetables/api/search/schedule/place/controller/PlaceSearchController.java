package app.timetables.api.search.schedule.place.controller;

import app.timetables.api.schedule.domain.Place;
import app.timetables.api.schedule.service.PlaceRepository;
import app.timetables.api.search.schedule.place.PlaceSearchQuery;
import java.util.Optional;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping(value = "/places/search", produces = "application/json")
public class PlaceSearchController {

    @Autowired
    private PlaceRepository placeRepository;

    public ResponseEntity<Place> getById(Long id) {
        return ResponseEntity.of(placeRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<Iterable<Place>> search(@RequestBody PlaceSearchQuery placeSearchQuery) {
        return ResponseEntity.of(Optional.of(placeRepository.findAll()));
    }

}

