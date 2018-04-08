package com.gaoyu.core;

import java.io.IOException;
import java.io.InputStream;

public class MyRequest
{
    private String url;
    private String method;
    
    public MyRequest(InputStream inputStream) throws IOException
    {
        String httpRequest = "";
        byte[] httpRequestBytes = new byte[1024];
        int length = 0;
        if((length = inputStream.read(httpRequestBytes))>0)
        {
            httpRequest = new String(httpRequestBytes,0,length);
        }
        System.out.println("httpRequest: "+ httpRequest);
        String httpHead = httpRequest.split("\n")[0];
        System.out.println("httpHead: "+ httpHead);
        String[] main = httpHead.split("\\s");
        for (int i = 0; i < main.length; i++)
        {
            System.err.println("main:"+"i "+main[i]);
        }
        url = httpHead.split("\\s")[1];
        method = httpHead.split("\\s")[0];
        System.out.println(this.getUrl()+this.getMethod());
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getMethod()
    {
        return method;
    }

    public void setMethod(String method)
    {
        this.method = method;
    }
}
