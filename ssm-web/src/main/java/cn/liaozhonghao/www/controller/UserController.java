package cn.liaozhonghao.www.controller;

import cn.liaozhonghao.www.pojo.User;
import cn.liaozhonghao.www.service.user.UserService;
import cn.liaozhonghao.www.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 测试 spring mvc
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/getUserById", method = {RequestMethod.POST, RequestMethod.GET})
    public String getUserById(HttpServletRequest request, Model model) {
        //参数
        Integer userId = StringUtils.notNull(request.getParameter("userId")) ? Integer.parseInt(request.getParameter("userId")) : 1;
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "test";
    }
}
