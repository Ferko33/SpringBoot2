package com.ferko.boot.service.impl;

import com.ferko.boot.bean.Account;
import com.ferko.boot.mapper.AccountMapper;
import com.ferko.boot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public Account getAccountById(Long id) {
        return accountMapper.gerAccount(id);
    }

}
