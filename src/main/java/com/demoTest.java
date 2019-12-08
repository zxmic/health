package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
import po.entity.StudentloginEntity;

public class demoTest {
    @Test
    public void fun1(){
        //1.创建容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentloginEntity studentloginEntity= (StudentloginEntity) ac.getBean("student1");
        System.out.println(studentloginEntity);
    }
}
