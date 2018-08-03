package com.proxy.interceptor.test;

import com.proxy.interceptor.impl.InterceptorJdkProxy;
import com.proxy.interfaces.HelloWorld;
import com.proxy.interfaces.impl.HelloWorldImpl;
import org.junit.Test;

public class MyInterceptorTest {
    @Test
    public void test1(){
        HelloWorld proxy = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(),"com.proxy.interceptor.MyInterceptor");
        proxy.sayHelloWorld("张三");
    }
}
