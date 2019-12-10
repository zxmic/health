package dao.teacher.Impl;

import dao.teacher.TeacherInfoDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import po.entity.teacher.TeacherloginEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//HibernateDaoSupport 为dao注入sessionFactory
public class TeacherInfoDaoImpl extends HibernateDaoSupport implements TeacherInfoDao {


    @Override
    public TeacherloginEntity findStuInfoByTchId(String teacherId) {
        return null;
    }

    @Override
    public TeacherloginEntity findStuInfoByTchUsername(String tchUsername) {
        return null;
    }

    @Override
    public TeacherloginEntity checkTch(String tchUsername, String tchPassword) {
        return null;
    }

    @Override
    public List findTchInfoAll() {
        return null;
    }

    @Override
    public int getTotalRows() {
        return 0;
    }

    @Override
    public boolean updateTchInfo(TeacherloginEntity teacherloginEntity) {
        return false;
    }

    @Override
    public TeacherloginEntity saveTchInfoTwo(TeacherloginEntity teacherloginEntity) {
        return null;
    }

    @Override
    public TeacherloginEntity saveTchInfo(TeacherloginEntity teacherloginEntity) {
        return null;
    }

    @Override
    public boolean deleteTch(String studentId) {
        return false;
    }
}
