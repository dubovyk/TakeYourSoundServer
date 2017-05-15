package com.dubovyk.Services;

import com.dubovyk.Domain.Song;

import java.util.List;

/**
 * This is an interface for working with
 * songs. Obviously.
 *
 * @author Sergey Dubovyk aka knidarkness
 * @version 1.0
 */
public interface SongService extends GenericService<Song, Long>{
    List<Song> findSongsByEmotions(float happiness, float motivation, float excitement);
    List<Song> findSongsByEmotions(float happiness, float motivation, float excitement, int length);
}
