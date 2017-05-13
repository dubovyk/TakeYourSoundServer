package com.dubovyk.Services;

import com.dubovyk.DAO.BandDAO;
import com.dubovyk.Domain.Band;
import com.dubovyk.Domain.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by knidarkness on 08.05.17.
 */
@Service
public interface BandService extends GenericService<Band, Long>{

}
