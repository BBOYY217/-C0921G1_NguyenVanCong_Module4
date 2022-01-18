package com.codegym.service;

import com.codegym.model.Music;

import java.util.List;

public interface MusicService {
    List<Music> findAll ();
    void save (Music music);
    Music findById (int id);
    void delete (int id);
    List<Music> searchByName (String string);
    void update(int id, Music musicObj);
}
