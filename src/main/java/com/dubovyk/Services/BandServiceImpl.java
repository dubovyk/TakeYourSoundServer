package com.dubovyk.Services;

import com.dubovyk.DAO.BandDAO;
import com.dubovyk.Domain.Band;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by knidarkness on 08.05.17.
 */
@Service("BandService")
public class BandServiceImpl extends GenericServiceImpl<Band, Long> implements BandService{
    private final BandDAO dao;

    @Autowired
    public BandServiceImpl(BandDAO dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    public Band findBandByName(String name){
        return dao.findBandByName(name);
    }
}
