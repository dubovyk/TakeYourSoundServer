package com.dubovyk.DAO;

import com.dubovyk.Domain.Song;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by knidarkness on 07.05.17.
 */
public interface SongDAO extends CrudRepository<Song, Long>{
}
