package com.ferko.boot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootTest
class Boot03ThymeleafApplicationTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from account_tbl;");
        Long aLong = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM account_tbl", Long.class);
        log.info("记录数：{}",aLong);
    }

}
