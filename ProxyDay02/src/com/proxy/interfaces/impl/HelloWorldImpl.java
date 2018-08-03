package com.proxy.interfaces.impl;

import com.proxy.interfaces.HelloWorld;

public class HelloWorldImpl implements HelloWorld {

    @Override
    public void sayHelloWorld(String name) {
        System.out.println("Hello World !"+name);
    }
}
