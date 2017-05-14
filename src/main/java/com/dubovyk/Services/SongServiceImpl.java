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
}
