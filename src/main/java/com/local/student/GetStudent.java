package com.local.student;

import com.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import po.entity.StudentloginEntity;

import java.util.List;

public class GetStudent {
    Configuration cfg;
    SessionFactory sessionFactory;
    Session session;
    public GetStudent() {
        //1.加载HIbernate核心配置文件0
        cfg = new Configuration().configure();
        //cfg.configure();
        //2.使用sessionFactory
        sessionFactory = cfg.buildSessionFactory();
        //3使用sessionfactory 实例化session对象
        session = sessionFactory.openSession();            //声明Session对象
        //开始事物
        session.beginTransaction();
    }

    public static void main(String[] args) {

    }

    public List<StudentloginEntity> get(String username) {
        List<StudentloginEntity> results = null;


        try {

            String hql = "FROM StudentloginEntity  s where s.username="+username;//Employee 是实体类名，严格区分大小写
            Query query = session.createQuery(hql);
            results = query.list();
            System.out.println("查询成功");
            //Hibernate的持久化操作
            //StudentloginEntity studentloginEntity  = (StudentloginEntity) session.get(StudentloginEntity.class, new Integer("5"));//装载对象
//            System.out.println("学生ID："+studentloginEntity.getId());
//            System.out.println("学生真名："+studentloginEntity.getRealname());
//            System.out.println("学生宿舍："+studentloginEntity.getDorm());

        } catch (Exception e) {
            session.getTransaction().rollback();//事务回滚
            System.out.println("数据查询失败");
        } finally {
            session.close();
            sessionFactory.close();
            HibernateSessionFactory.closeSession();//关闭Session对象
        }
        System.out.println("get结束");
        System.out.println("results.isEmpty()="+results.isEmpty());
        return results;
    }

}
