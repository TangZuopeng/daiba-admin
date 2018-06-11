package com.daiba.weixin.service;

import org.jdom.JDOMException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * @author　 tinydolphin
 * @date　 2018-5-15  16:34
 * @description　 $
 */
public interface PaymentService {

    public Map postPayMessage(String firmId, String fee, int userId, String openid, HttpServletRequest request) throws IOException, JDOMException;



}
