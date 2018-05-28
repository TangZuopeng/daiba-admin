package com.daiba.admin.web;

import com.daiba.admin.base.AdminBaseController;
import com.daiba.user.model.User;
import com.daiba.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛Code is far away from bug with the animal protecting
 * 　　　　┃　　　┃    神兽保佑,代码无bug
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * <p/>
 * ━━━━━━感觉萌萌哒━━━━━━
 *
 * @author xiaoTao
 * @date 2016-04-10  11:10
 */
@RequestMapping(value = "/Admin")
@Controller
public class HomeController extends AdminBaseController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/home", method = {RequestMethod.GET})
    public String index(HttpSession session) {
        if(isLogin(session)){
            return "admin/home/index";
        }else{
            return "redirect:/Admin/login";
        }
    }

    @RequestMapping(value = "/user", method = {RequestMethod.GET})
    public String user(){
        return "admin/user/userlist";
    }

    @RequestMapping(value = "/loadHome.do",method = {RequestMethod.POST})
    @ResponseBody
    public List<User> loadHome() {
        return userService.getAllUserInfo();
    }
}
