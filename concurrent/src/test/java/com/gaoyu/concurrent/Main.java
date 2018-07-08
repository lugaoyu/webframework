package com.gaoyu.concurrent;

public class Main
{
        public static void main(String[] args)
        {
                Test t1 = new Test();
                t1.SayHello();
                Test t2 = new Test();
                t2.SayHello();
                //System.out.println("TestSingle");
                /*TestSingle ts1 = TestSingle.getInstance();
                ts1.SayHello();
                TestSingle ts2 = TestSingle.getInstance();
                ts2.SayHello();*/
        }
}
