package com.zbcm.interfaceflit.service;

import com.zbcm.interfaceflit.transbean.FlitJson;
import com.zbcm.interfaceflit.transbean.FlitParam;

import java.util.List;

/**
 * Created by ChaosWang on 2016/07/22.
 */
public interface InterfaceRequestService {

        public FlitJson interfaceRequestGet(FlitParam param);

        public FlitJson interfaceRequestPost(FlitParam param);

        public List<FlitJson> flitHttpGet(List<String> uris);
}
