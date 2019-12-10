package dao;

import po.entity.student.StudentloginEntity;

import java.util.List;

public interface StudentInfoDao {
    //根据学号获取学生信息  查询
    public StudentloginEntity findStuInfoByStuId(String studentId);

    //根据用户名获取学生信息  查询
    public StudentloginEntity findStuInfoByStuUsername(String stuUsername);

    //根据用户登录验证
    public StudentloginEntity checkStu(String stuUsername,String stuPassword);

    //查询所有学生信息  查询
    public List findStuInfoAll();

    //返回查询行数 分页 查询
    public int getTotalRows();

    //更新学生信息
    public boolean updateStuInfo(StudentloginEntity studentloginEntity);

    //注册信息
    public StudentloginEntity saveStuInfoTwo(StudentloginEntity studentloginEntity);

    //补充注册信息
    public StudentloginEntity saveStuInfo(StudentloginEntity studentloginEntity);

    //删除用户
    public boolean deleteStu(String studentId);
}
