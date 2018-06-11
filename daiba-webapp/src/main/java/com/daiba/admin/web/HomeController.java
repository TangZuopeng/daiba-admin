package com.daiba.admin.web;

import com.daiba.admin.base.AdminBaseController;
import com.daiba.user.model.User;
import com.daiba.user.service.UserService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 *
 * @author tinydolphin
 * @date 2017-05-10  11:10
 */
@RequestMapping(value = "/Admin")
@Controller
public class HomeController extends AdminBaseController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/home", method = {RequestMethod.GET})
    public String index(HttpSession session) {
        if(isLogin(session)){
            return "admin/user/userlist";
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
        DateTime dateTime = new DateTime((new Date()));
        return userService.getUserInfoByTime(dateTime.withTimeAtStartOfDay().toDate(), dateTime.millisOfDay().withMaximumValue().toDate());
    }
}
