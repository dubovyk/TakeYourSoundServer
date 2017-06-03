package com.dubovyk.DAO;

import com.dubovyk.Domain.Playlist;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Sergey Dubovyk aka knidarkness
 * @version 1.0
 */
public interface PlaylistDAO extends CrudRepository<Playlist, Long> {

}
