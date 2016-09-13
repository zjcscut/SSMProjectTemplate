package cn.zjc.controller;

import cn.zjc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhangjinci
 * @version 2016/9/13 16:52
 * @function
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "index.html")
    public String index(@RequestParam("id") Integer id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.findUser(id));
        return "index";
    }
}
