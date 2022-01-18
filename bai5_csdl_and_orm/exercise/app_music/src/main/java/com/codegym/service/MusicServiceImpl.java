package com.codegym.service;

import com.codegym.model.Music;
import com.codegym.repository.MusicRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicRepositoryImpl musicRepository;


    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public void save(Music musicObj) {
        musicRepository.save(musicObj);
    }

    @Override
    public Music findById(int id) {
        return musicRepository.findById(id);
    }

    @Override
    public void update(int id, Music musicObj) {
        musicRepository.update(musicObj);
    }

    @Override
    public void delete(int id) {
        musicRepository.delete(id);
    }

    @Override
    public List<Music> searchByName(String string) {
        return musicRepository.searchByName(string);
    }
}
