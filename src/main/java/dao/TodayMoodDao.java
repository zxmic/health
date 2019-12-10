package dao;


import po.entity.student.MypointEntity;

import java.util.List;

public interface TodayMoodDao {
    //根据学号查询心情
    public List<MypointEntity> findMoodByStuid(String studentid);

    //根据学号和日期查询心情
    public MypointEntity findMoodByStuidAndData(String studentid,String data);

    //保存心情
    public MypointEntity saveTodayMood(MypointEntity mypointEntity);

    //更新心情
    public MypointEntity updateTodayMood(MypointEntity mypointEntity);
}
