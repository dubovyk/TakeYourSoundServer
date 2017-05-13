package com.dubovyk.Controllers;

import com.dubovyk.Domain.Band;
import com.dubovyk.Domain.BandWrapperObject;
import com.dubovyk.DAO.BandDAO;
import com.dubovyk.Services.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by knidarkness on 07.05.17.
 */
@Controller
@RequestMapping(path = "/band")
public class BandController {
    @Autowired
    private BandService bandService;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Band> getAll(){
        return bandService.findAll();
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addBand(@RequestBody BandWrapperObject body){
        Band newBand = new Band();
        newBand.setName(body.getName());
        bandService.save(newBand);
        return "added";
    }

}

