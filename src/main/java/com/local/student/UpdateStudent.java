package com.local.student;


import com.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import po.entity.StudentloginEntity;

public class UpdateStudent {
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

            StudentloginEntity studentloginEntity = (StudentloginEntity) session.load(StudentloginEntity.class, new Integer("2"));//装载对象
            System.out.println("学生ID："+studentloginEntity.getId());
            System.out.println("学生真名："+studentloginEntity.getRealname());
            System.out.println("学生宿舍："+studentloginEntity.getDorm());
            studentloginEntity.setRealname("郑云龙");//修改商品名称
            studentloginEntity.setMajor("软件工程");//修改备注信息
            session.update(studentloginEntity);
            System.out.println("--------------------");
            System.out.println("学生真名："+studentloginEntity.getRealname());
            System.out.println("专业"+studentloginEntity.getMajor());
//            session.flush();
//            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();//事务回滚
            System.out.println("数据更新失败");
            e.printStackTrace();
        } finally{
            session.close();
            sessionFactory.close();
            HibernateSessionFactory.closeSession();//关闭Session对象
        }
        System.out.println("update结束");
    }
}
