package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;

import java.util.List;
//MuzixService interface//
public interface MuzixService {

    public Track saveTrack(Track track) throws TrackAlreadyExistsException;

    public List<Track> getAllTracks() ;

    public void deleteById(String trackId) throws TrackNotFoundException;

    public Track updateTrack(Track track) ;

    public Track findTrackByName(String trackName);
}
