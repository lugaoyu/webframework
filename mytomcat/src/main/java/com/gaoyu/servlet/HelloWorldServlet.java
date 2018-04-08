package com.gaoyu.servlet;

import java.io.IOException;

import com.gaoyu.core.MyRequest;
import com.gaoyu.core.MyResponse;
import com.gaoyu.core.MyServlet;

public class HelloWorldServlet extends MyServlet
{
    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse)
    {
        try
        {
            myResponse.write("get world...");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse)
    {
        try
        {
            myResponse.write("post world...");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
}
