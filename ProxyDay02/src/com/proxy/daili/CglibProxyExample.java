package com.proxy.daili;
import com.proxy.interfaces.impl.HelloWorldImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;
import java.lang.reflect.Method;

public class CglibProxyExample implements MethodInterceptor {

    /**
     * 生成CGLIB代理对象
     * @param cl -- class 类
     * @return Class类的CGLIB代理对象
     */
    public Object getProxy(Class cl){
        //CGLIB enhancer 增强类对象
        Enhancer enhancer = new Enhancer();
        //设置增强类型
        enhancer.setSuperclass(cl);
        //定义代理逻辑对象为当前对象，要求当前对象实现MethodInterceptor方法
        enhancer.setCallback(this);
        //生成并返回代理对象
        return enhancer.create();
    }

    /**
     * 代理逻辑方法
     * @param o 代理对象
     * @param method 方法
     * @param objects 方法参数
     * @param methodProxy 方法代理
     * @return 代理逻辑返回
     * @throws Throwable 异常
     */

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用真实对象之前");
        //CGLIB 反射调用真实对象方法
        Object result = methodProxy.invoke(o,objects);
        System.out.println("调用真实对象之后");
        return result;
    }

    @Test
    public void testCGLIBProxy(){
        CglibProxyExample cpe = new CglibProxyExample();
        HelloWorldImpl helloWorld = (HelloWorldImpl)cpe.getProxy(HelloWorldImpl.class);
        helloWorld.sayHelloWorld();
    }
}
