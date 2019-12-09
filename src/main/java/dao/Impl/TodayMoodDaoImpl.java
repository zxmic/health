package dao.Impl;

import dao.TodayMoodDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import po.entity.MypointEntity;

public class TodayMoodDaoImpl extends HibernateDaoSupport implements TodayMoodDao {
    @Override
    public MypointEntity findMoodByStuid(final String studentid) {
        return getHibernateTemplate().execute(new HibernateCallback<MypointEntity>() {
            @Override
            public MypointEntity doInHibernate(Session session) throws HibernateException {
                String hql = "from MypointEntity c where c.studentid=?";
                Query query=session.createQuery(hql);
                query.setParameter(0,studentid);
                MypointEntity mpointEntity=(MypointEntity)query.uniqueResult();
                return mpointEntity;
            }
        });
    }

    //根据学号和日期查询心情
    @Override
    public MypointEntity findMoodByStuidAndData(final String studentid, final String data) {
        return getHibernateTemplate().execute(new HibernateCallback<MypointEntity>() {
            @Override
            public MypointEntity doInHibernate(Session session) throws HibernateException {
                String hql = "from MypointEntity c where c.studentid=?and c.whichday=?";
                Query query=session.createQuery(hql);
                query.setParameter(0,studentid);
                query.setParameter(1,data);
                MypointEntity mpointEntity=(MypointEntity)query.uniqueResult();
                return mpointEntity;
            }
        });
    }

    @Override
    public MypointEntity saveTodayMood(MypointEntity mypointEntity) {
        try {
            this.getHibernateTemplate().save(mypointEntity);
            System.out.println("保存心情数据到数据库成功");
            System.out.println(mypointEntity);
            return mypointEntity;
        }catch (Exception e){
            System.out.println("保存心情数据到数据库失败");
            e.printStackTrace();
        }
        return mypointEntity;
    }

    @Override
    public MypointEntity updateTodayMood(MypointEntity mypointEntity) {
//        this.getHibernateTemplate().update(new HibernateCallback<MypointEntity>() {
//            @Override
//            public MypointEntity doInHibernate(Session session) throws HibernateException {
//
//                String hql = "update MypointEntity set moodpoint=? where studentid=? and m.";
//                Query query = session.createSQLQuery(hql);
//                query.setParameter(0, "王五");
//                query.setParameter(1, "2222");
//                query.executeUpdate();
//
//                return null;
//            }
//        });
        this.getHibernateTemplate().saveOrUpdate(mypointEntity);
        System.out.println("修改心情成功");
        return mypointEntity;
    }
}
