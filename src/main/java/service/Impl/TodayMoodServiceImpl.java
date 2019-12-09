package service.Impl;

import dao.TodayMoodDao;
import po.entity.MypointEntity;
import service.TodayMoodService;

public class TodayMoodServiceImpl implements TodayMoodService {
    private TodayMoodDao todayMoodDao;

    public void setTodayMoodDao(TodayMoodDao todayMoodDao) {
        this.todayMoodDao = todayMoodDao;
    }

    @Override
    public MypointEntity findMoodByStuid(String studentid) {
        //1、根据用户名查询登录用户
        MypointEntity mypointEntity = todayMoodDao.findMoodByStuid(studentid);
        return mypointEntity;
    }

    //保存心情
    @Override
    public MypointEntity saveTodayMood(MypointEntity mypointEntity) {
        //1、先查询今天是否有记录
        MypointEntity mypoint=todayMoodDao.findMoodByStuidAndData(mypointEntity.getStudentid(),mypointEntity.getWhichday().toString());
        //2、今天有记录===》更新
        if(mypoint!=null){
            System.out.println("找到记录");
            mypoint.setMoodpoint(mypointEntity.getMoodpoint());
            todayMoodDao.updateTodayMood(mypoint);
        }
        //3、没有记录==》保存
        if (mypoint==null){
            System.out.println("保存成功");
            todayMoodDao.saveTodayMood(mypointEntity);
        }

        return mypointEntity;
    }

    @Override
    public MypointEntity updateTodayMood(MypointEntity mypointEntity) {
        return null;
    }
}
