package dao.Impl;

import dao.TodayFeelingDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import po.entity.student.MywordEntity;

public class TodayFeelingDaoImpl extends HibernateDaoSupport implements TodayFeelingDao {
    @Override
    public MywordEntity fingFeelingByStudentid(String studentid) {
        return getHibernateTemplate().execute(new HibernateCallback<MywordEntity>() {
            @Override
            public MywordEntity doInHibernate(Session session) throws HibernateException {
                String hql = "from MywordEntity c where c.studentid=?";
                Query query=session.createQuery(hql);
                query.setParameter(0,studentid);
                MywordEntity mword=(MywordEntity)query.uniqueResult();
                return mword;
            }
        });

    }

    @Override
    public MywordEntity saveFeeling(MywordEntity mywordE) {
        try {
            this.getHibernateTemplate().save(mywordE);
            System.out.println("保存我的话到数据库成功");
            System.out.println(mywordE);
            return mywordE;
        }catch (Exception e){
            System.out.println("保存我的话到数据库失败");
            e.printStackTrace();
        }
        return mywordE;
    }

    @Override
    public MywordEntity updateFeeling(MywordEntity mywordE) {
        this.getHibernateTemplate().saveOrUpdate(mywordE);
        System.out.println("修改我的话成功");
        return mywordE;
    }
}
