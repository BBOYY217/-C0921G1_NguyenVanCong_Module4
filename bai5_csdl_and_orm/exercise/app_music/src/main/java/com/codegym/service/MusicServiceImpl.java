package com.codegym.service;

import com.codegym.model.Music;
import com.codegym.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicRepository musicRepository;

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public Music save(Music musicObj) {
       return musicRepository.save(musicObj);
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
