package com.zbcm.interfaceflit.test;


import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChaosWang on 2016/06/17.
 */
public class TestInterfaceFlit {


    @Test
    public void testapp() {
        int minx = 0;
        int maxx = 10 ^ 7;

        String content = "";

			/*
             * Create the POST request
			 */
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://uuser.zjzwfw.gov.cn/external/appFrLogin.do");

        // Request parameters and other properties.
        List<NameValuePair> params = new ArrayList<NameValuePair>();


        String pname = "";
        String pvalue = "";
        if (pname != null && pvalue != null) {
            params.add(new BasicNameValuePair(pname, pvalue));
        }

        try {
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity respEntity = response.getEntity();

            if (respEntity != null) {
                InputStream instream = respEntity.getContent();
					/*
					 * try { // do something useful } finally {
					 * instream.close(); }
					 */

                //content = EntityUtils.toString(respEntity);
                try {
                    content = IOUtils.toString(instream, "UTF-8");
                } finally {
                    instream.close();
                }

            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (minx < maxx) {


        }

    }


}
