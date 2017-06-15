package com.zbcm.interfaceflit.controller;

import com.zbcm.interfaceflit.common.Constants;
import com.zbcm.interfaceflit.service.InterfaceRequestService;
import com.zbcm.interfaceflit.transbean.FlitJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zbcm.interfaceflit.transbean.FlitParam;

@Controller
public class InterfaceFlitController {

    @Autowired
    private InterfaceRequestService interfaceUriService;



    @RequestMapping(value = {"/index"})
    public String index() {








        return "/index";
    }


    @RequestMapping(value = "/flit")
    public String flit() {

        return "/flit";
    }

    @RequestMapping(value = "/request", method = RequestMethod.GET)
    public String uriRequest() {
        return "/request";
    }


    @RequestMapping(value = "/request", method = RequestMethod.POST)
    @ResponseBody
    public FlitJson interfaceFlit(FlitParam param) {
        FlitJson json = new FlitJson();
        if (param.getUri() == null) {
            json.setCode(Constants.ILLEGAL_PARAMETER);
            json.setMessage("uri not allowed null");
            return json;
        }

        if (param.getMethod() == 0) {  //get
            json = interfaceUriService.interfaceRequestGet(param);
        } else {
            json = interfaceUriService.interfaceRequestPost(param);
        }

        return json;
    }

}
