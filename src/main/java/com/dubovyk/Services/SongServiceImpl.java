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
    public List<Song> findSongsByEmotions(float happiness, float motivation, float excitement){
        List<Song> res = (List) dao.findAll();

        res.sort(new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                int diff;
                float o1_happiness_dist = (float) Math.pow(o1.getHappiness() - happiness, 2);
                float o1_motivation_dist = (float) Math.pow(o1.getMotivation() - motivation, 2);
                float o1_excitement_dist = (float) Math.pow(o1.getExcitement() - excitement, 2);

                float o2_happiness_dist = (float) Math.pow(o2.getHappiness() - happiness, 2);
                float o2_motivation_dist = (float) Math.pow(o2.getMotivation() - motivation, 2);
                float o2_excitement_dist = (float) Math.pow(o2.getExcitement() - excitement, 2);

                float o1_dist = (float) Math.sqrt(o1_happiness_dist + o1_motivation_dist + o1_excitement_dist);
                float o2_dist = (float) Math.sqrt(o2_happiness_dist + o2_motivation_dist + o2_excitement_dist);

                diff = Float.valueOf(o1_dist).compareTo(o2_dist);
                return diff;
            }
        });
        return res;
    }
}
