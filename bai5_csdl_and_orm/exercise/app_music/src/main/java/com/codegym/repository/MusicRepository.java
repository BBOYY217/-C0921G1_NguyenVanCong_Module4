package com.codegym.repository;

import com.codegym.model.Music;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MusicRepository {
    List<Music> findAll();
    Music save(Music musicObj);
    Music findById(int id);
    Music update(Music musicObj);
    void delete(int id);
    List<Music> searchByName (String string);
}

