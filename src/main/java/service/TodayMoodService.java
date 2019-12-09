package service;

import po.entity.MypointEntity;

public interface TodayMoodService {
    //根据学号查询心情
    public MypointEntity findMoodByStuid(String studentid);

    //保存心情
    public MypointEntity saveTodayMood(MypointEntity mypointEntity);

    //更新心情
    public MypointEntity updateTodayMood(MypointEntity mypointEntity);

}
