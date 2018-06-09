package com.daiba.admin.web;

import com.daiba.admin.base.AdminBaseController;
import com.daiba.firm.model.Firm;
import com.daiba.firm.service.FirmService;
import com.daiba.global.DataTableResultVO;
import com.daiba.user.model.Address;
import com.daiba.user.model.Qualification;
import com.daiba.user.model.User;
import com.daiba.user.service.BringerService;
import com.daiba.user.service.PersonalService;
import com.daiba.user.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.daiba.utils.JSONUtils.objectMapper;

/**
 * Created by Administrator on 2016/12/28.
 */
@Controller
@RequestMapping("/Admin")
public class FirmController extends AdminBaseController{
    @Autowired
    FirmService firmService;

    @Autowired
    UserService userService;

    @Autowired
    PersonalService personalService;

    @Autowired
    BringerService bringerService;

    @RequestMapping(value = "/firm",method = {RequestMethod.GET})
    public String firmList(){
        return "admin/firm/firmlist";
    }

    @RequestMapping(value = "/loadFirms.do",method = {RequestMethod.POST})
    @ResponseBody
    public String loadFirms(){
        try {
            List<Firm> firms=firmService.loadFirmsToAdmin();
            DataTableResultVO<Firm> result=new DataTableResultVO<>();
            result.setData(firms);//data参数。
            result.setRecordsTotal(firms.size());//数据的条数
            result.setRecordsFiltered(firms.size());//过滤后数据的条数
            return JSONObject.fromObject(result).toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/lookupFirmDetail",method = RequestMethod.GET)
    public ModelAndView lookupFirmDetail(HttpServletRequest request){
        String firmId=request.getParameter("firmId");
        try {
            Firm firm=firmService.loadFirmDetailToAdmin(firmId);
            int orderState=firm.getOrderState();
            int briId= firm.getBriId();
            if(orderState==1||orderState==2){
                User bringer=userService.getAcceptUserInfo(briId);
                String briRealName = personalService.getBringerRealName(briId);
                Address briAdd = bringerService.getBrierAddress(briId);
                request.setAttribute("bringer", bringer);
                request.setAttribute("briRealName", briRealName);
                request.setAttribute("briAdd", briAdd);
            }else{
                request.setAttribute("bringer",null);
            }
            request.setAttribute("firm",firm);
            return new ModelAndView("admin/firm/lookFirm");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 取消订单
     *
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = "/cancelFirm.do", method = {RequestMethod.POST})
    @ResponseBody
    public String cancelFirm(HttpSession session, HttpServletRequest request) {
        Map<String, Object> cancelMessages = new HashMap<String, Object>();
        String firmId = request.getParameter("firmId");
        String userId = request.getParameter("userId");
        User user = userService.getSendUserInfo(Integer.parseInt(userId));
        int flag = firmService.cancelFirm(firmId, user.getPhoneNum());
        cancelMessages.put("cancelMessage", flag);
        try {
            return objectMapper.writeValueAsString(cancelMessages);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
