package dao.Impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import dao.StudentInfoDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import po.entity.StudentloginEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//HibernateDaoSupport 为dao注入sessionFactory
public class StudentInfoDaoImpl extends HibernateDaoSupport implements StudentInfoDao {

    @Override
    public StudentloginEntity findStuInfoByStuId(final String studentId) {
        return getHibernateTemplate().execute(new HibernateCallback<StudentloginEntity>() {
            @Override
            public StudentloginEntity doInHibernate(Session session) throws HibernateException {
                String hql = "from StudentloginEntity s where s.studentid=?";
                Query query=session.createQuery(hql);
                query.setParameter(0,studentId);
                StudentloginEntity stuEntity=(StudentloginEntity)query.uniqueResult();
                return stuEntity;
            }
        });


//        String hql;
//        hql = "from StudentloginEntity s where s.studentid=?";
//        List list=this.getHibernateTemplate().find(hql,studentId);
//        if(list.size()>0){
//            System.out.println("根据用户名查询到用户");
//            return (StudentloginEntity)list.get(0);
//        }
//        System.out.println("根据用户名没有查询到用户");
//        return null;
    }

    //通过用户名查找学生
    @Override
    public StudentloginEntity findStuInfoByStuUsername(final String stuUsername) {

        return getHibernateTemplate().execute(new HibernateCallback<StudentloginEntity>() {
            @Override
            public StudentloginEntity doInHibernate(Session session) throws HibernateException {
                String hql="from StudentloginEntity s where s.username=?";
                Query query=session.createQuery(hql);
                query.setParameter(0,stuUsername);
                StudentloginEntity studentloginEntity=(StudentloginEntity)query.uniqueResult();
                return studentloginEntity;
            }
        });
        /**
         *         // Criteria
         *         DetachedCriteria detachedCriteria=DetachedCriteria.forClass(StudentloginEntity.class);
         *         detachedCriteria.add(Restrictions.eq("Username",stuUsername));
         *         List<StudentloginEntity> list=(List<StudentloginEntity>)getHibernateTemplate().findByCriteria();
         *         if(list!=null&&list.size()>0){
         *             return list.get(0);
         *         }else {
         *             return null;
         *         }
         */



//        List list=this.getHibernateTemplate().find(hql,stuUsername);
//        if(list.size()>0){
//            System.out.println("根据用户id查询到用户");
//            return (StudentloginEntity)list.get(0);
//        }
//        System.out.println("根据用户id没有查询到用户");
//        return null;
    }

    @Override
    public StudentloginEntity checkStu(String stuUsername, String stuPassword) {

        String hql="from StudentloginEntity s where s.studentid=? and s.password=?";
        // 返回用户名为stuUsername并且密码为stuPassword的所有User对象
        List list=this.getHibernateTemplate().find(hql, (Object) new String[]{"2240170201","2240170201"});
        if(list.size()>0){
            System.out.println("用户登录信息正确");
            return (StudentloginEntity)list.get(0);
        }
        System.out.println("用户登录信息错误，没有该用户或者密码不正确");
        return null;
    }

    @Override
    public List findStuInfoAll() {
        List list=new ArrayList();
        String hql="from StudentloginEntity s order by s.id";
        List l=this.getHibernateTemplate().find(hql);
        Iterator iterator =l.iterator();
        while (iterator.hasNext()){
            StudentloginEntity studentloginEntity=(StudentloginEntity) iterator.next();
            list.add(studentloginEntity);
        }
        return list;
    }

    @Override
    public int getTotalRows() {
        String hql ="from StudentloginEntity s order by s.id";
        int totalRows=this.getHibernateTemplate().find(hql).size();
        System.out.println("返回所有学生总数");
        return totalRows;
    }

    @Override
    public boolean updateStuInfo(StudentloginEntity studentloginEntity) {
        this.getHibernateTemplate().saveOrUpdate(studentloginEntity);
        System.out.println("修改用户信息成功");
        return true;
    }

    @Override
    public StudentloginEntity saveStuInfoTwo(StudentloginEntity studentloginEntity) {
        try {
            studentloginEntity.setRealname("0");
            studentloginEntity.setClazz("0");
            studentloginEntity.setStudentid("0");
            studentloginEntity.setTel("0");
            studentloginEntity.setClassmaster("0");
            studentloginEntity.setMastertel("0");
            studentloginEntity.setCollege("0");
            studentloginEntity.setMajor("0");
            studentloginEntity.setDorm("0");
            this.getHibernateTemplate().save(studentloginEntity);
            System.out.println("保存用户数据到数据库成功");
            return studentloginEntity;
        }catch (Exception e){
            System.out.println("保存用户数据到数据库失败");
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public StudentloginEntity saveStuInfo(StudentloginEntity studentloginEntity) {

        return null;
    }

    @Override
    public boolean deleteStu(String studentId) {
        StudentloginEntity studentloginEntity=(StudentloginEntity)this.getHibernateTemplate().load(StudentloginEntity.class,new Integer(studentId));
        this.getHibernateTemplate().delete(studentloginEntity);
        return true;
    }

}
