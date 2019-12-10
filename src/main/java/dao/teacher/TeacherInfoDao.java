package dao.teacher;

import po.entity.teacher.TeacherloginEntity;
import java.util.List;

public interface TeacherInfoDao {
    //根据学号获取学生信息  查询
    public TeacherloginEntity findStuInfoByTchId(String teacherId);

    //根据用户名获取学生信息  查询
    public TeacherloginEntity findStuInfoByTchUsername(String tchUsername);

    //根据用户登录验证
    public TeacherloginEntity checkTch(String tchUsername, String tchPassword);

    //查询所有学生信息  查询
    public List findTchInfoAll();

    //返回查询行数 分页 查询
    public int getTotalRows();

    //更新学生信息
    public boolean updateTchInfo(TeacherloginEntity teacherloginEntity);

    //注册信息
    public TeacherloginEntity saveTchInfoTwo(TeacherloginEntity teacherloginEntity);

    //补充注册信息
    public TeacherloginEntity saveTchInfo(TeacherloginEntity teacherloginEntity);

    //删除用户
    public boolean deleteTch(String studentId);
}
