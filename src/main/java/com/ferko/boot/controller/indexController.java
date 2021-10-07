package com.ferko.boot.controller;

import com.ferko.boot.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class indexController {

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
    public String mainPage(HttpSession session,Model model) {
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
