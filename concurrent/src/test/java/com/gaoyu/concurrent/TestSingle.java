package com.gaoyu.concurrent;

public class TestSingle
{
        private TestSingle()
        {
                
        }
        
        private static TestSingle  instance= new TestSingle();
        
        public static Student a = new Student();
        
        public  Student st = new Student();
        
        public void SayHello()
        {
                System.err.println("st:   "+st);
                System.err.println("static:   "+a);
        }
        
        public static TestSingle getInstance()
        {
                return instance;
        }
}
