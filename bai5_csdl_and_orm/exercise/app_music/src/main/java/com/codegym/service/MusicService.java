package com.codegym.service;

import com.codegym.model.Music;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MusicService {
    List<Music> findAll ();
    Music save (Music music);
    Music findById (int id);
    void delete (int id);
    List<Music> searchByName (String string);
    void update(int id, Music musicObj);
}
