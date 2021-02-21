package com.learn.beans.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author: luzhiqing
 * @date: 2021-02-06
 **/
@RestController
public class Test {
    @Autowired
    private AsyncTest asyncTest;
    @RequestMapping(value = "/learn/async/trigger",method = RequestMethod.GET)
    public void triggerAsync(){
        asyncTest.trigger();
        System.out.println("hello async");
    }

    @RequestMapping(value = "/learn/async/trigger1",method = RequestMethod.GET)
    public void trigger1Async(){
        asyncTest.trigger1();
        saveClassFile(AsyncTestImpl.class,"sldfklsdlkf");
        System.out.println("hello async 1");
    }

    public void saveClassFile(Class clazz,String proxyName) {
        //生成class的字节数组，此处生成的class与proxy.newProxyInstance中生成的class除了代理类的名字不同，其它内容完全一致
        byte[] classFile = ProxyGenerator.generateProxyClass(proxyName, clazz.getInterfaces());
        String path = clazz.getResource(".").getPath();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path + proxyName + ".class");
            fos.write(classFile);//保存到磁盘
            fos.flush();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
