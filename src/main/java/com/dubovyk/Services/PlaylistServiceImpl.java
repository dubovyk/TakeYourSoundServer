package com.dubovyk.Services;

import com.dubovyk.DAO.PlaylistDAO;
import com.dubovyk.Domain.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Sergey Dubovyk aka knidarkness
 * @version 1.0
 */
@Service("PlaylistService")
public class PlaylistServiceImpl extends GenericServiceImpl<Playlist, Long> implements PlaylistService {
    private final PlaylistDAO dao;

    @Autowired
    public PlaylistServiceImpl(PlaylistDAO dao) {
        super(dao);
        this.dao = dao;
    }
}
