package com.ferko.boot.controller;

import com.ferko.boot.bean.Account;
import com.ferko.boot.bean.City;
import com.ferko.boot.bean.User;
import com.ferko.boot.service.AccountService;
import com.ferko.boot.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Controller
public class indexController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CityService cityService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping("/addCity")
    @ResponseBody
    public City addCity(City city) {
        cityService.addCity(city);
        return city;
    }

    @GetMapping("/city")
    @ResponseBody
    public City getCityById(@RequestParam("cid") Long id) {
        log.info("id是：{}", id);
        return cityService.getCityById(id);
    }

    @GetMapping("/acct/{id}")
    @ResponseBody
    public Account getById(@PathVariable("id") long id) {
        return accountService.getAccountById(id);
    }

    /**
     * 去登录页
     *
     * @return
     */
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    /**
     * @param user
     * @return
     */
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if (StringUtils.hasLength(user.getUserName()) && StringUtils.hasLength(user.getPassWord())) {
            log.info("登录成功");
            session.setAttribute("loginUser", user);
            //登录成功重定向到 main.html 页面（重定向，url地址栏的地址会改变，http://127.0.0.1:8080/main.html
            // 此时刷新，只会重复访问 main.html ,不会重复提交表单）
            return "redirect:/main.html";
        }
        model.addAttribute("erroMsg", "账号密码错误");
        log.info("账号密码错误");
        return "login";
    }

    /**
     * 间接接收 /main.html 请求  去main页面
     *
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {
        HashOperations<String, String,String> operations = redisTemplate.opsForHash();
        String s = operations.get("/main.html", new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString());
        String s1 = operations.get("/basic_table", new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString());

        model.addAttribute("mainCount",s);
        model.addAttribute("basic_tableCount",s1);
        //判断是否登录， 理论上应该使用 拦截器、过滤器机制，这里先暂且略过
//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser != null){
        return "main";
//        }
//        model.addAttribute("erroMsg", "未登录，请重新登录");
//        log.info("未登录，请重新登录");
//        return "/login";
    }
}
