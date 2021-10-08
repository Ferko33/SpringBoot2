package com.ferko.boot.mapper;

import com.ferko.boot.bean.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    public Account gerAccount(Long id);
}
