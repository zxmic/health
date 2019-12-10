package com.student.local.student;

import com.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import po.entity.student.StudentloginEntity;

public class DeleteStudent {
    public static void main(String[] args) {
        //1.加载HIbernate核心配置文件0
        Configuration cfg= new Configuration().configure();
        cfg.configure();
        //2.使用sessionFactory
        SessionFactory sessionFactory=cfg.buildSessionFactory();
        //3使用sessionfactory 实例化session对象
        Session session = sessionFactory.openSession();			//声明Session对象
        //开始事物
        Transaction transaction=session.beginTransaction();

        try {
            //Hibernate的持久化操作
            StudentloginEntity studentloginEntity = (StudentloginEntity) session.get(StudentloginEntity.class, new Integer("6"));//装载对象
            System.out.println(studentloginEntity.getRealname());
            session.delete(studentloginEntity);//删除持久化信息
            session.flush();//强制刷新提交
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();//事务回滚
            System.out.println("数据删除失败");
            e.printStackTrace();
        } finally{
            session.close();
            sessionFactory.close();
            HibernateSessionFactory.closeSession();//关闭Session对象
        }
        System.out.println("delete结束");
    }

}
