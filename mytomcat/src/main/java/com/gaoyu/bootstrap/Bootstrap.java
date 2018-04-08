package com.gaoyu.bootstrap;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.gaoyu.core.MyRequest;
import com.gaoyu.core.MyResponse;
import com.gaoyu.core.MyServlet;
import com.gaoyu.core.ServletMapping;
import com.gaoyu.core.ServletMappingConfig;

public class Bootstrap
{
    private int port = 8080;
    
    private Map<String, String> urlServletMap = new HashMap<String, String>();
    
    public Bootstrap(int port)
    {
        this.port = port;
    }
    
    public void start()
    {
        initServletMapping();
        ServerSocket servletSocket = null;
        try
        {
            servletSocket = new ServerSocket(port);
            System.out.println("MyTomcat is start ...");
            while(true)
            {
                Socket socket = servletSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                MyRequest myRequest = new MyRequest(inputStream);
                MyResponse myResponse = new MyResponse(outputStream);
                
                dispatch(myRequest,myResponse);
                socket.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (servletSocket != null)
            {
                try
                {
                    servletSocket.close();
                }
                catch (Exception e2)
                {
                    e2.printStackTrace();
                }
            }
        }
    }
    
    private void dispatch(MyRequest myRequest, MyResponse myResponse)
    {
        String clazz = urlServletMap.get(myRequest.getUrl());
        try
        {
            @SuppressWarnings("unchecked")
            Class<MyServlet> myservletClass = (Class<MyServlet>)Class.forName(clazz);
            MyServlet myServlet = myservletClass.newInstance();
            myServlet.service(myRequest, myResponse);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void initServletMapping()
    {
        for(ServletMapping servletMapping : ServletMappingConfig.servletMappingList)
        {
            urlServletMap.put(servletMapping.getUrl(), servletMapping.getClazz());
        }
    }

    public static void main(String[] args)
    {
        new Bootstrap(8080).start();
    }
}
