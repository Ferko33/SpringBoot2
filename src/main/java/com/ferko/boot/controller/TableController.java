package com.ferko.boot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ferko.boot.bean.User;
import com.ferko.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TableController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn",defaultValue = "1") Integer pnNum,
                             RedirectAttributes redirectAttributes) {
        boolean isSuccess = userService.removeById(id);
        if (!isSuccess) {
            return "/index";
        }
        redirectAttributes.addAttribute("pn",pnNum);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/basic_table")
    public String basic_table() {
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model,
                                @RequestParam(value = "pn", defaultValue = "1") Integer pnNum) {
        //表格内容的遍历
//        List<User> users = Arrays.asList(new User("zhangsan", "123456"),
//                new User("lisi", "aaaaaa"),
//                new User("haha", "aaabbb"),
//                new User("hehe", "aaabbb"));
//
//        model.addAttribute("users", users);
        //从数据库中查询User进行展示
        List<User> userList = userService.list();
        Page<User> userPage = new Page<>(pnNum, 2);
        Page<User> page = userService.page(userPage, null);
        //注意：这里处理完 只能显示当前页数，显示不了页数和统计数，
        // 需要配合MyBatisPlus的分页插件才能正常使用
        model.addAttribute("userPage", page);

        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table() {
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table() {
        return "table/editable_table";
    }
}
