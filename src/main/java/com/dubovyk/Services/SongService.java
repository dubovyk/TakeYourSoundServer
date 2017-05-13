package com.dubovyk.Services;

import com.dubovyk.Domain.Song;

/**
 * This is an interface for working with
 * songs. Obviously.
 *
 * @author Sergey Dubovyk aka knidarkness
 * @version 1.0
 */
public interface SongService {
    void save(Song song);
    void update(Song song);
    void delete(Song song);
    void deleteById(Long id);
}
