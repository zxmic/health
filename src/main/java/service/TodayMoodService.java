package service;

import po.entity.student.MypointEntity;

import java.util.List;

public interface TodayMoodService {
    //根据学号查询心情
    public List<MypointEntity> findMoodByStuid(String studentid);

    //保存心情
    public MypointEntity saveTodayMood(MypointEntity mypointEntity);

    //更新心情
    public MypointEntity updateTodayMood(MypointEntity mypointEntity);

    //根据学号和日期查询心情
    public MypointEntity findMoodByStuidAndData(String studentid,String data);

}
