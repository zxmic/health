package com;

import dao.StudentInfoDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
import po.entity.StudentloginEntity;

import javax.annotation.Resource;
public class demoTest {
//    @Test
//    public void fun1(){
//        //1.创建容器对象
//        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
//        StudentloginEntity studentloginEntity= (StudentloginEntity) ac.getBean("student1");
//        System.out.println(studentloginEntity);
//    }

    @Resource(name = "sessionFactory")
    private SessionFactory sf;
    @Test
    public void fun1(){
        Session session=sf.openSession();
        Transaction tx= session.beginTransaction();
        //================================================
        StudentloginEntity s=new StudentloginEntity();
        s.setUsername("jieke");
        s.setPassword("123");
        s.setMajor("xxx");
        s.setDorm("111");
        s.setCollege("sss");
        s.setMastertel("45644");
        s.setClassmaster("ppp");
        s.setTel("456");
        s.setStudentid("444");
        s.setClazz("444555");
        s.setRealname("xxx");
        session.save(s);

        System.out.println(s);

        //================================================
        tx.commit();
        session.close();
    }

    @Resource
    private StudentInfoDao sd;
    //测试dao hibernate模板
    public void fun3(){
        StudentloginEntity studentloginEntity=sd.findStuInfoByStuId("2240170201");
    }

    //测试aop事务
    public void fun2(){

    }


}
