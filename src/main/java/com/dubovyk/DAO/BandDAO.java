package com.dubovyk.DAO;

import com.dubovyk.Domain.Band;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by knidarkness on 07.05.17.
 */
public interface BandDAO extends CrudRepository<Band, Long>{
    Band findBandByName(String name);
}
