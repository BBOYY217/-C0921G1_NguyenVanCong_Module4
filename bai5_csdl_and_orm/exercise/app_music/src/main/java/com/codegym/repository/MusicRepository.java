package com.codegym.repository;

import com.codegym.model.Music;

import java.util.List;

public interface MusicRepository {
    List<Music> findAll();
    void save(Music musicObj);
    Music findById(int id);
    Music update(Music musicObj);
    void delete(int id);
    List<Music> searchByName (String string);

}

