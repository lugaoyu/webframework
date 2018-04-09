package com.gaoyu.bootstrap;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

@SuppressWarnings("restriction")
public class ProxyUtils
{
    @SuppressWarnings("rawtypes")
    public static boolean saveProxyClass(String path,String proxyClassName,Class[] interfaces){
        if(proxyClassName == null || path == null){
            return false;
        }
        
        byte[] classFile = ProxyGenerator.generateProxyClass(proxyClassName,interfaces);
        FileOutputStream out = null;
        try{
            out = new FileOutputStream(path);
            out.write(classFile);
            out.flush();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(out != null){
                try{
                    out.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
