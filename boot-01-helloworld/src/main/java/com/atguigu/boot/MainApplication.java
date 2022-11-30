package com.atguigu.boot;


import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import com.atguigu.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.cache.interceptor.CacheAspectSupport;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})

//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("com.atguigu")
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

//        Pet tom01 = run.getBean("tom", Pet.class);
//        Pet tom02 = run.getBean("tom", Pet.class);
//        System.out.println("组件："+(tom01 == tom02));
//
//        MyConfig bean = run.getBean(MyConfig.class);
//        System.out.println(bean);
//
//        User user = bean.user01();
//        User user01 = bean.user01();
//        User user02 = bean.user01();
//        System.out.println(user == user01);
//
//        User user1 = run.getBean("user01", User.class);
//        Pet tom = run.getBean("tom", Pet.class);
//        System.out.println("用户的宠物:" + (user1.getPet() == tom));
//
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        System.out.println("===================");
//        for(String s : beanNamesForType){
//            System.out.println(s);
//        }
        boolean tom = run.containsBean("user01");
        boolean tom1 = run.containsBean("tom22");
        boolean tom2 = run.containsBean("haha");
        boolean tom3 = run.containsBean("hehe");
        System.out.println(tom);
        System.out.println(tom1);
        System.out.println(tom2);
        System.out.println(tom3);

        int beanDefinitionCount = run.getBeanDefinitionCount();
        System.out.println(beanDefinitionCount);

        String[] beanNamesForType = run.getBeanNamesForType(CacheAspectSupport.class);
        System.out.println(beanNamesForType.length);

        String[] beanNamesForType1 = run.getBeanNamesForType(WebMvcProperties.class);
        System.out.println(beanNamesForType1.length);
    }
}
