package com.daiba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 *
 * @author　 tinydolphin
 * @date　 2018-05-03  0:37
 * @description　 $
 */
@Controller
@RequestMapping("")
public class PageController{

    @RequestMapping(value = "/", method = {RequestMethod.GET})
    public String index() {
        return "redirect:/Admin/login";
    }

}
