package com.zhixing101.wechat.api.provide;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * dubbo
 * Created by adam on 5/9/16.
 */
public class Provider {

    private static volatile boolean running = true;

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {

        ClassPathXmlApplicationContext context = null;
        // 打成jar包，所有的spring配置文件要一一标明
        if (Thread.currentThread().getContextClassLoader().getResource("") == null) {
            context =
                    new ClassPathXmlApplicationContext("classpath*:/applicationContext.xml");
        } else {
            context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
        }
        context.start();
        synchronized (Provider.class) {
            while (running) {
                try {
                    Provider.class.wait();
                } catch (Throwable e) {
                }
            }
        }
    }
}
