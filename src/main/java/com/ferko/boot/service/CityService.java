package com.ferko.boot.service;

import com.ferko.boot.bean.City;
import com.ferko.boot.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    private CityMapper cityMapper;

    public City getCityById(Long id){
        return cityMapper.getById(id);
    }

    public void addCity(City city){
        cityMapper.insert(city);
    }
}
