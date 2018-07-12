package com.proxy.daili;

import com.proxy.interfaces.HelloWorld;
import com.proxy.interfaces.impl.HelloWorldImpl;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyExample implements InvocationHandler {

    //真实对象
    private Object target = null;

    /**
     * 建立代理对象和真实对象的代理关系，并返回代理对象
     * @param target 真实对象
     * @return 代理对象
     */
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    /**
     * 代理方法逻辑
     * @param proxy 代理对象
     * @param method 当前调度方法
     * @param args 当前方法参数
     * @return 代理结果返回
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑方法");
        System.out.println("在调度真实对象之前的服务");
        Object obj = method.invoke(target,args);//相当于调用sayHelloWorld方法
        System.out.println("在调度方法之后");

        return obj;
    }

    @Test
    public void testJdkProxy(){
        JdkProxyExample jdkProxyExample = new JdkProxyExample();
        //绑定关系,因为挂在接口HelloWorld下，所以声明代理对象HelloWorld proxy
        HelloWorld proxy = (HelloWorld)jdkProxyExample.bind(new HelloWorldImpl());
        //此时HelloWorld对象已经是一个代理对象，它会进入代理的逻辑方法
        proxy.sayHelloWorld();
    }
}
