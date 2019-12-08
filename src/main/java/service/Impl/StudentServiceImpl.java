package service.Impl;

import dao.Impl.StudentInfoDaoImpl;
import dao.StudentInfoDao;
import po.entity.StudentloginEntity;
import service.StudentService;

import java.util.List;

/**
 * @author zx
 */
//@Transactional(isolation)
public class StudentServiceImpl implements StudentService {

    private StudentInfoDao studentInfoDao;

    public void setStudentInfoDao(StudentInfoDaoImpl studentDao) {
        this.studentInfoDao=studentDao;
    }

    @Override
    public StudentloginEntity findStuInfoByStuId(String studentId) {
        return studentInfoDao.findStuInfoByStuId(studentId);
    }

    @Override
    public StudentloginEntity findStuInfoByStuUsername(String stuUsername) {
        return studentInfoDao.findStuInfoByStuUsername(stuUsername);
    }

    @Override
    public StudentloginEntity checkStu(String stuUsername, String stuPassword) {
        //1、根据用户名查询登录用户
        StudentloginEntity studentloginEntity = studentInfoDao.findStuInfoByStuUsername(stuUsername);
        //2、判断用户是否存在，不存在---》抛出异常，提示用户名不存在
        if(studentloginEntity==null){
            throw new RuntimeException("用户名不存在");
        }
        //3、判断密码是否正确，不正确---》抛出异常，提示密码错误
        //4、返回查询到的用户对象

        return studentInfoDao.checkStu(stuUsername,stuPassword);
    }

    @Override
    public List findStuInfoAll() {
        return studentInfoDao.findStuInfoAll();
    }

    @Override
    public int getTotalRows() {
        return studentInfoDao.getTotalRows();
    }

    @Override
    public boolean updateStuInfo(StudentloginEntity studentloginEntity) {
        return studentInfoDao.updateStuInfo(studentloginEntity);
    }

    @Override
    public StudentloginEntity saveStuInfo(StudentloginEntity studentloginEntity) {
        return studentInfoDao.saveStuInfo(studentloginEntity);
    }

    @Override
    public boolean deleteStu(String studentId) {
        return studentInfoDao.deleteStu(studentId);
    }
}
