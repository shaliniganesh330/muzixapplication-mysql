package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.service.MuzixService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class MuzixController {
    private MuzixService muzixService;

    public MuzixController(MuzixService muzixService) {
        this.muzixService = muzixService;
    }

    //Saving track information such as trackId,trackcomments,trackname//
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) {
        ResponseEntity responseEntity;
        try {
            muzixService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    //Displaying saved track.//
    @GetMapping("tracks")
    public ResponseEntity<?> getAllTracks() {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<List<Track>>(muzixService.getAllTracks(), HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    //Removing track.//
    @DeleteMapping("track/{trackId}")
    public ResponseEntity<?> deleteById(@PathVariable String trackId) {
        ResponseEntity responseEntity;
        try {
            muzixService.deleteById(trackId);
            responseEntity = new ResponseEntity<List<Track>>(muzixService.getAllTracks(), HttpStatus.FOUND);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    //Update track.//
    @PutMapping("track")
    public ResponseEntity<?> updateUser(@RequestBody Track track) {
        ResponseEntity responseEntity;
        try {
            muzixService.updateTrack(track);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    //@Query and parameter passing to @Query//
    @GetMapping("track/{trackName}")
    public ResponseEntity<?> findTrackByName(@PathVariable String trackName) {
        ResponseEntity responseEntity;
        try {

            responseEntity = new ResponseEntity<Track>(muzixService.findTrackByName(trackName), HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
}

