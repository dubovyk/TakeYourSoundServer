package com.dubovyk.Controllers;

import com.dubovyk.Domain.Song;
import com.dubovyk.Services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @author Nina Bondar aka kaguya
 * @author Sergey Dubovyk aka knidarkness
 */

@RestController
@RequestMapping(path = "/song")
public class SongController {
    private final SongService service;

    @Autowired
    public SongController(SongService service) {
        this.service = service;
    }

    @CrossOrigin
    @GetMapping(path = "all")
    public @ResponseBody Iterable<Song> findAll(){
        return service.findAll();
    }

    @CrossOrigin
    @PostMapping(path = "add")
    public @ResponseBody Map<String, String> add(@RequestBody Song song){
        service.save(song);
        Map<String, String> res = new HashMap<>();
        res.put("status", "added");
        res.put("name", song.getName());
        res.put("lyrics", song.getLyrics());
        res.put("band", song.getBand().getName());
        return res;
    }

    @CrossOrigin
    @GetMapping(path = "getByEmotions")
    public @ResponseBody List<Song> findByEmotions(@RequestParam float happiness, @RequestParam float motivation, @RequestParam float excitement, @RequestParam(required = false) Integer size){
        List<Song> res;
        if(size == null){
            res = service.findSongsByEmotions(happiness, motivation, excitement);
        } else {
            res = service.findSongsByEmotions(happiness, motivation, excitement, size);
        }
        System.out.println(res);
        return res;
    }
}
