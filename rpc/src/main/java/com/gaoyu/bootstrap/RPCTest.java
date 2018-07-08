package com.gaoyu.bootstrap;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.gaoyu.intf.HelloService;
import com.gaoyu.intf.Server;
import com.gaoyu.rpc.RPCClient;
import com.gaoyu.service.HelloServiceImpl;
import com.gaoyu.service.ServiceCenter;

/**
 * date: 2018年7月7日 下午2:00:36 <br/>
 * @author gaoyu
 */
public class RPCTest
{
        public static void main(String[] args) throws IOException
        {
                new Thread(new Runnable()
                {
                        public void run()
                        {
                                try
                                {
                                        Server serviceServer = new ServiceCenter(8088);
                                        serviceServer.register(HelloService.class, HelloServiceImpl.class);
                                        serviceServer.start();
                                }
                                catch (IOException e)
                                {
                                        e.printStackTrace();
                                }
                        }
                }).start();
                HelloService service = RPCClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 8088));
                System.out.println(service.sayHi("test"));
        }
}
