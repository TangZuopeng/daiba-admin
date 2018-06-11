package com.daiba.admin.web;

import com.daiba.admin.base.AdminBaseController;
import com.daiba.firm.model.Firm;
import com.daiba.global.DataTableResultVO;
import com.daiba.user.model.Address;
import com.daiba.user.model.Qualification;
import com.daiba.user.model.User;
import com.daiba.user.service.PersonalService;
import com.daiba.user.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by tinydophin on 2018/5/11.
 */
@RequestMapping(value = "/Admin")
@Controller
public class UserController extends AdminBaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private PersonalService personalService;

    @RequestMapping("/loadUser.do")
    @ResponseBody
    public String loadUsers() {
        List<User> users=userService.getAllUserInfo();
        DataTableResultVO<User> result=new DataTableResultVO<>();
        try{
            result.setData(users);//data参数。
            result.setRecordsTotal(users.size());//数据的条数
            result.setRecordsFiltered(users.size());//过滤后数据的条数
            return JSONObject.fromObject(result).toString();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/lookupUserDetail", method = RequestMethod.GET)
    public ModelAndView lookupUserDetail(HttpServletRequest request) {
        String phoneNum=request.getParameter("phoneNum");
        try {
            User user = userService.getUserInfoByPhoneNum(phoneNum);
            String role = user.getRole();
            if("带客".equals(role)){
                Qualification qualification = personalService.getQualificationInfo(user.getUserId());
                request.setAttribute("qualification",qualification);
            }
            request.setAttribute("user",user);
            return new ModelAndView("admin/user/lookUser");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
