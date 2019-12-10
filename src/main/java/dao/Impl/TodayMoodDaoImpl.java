package dao.Impl;

import dao.TodayMoodDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import po.entity.student.MypointEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TodayMoodDaoImpl extends HibernateDaoSupport implements TodayMoodDao {
    @Override
    public List<MypointEntity> findMoodByStuid(final String studentid) {

        List<MypointEntity> list=new ArrayList();
        String hql="from MypointEntity s order by s.studentid";
        List l=this.getHibernateTemplate().find(hql);
        Iterator iterator =l.iterator();
        while (iterator.hasNext()){
            MypointEntity mypointEntities=(MypointEntity) iterator.next();
            list.add(mypointEntities);
        }
        return list;


//        return getHibernateTemplate().execute(new HibernateCallback<List<MypointEntity>>() {
//            @Override
//            public List<MypointEntity> doInHibernate(Session session) throws HibernateException {
//                List<MypointEntity> list=new ArrayList<MypointEntity>();
//                String hql = "from MypointEntity c where c.studentid=?";
//                List<MypointEntity> l=session.find(hql);//.createQuery(hql);
//                query.setParameter(0,studentid);
//                List<MypointEntity> mpointEntities=(List<MypointEntity>)query.uniqueResult();
//                return mpointEntities;
//            }
//        });
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
