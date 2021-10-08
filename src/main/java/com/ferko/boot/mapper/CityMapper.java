package com.ferko.boot.mapper;

import com.ferko.boot.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {

    @Select("SELECT `id`,`name`,`state`,`country` FROM city WHERE id=#{id}")
    public City getById(Long id);


    public void insert(City city);
}
