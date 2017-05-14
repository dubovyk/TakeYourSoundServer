package com.dubovyk.DAO;

import com.dubovyk.Domain.Song;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by knidarkness on 07.05.17.
 */
public interface SongDAO extends CrudRepository<Song, Long>{
}
