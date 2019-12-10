package service.Impl;

import dao.StudentInfoDao;
import po.entity.student.StudentloginEntity;
import service.StudentService;

import java.util.List;

/**
 * @author zx
 */
//@Transactional(isolation)
public class StudentServiceImpl implements StudentService {

    private StudentInfoDao studentInfoDao;

    public void setStudentInfoDao(StudentInfoDao studentInfoDao) {
        this.studentInfoDao = studentInfoDao;
    }

//    public void setStudentInfoDao(StudentInfoDaoImpl studentDao) {
//        this.studentInfoDao=studentDao;
//    }


    /**
     * 逻辑需要重写
     * @param studentId
     * @return
     */
    @Override
    public StudentloginEntity findStuInfoByStuId(String studentId) {


        //根据登录名查询用户
        StudentloginEntity stu=studentInfoDao.findStuInfoByStuId(studentId);
        //如果用户不存在，抛出异常,提示用户名不存在
        if(stu==null){
            throw new RuntimeException("用户名不存在");
        }
        //判断密码是否正确==》不正确=》抛出异常，提示密码错误

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
        if(!studentloginEntity.getPassword().equals(stuPassword)){
            throw new RuntimeException("密码错误");
        }
        //4、返回查询到的用户对象

        return studentloginEntity;
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
    public StudentloginEntity saveStuInfoTwo(StudentloginEntity studentloginEntity) {
        StudentloginEntity stu = studentloginEntity;
        StudentloginEntity stuEntity = studentInfoDao.findStuInfoByStuUsername(studentloginEntity.getUsername());
        //1、判断用户是否存在，存在---》抛出异常，提示用户名不存在
        if(stuEntity!=null){
            System.out.println("用户名已存在，请更换用户名");
            throw new RuntimeException("用户名已存在，请更换用户名");
        }
        if(stuEntity==null){
            //2、不存在---》保存用户
            stu = studentInfoDao.saveStuInfoTwo(studentloginEntity);
            System.out.println("您已注册成功，请返回登录");
        }

        return stu;
    }

    @Override
    public StudentloginEntity saveStuInfo(StudentloginEntity studentloginEntity) {
        return null;
    }

    @Override
    public boolean deleteStu(String studentId) {
        return studentInfoDao.deleteStu(studentId);
    }
}
