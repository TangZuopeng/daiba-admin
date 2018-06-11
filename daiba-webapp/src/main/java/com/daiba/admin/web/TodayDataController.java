package com.daiba.admin.web;

import com.daiba.admin.base.AdminBaseController;
import com.daiba.firm.model.Firm;
import com.daiba.todaydata.model.TodayData;
import com.daiba.todaydata.service.TodayDataService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by tinydolphin on 2018/5/11.
 */
@RequestMapping(value = "/Admin")
@Controller
public class TodayDataController extends AdminBaseController {

    @Autowired
    TodayDataService todayDataService;

    @RequestMapping(value = "/todayData", method = {RequestMethod.GET})
    public String todayData(HttpServletRequest request){
        return "admin/today/today";
    }

    @RequestMapping(value = "/todayData.do", method = {RequestMethod.POST})
    @ResponseBody
    public String todayDataInfo(HttpServletRequest request){
        TodayData todayData = todayDataService.getTodayData(request);
        return JSONObject.fromObject(todayData).toString();
    }
}
