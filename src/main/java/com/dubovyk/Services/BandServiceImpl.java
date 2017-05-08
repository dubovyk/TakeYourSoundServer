package com.dubovyk.Services;

import com.dubovyk.DAO.BandDAO;
import com.dubovyk.Domain.Band;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by knidarkness on 08.05.17.
 */
@Service("BandService")
public class BandServiceImpl implements BandService{
    @Autowired
    private BandDAO bandDAO;

    @Transactional
    public Iterable<Band> findAll(){
        return bandDAO.findAll();
    }

    @Transactional
    public Iterable<Band> findWithIdLessThen(Long id){
        return bandDAO.findAllByIdBefore(id);
    }

    @Transactional
    public Iterable<Band> getByNameLike(String pattern){
        return bandDAO.findAllByNameLike(pattern);
    }

    @Transactional
    public void save(Band band){
        bandDAO.save(band);
    }
}
