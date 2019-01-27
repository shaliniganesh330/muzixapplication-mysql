package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MuzixRepository extends JpaRepository<Track,Integer> {
    @Query(value = "SELECT m FROM Track m where m.trackName = ?1")
    public Track findTrackByName(String trackName);
}


