package com.ferko.boot.service.impl;

import com.ferko.boot.bean.City;
import com.ferko.boot.mapper.CityMapper;
import com.ferko.boot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

        @Autowired
        private CityMapper cityMapper;

        public City getCityById(Long id){
            return cityMapper.getById(id);
        }

        public void addCity(City city){
            cityMapper.insert(city);
        }

}
