package com.student.local.student;


import com.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import po.entity.student.StudentloginEntity;


public class AddStudent {
    public static void main(String[] args) {
        add();
    }
    public static void  add(){
        //1.加载HIbernate核心配置文件0
        Configuration cfg= new Configuration().configure();
        cfg.configure();
        //2.使用sessionFactory
        SessionFactory sessionFactory=cfg.buildSessionFactory();
        //3使用sessionfactory 实例化session对象
        Session session = sessionFactory.openSession();			//声明Session对象
        //开始事物
        Transaction transaction=session.beginTransaction();

        StudentloginEntity studentloginEntity = new StudentloginEntity();//实例化持久化类
        //为持久化类属性赋值
        studentloginEntity.setUsername("02240170203");
        studentloginEntity.setPassword("02240170203");
        studentloginEntity.setRealname("大张伟");
        studentloginEntity.setClazz("网络1702");
        studentloginEntity.setStudentid("02240170203");
        studentloginEntity.setTel("16548254682");
        studentloginEntity.setClassmaster("李白");
        studentloginEntity.setMastertel("14257654825");
        studentloginEntity.setCollege("信息技术工程学院");
        studentloginEntity.setMajor("计算机科学与技术");
        studentloginEntity.setDorm("7C150");
        //Hibernate的持久化操作
        try {
//            System.out.println("还没获取session");
//            session = HibernateSessionFactory.getSession();//获取Session
//            System.out.println("no获取session");
//            tr=session.beginTransaction();//开启事务
//            System.out.println("不可添加数据");
            session.save(studentloginEntity);//执行数据库添加操作
            transaction.commit();
            //session.getTransaction().commit();//事务提交
            System.out.println("数据添加提交成功");
        } catch (Exception e) {
            session.getTransaction().rollback();//事务回滚
            System.out.println("数据添加失败");
            e.printStackTrace();
        }finally{
            session.close();
            sessionFactory.close();
            HibernateSessionFactory.closeSession();//关闭Session对象
        }
        System.out.println("结束");
    }
}
