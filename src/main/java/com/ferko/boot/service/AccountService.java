package com.ferko.boot.service;

import com.ferko.boot.bean.Account;
import com.ferko.boot.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public Account getAccountById(Long id){
        return accountMapper.gerAccount(id);
    }

}
