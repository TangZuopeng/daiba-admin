package com.daiba.weixin.service.impl;

import com.daiba.utils.*;
import com.daiba.weixin.WX;
import com.daiba.weixin.service.PaymentService;
import org.jdom.JDOMException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author　 tinydolphin
 * @date　 2018-5-15  16:34
 * @description　 $
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

    public Map postPayMessage(String firmId, String fee, int userId, String openid, HttpServletRequest request) throws IOException, JDOMException {

        Map<String, String> params = new HashMap<String,String>();
        params.put("appid", WX.AppID);
        params.put("mch_id", ConfigUtil.MCH_ID);
        params.put("nonce_str", RandomString.getRandomString(32));
        params.put("body", ConfigUtil.PRODUCTS_DESCRIPTION);
        params.put("device_info", "WEB");
        params.put("out_trade_no", firmId);
        params.put("spbill_create_ip", GetHostIp.getIpAddr(request));
        params.put("notify_url", ConfigUtil.NOTIFY_URL);
        params.put("trade_type", "JSAPI");
        params.put("openid", openid);
        params.put("total_fee", fee);
        String sign = Signature.getSign(params);
        params.put("sign", sign);
        String requestXML = XMLUtil.getRequestXml(params);
        String result = HTTPRequest.ajax(ConfigUtil.UNIFIED_ORDER_URL, requestXML, HTTPRequest.POST);
        Map<String, String> map = XMLUtil.doXMLParse(result);//解析微信返回的信息，以Map形式存储便于取值
        return map;

    }


}
