package com.ferko.boot.service;

import com.ferko.boot.bean.City;

public interface CityService {


    public City getCityById(Long id);

    public void addCity(City city);
}
