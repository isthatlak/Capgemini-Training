package com.gal.algo.passwordhasher;

import com.gal.algo.MyCalc;
import com.gal.algo.PasswordHasher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class MainBeans {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.gal");
        context.refresh();
        PasswordHasher bean = context.getBean(PasswordHasher.class);
        PasswordHasher bean2 = context.getBean(PasswordHasher.class);
        System.out.println(bean);
        System.out.println(bean2);
        System.out.println( bean.hash("hello"));
        StringBuilder bean3 = context.getBean(StringBuilder.class);
        System.out.println(bean3);
        //context.close();
        String[] beans = context.getBeanDefinitionNames();
        for(String beanname : beans){
            System.out.println(beanname);
        }
        MyCalc bean5 = context.getBean(MyCalc.class);
        Object bean6 = context.getBean("getCalcNamedBean");
        System.out.println(bean5);

        //create an object of DateSource and inject
        DataSource dsObj = context.getBean(DataSource.class);
        System.out.println(dsObj);

        System.out.println("hello");

//        PasswordHasher hasher;

    }
}
