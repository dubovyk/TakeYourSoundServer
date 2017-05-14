package com.dubovyk.Services;

/**
 * @author Sergey Dubovyk aka knidarkness
 * @version 1.0
 */

import com.dubovyk.DAO.SongDAO;
import com.dubovyk.Domain.Band;
import com.dubovyk.Domain.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service("SongService")
public class SongServiceImpl extends GenericServiceImpl<Song, Long> implements SongService {
    private final BandService bandService;

    @Autowired
    public SongServiceImpl(SongDAO dao, BandService bandService) {
        super(dao);
        this.bandService = bandService;
    }

    @Override
    public void save(Song song){
        Band b = song.getBand();
        if (b != null){
            Band exist = bandService.findBandByName(b.getName());
            if (exist != null){
                song.setBand(exist);
            } else {
                bandService.save(b);
            }
        }
        dao.save(song);
    }

    @Override
    public List<Song> findSongsByEmotions(float happiness){
        List<Song> res = (List) dao.findAll();

        res.sort(new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                int diff;
                diff = (Float.valueOf(Math.abs(o1.getHappiness() - happiness)).compareTo(Math.abs(o2.getHappiness() - happiness)));
                System.out.println("A" + diff);
                return diff;
            }
        });
        System.out.println(res);
        return res;
    }
}
