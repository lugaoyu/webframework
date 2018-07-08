package com.gaoyu.concurrent;

public class Test
{
        public static Student a = new Student();
        
        public  Student st = new Student();
        
        final Student sf = new Student();
        
        public void SayHello()
        {
                st = new Student();
                System.err.println(st);
                System.err.println(a);
                System.err.println("sf:  "+sf);
        }
}
