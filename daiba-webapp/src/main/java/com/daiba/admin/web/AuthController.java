package com.daiba.admin.web;

import com.daiba.firm.model.Firm;
import com.daiba.global.DataTableResultVO;
import com.daiba.user.model.Address;
import com.daiba.user.model.QualApplyUser;
import com.daiba.user.model.User;
import com.daiba.user.service.QualificationService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by stphen on 2018/6/11.
 */
@Controller
@RequestMapping("/Admin")
public class AuthController {

    @Autowired
    QualificationService qualificationService;

    @RequestMapping(value = "/auth",method = {RequestMethod.GET})
    public String firmList(){
        return "admin/auth/authlist";
    }

    @RequestMapping(value = "/loadAuth.do",method = {RequestMethod.POST})
    @ResponseBody
    public String loadAuth(){
        try {
            List<QualApplyUser> quals=qualificationService.getQualificationByStaId(20);
            DataTableResultVO<QualApplyUser> result=new DataTableResultVO<>();
            result.setData(quals);//data参数。
            result.setRecordsTotal(quals.size());//数据的条数
            result.setRecordsFiltered(quals.size());//过滤后数据的条数
            return JSONObject.fromObject(result).toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/toAuth",method = RequestMethod.GET)
    public String lookupFirmDetail(HttpServletRequest request){
        return "admin/auth/auth";
    }

}
