package com.daiba.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author　 tinydolphin
 * @date　 2018-05-11  18:31
 * @description　 错误信息管理页
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping(value = "/authorize", method = {RequestMethod.GET})
    public String authorize() {
        return "error/authorize_error";
    }

}
