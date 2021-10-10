package com.ferko.boot.mapper;

import com.ferko.boot.bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {

    @Select("SELECT `id`,`name`,`state`,`country` FROM city WHERE id=#{id}")
    public City getById(Long id);

    //不使用配置文件，使用注解配置 useGeneratedKeys keyProperty
    @Insert("INSERT INTO city(`id`,`name`,`state`,`country`) VALUES(#{id},#{name},#{state},#{country});")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public void insert(City city);
}
