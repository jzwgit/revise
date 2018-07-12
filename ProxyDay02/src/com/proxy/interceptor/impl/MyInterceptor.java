package com.proxy.interceptor.impl;

import com.proxy.interceptor.Interceptor;

import java.lang.reflect.Method;

public class MyInterceptor implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object args) {
        System.out.println("反射方法前的逻辑");
        return false;//不反射被代理对象原有方法
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object args) {
        System.out.println("取消了被代理对象的方法");
    }

    @Override
    public void after(Object proxy, Object target, Method method, Object args) {
        System.out.println("反射方法后的逻辑");
    }
}
