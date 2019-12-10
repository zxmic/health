package service.Impl;

import dao.TodayMoodDao;
import po.entity.student.MypointEntity;
import service.TodayMoodService;

import java.util.List;

public class TodayMoodServiceImpl implements TodayMoodService {
    private TodayMoodDao todayMoodDao;

    public void setTodayMoodDao(TodayMoodDao todayMoodDao) {
        this.todayMoodDao = todayMoodDao;
    }

    @Override
    public List<MypointEntity> findMoodByStuid(String studentid) {
        //1、根据用户名查询登录用户 所有心情指数
        List<MypointEntity> mypointEntities = todayMoodDao.findMoodByStuid(studentid);
        return mypointEntities;
    }

    //保存心情
    @Override
    public MypointEntity saveTodayMood(MypointEntity mypointEntity) {
        //1、先查询是否有记录
        MypointEntity mypoint=todayMoodDao.findMoodByStuidAndData(mypointEntity.getStudentid(),mypointEntity.getWhichday());
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

    @Override
    public MypointEntity findMoodByStuidAndData(String studentid, String data) {
        //1、根据用户名和日期查询登录用户
        MypointEntity mypointEntity = todayMoodDao.findMoodByStuidAndData(studentid,data);
        return mypointEntity;
    }
}
