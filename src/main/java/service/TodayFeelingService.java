package service;

import po.entity.student.MywordEntity;

public interface TodayFeelingService {
    //根据id查询
    public MywordEntity fingFeelingByStudentid(String studentid);
    //保存feeling
    public MywordEntity saveFeeling(MywordEntity mywordE);
    //更新feeling
    public MywordEntity updateFeeling(MywordEntity mywordE);
}
