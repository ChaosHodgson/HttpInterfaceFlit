package com.zbcm.interfaceflit.service.impl;

import com.zbcm.interfaceflit.common.Constants;
import com.zbcm.interfaceflit.service.InterfaceRequestService;
import com.zbcm.interfaceflit.transbean.FlitJson;
import com.zbcm.interfaceflit.transbean.FlitParam;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaosWang on 2016/07/22.
 */
@Service
public class InterfaceRequestServiceImpl implements InterfaceRequestService {

    private HttpClient httpClient;
    private HttpGet httpGet;
    private HttpPost httpPost;

    private static final Logger logger = LoggerFactory.getLogger(InterfaceRequestServiceImpl.class);

    @Override
    public FlitJson interfaceRequestGet(FlitParam param) {

        FlitJson json = new FlitJson();

        httpGet = new HttpGet(param.getUri());
        httpClient = HttpClients.createDefault();

        try {
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity respEntity = response.getEntity();
            if (respEntity != null) {
                InputStream instream = respEntity.getContent();
                try {
                    //String content = IOUtils.toString(instream, "UTF-8");
                    json.setCode(Constants.SUCCESS);
                    json.setData(IOUtils.toString(instream, "UTF-8"));
                } finally {
                    instream.close();
                }
            }
        } catch (ClientProtocolException e) {
            json.setCode(Constants.EXCEPTION);
            json.setMessage(e.getMessage() + "\n" + e.getStackTrace());
            e.printStackTrace();
        } catch (IOException e) {
            json.setMessage(e.getMessage() + "\n" + e.getStackTrace());
            e.printStackTrace();
        }

        /*	byte[] bytes = content.getBytes();

		String resultContent = "";
		try {
			resultContent = new String(bytes, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

        return json;
    }

    @Override
    public FlitJson interfaceRequestPost(FlitParam param) {

        FlitJson json = new FlitJson();
        /*
         * Create the POST request
		 */

        httpClient = HttpClients.createDefault();
        httpPost = new HttpPost(param.getUri());

        // Request parameters and other properties.
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        if (param.getParamName().length != param.getParamValue().length) {
            json.setCode(Constants.ILLEGAL_PARAMETER);
            json.setMessage("names and values of the parameters are not in pairs");
            return json;
        }

        for (int i = 0; i < param.getParamName().length; i++) {
            String pName = param.getParamName()[i];
            String pValue = param.getParamValue()[i];
            if (pName != null && pValue != null) {
                params.add(new BasicNameValuePair(pName, pValue));
            }
        }

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity respEntity = response.getEntity();

            if (respEntity != null) {
                InputStream instream = respEntity.getContent();
                try {
                    json.setCode(Constants.SUCCESS);
                    json.setData(IOUtils.toString(instream, "UTF-8"));
                } finally {
                    instream.close();
                }
            }
        } catch (ClientProtocolException e) {
            json.setCode(Constants.EXCEPTION);
            json.setMessage(e.getMessage() + "\n" + e.getStackTrace());
            e.printStackTrace();
        } catch (IOException e) {
            json.setCode(Constants.EXCEPTION);
            json.setMessage(e.getMessage() + "\n" + e.getStackTrace());
            e.printStackTrace();
        }

        return json;
    }

    @Override
    public List<FlitJson> flitHttpGet(List<String> uris) {
        List<FlitJson> flits = new ArrayList<>();
        for (String uri : uris) {
            FlitJson flit = new FlitJson();
            httpClient = HttpClients.createDefault();

            httpGet = new HttpGet(uri);
            try {
                HttpResponse response = httpClient.execute(httpGet);
                StatusLine statusLine = response.getStatusLine();
                flit.setCode(statusLine.getStatusCode());
                if (statusLine.getStatusCode()!= 200){
                    flit.setData(false);
                    flit.setMessage("it's in trouble now");
                }else {
                    flit.setMessage("passed");
                    flit.setData(true);
                }
                flits.add(flit);
            } catch (IOException e) {
                logger.warn(e.getMessage(),e);
                e.printStackTrace();
            }
        }
        return flits;
    }


}
