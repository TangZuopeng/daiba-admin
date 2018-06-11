package com.daiba.admin.base;

import com.daiba.admin.model.Admin;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Map;

/**
 *
 * @author　 tinydolphin
 * @date　 2018-05-17  12:39
 * @description　 $
 */
@Controller
public class AdminBaseController {

    /**用于获取request的参数，减少request.getParam的使用，便于使用*/
    Map<String,Object> paramMap=new HashedMap();

    protected Boolean isLogin(HttpSession session) {
        //System.out.println(session.getAttribute("ISONLINE"));
        //return true;
        if (session.getAttribute("ADMINISONLINE") == null) {
            return false;
        }
        return (Boolean) session.getAttribute("ADMINISONLINE");
    }

    /**
     * 获取存储到session的管理员信息
     * @param request
     * @return
     * @author　 qiuyong
     */
    public Admin getUserInfo(HttpServletRequest request) {
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        return admin;
    }

    /**
     * 获取request里面的参数
     * @return
     */
    public Map<String,Object> getRequestParams(HttpServletRequest request){
        Enumeration pNames=request.getParameterNames();
        while(pNames.hasMoreElements()){
            String name=(String)pNames.nextElement();
            String value=request.getParameter(name);
            paramMap.put(name,value);
        }
        return paramMap;
    }




}
