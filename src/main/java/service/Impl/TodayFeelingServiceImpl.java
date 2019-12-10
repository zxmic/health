package service.Impl;

import dao.TodayFeelingDao;
import po.entity.student.MywordEntity;
import service.TodayFeelingService;

public class TodayFeelingServiceImpl implements TodayFeelingService {
    private TodayFeelingDao todayFeelingDao;

    public void setTodayFeelingDao(TodayFeelingDao todayFeelingDao) {
        this.todayFeelingDao = todayFeelingDao;
    }

    @Override
    public MywordEntity fingFeelingByStudentid(String studentid) {
        //1、根据用户名查询登录用户
        MywordEntity mywordEntity = todayFeelingDao.fingFeelingByStudentid(studentid);
        return mywordEntity;
    }

    @Override
    public MywordEntity saveFeeling(MywordEntity mywordE) {
        //1、先查询是否有记录
        MywordEntity myworld=todayFeelingDao.fingFeelingByStudentid(mywordE.getStudentid());
        //2、今天有记录===》更新
        if(myworld!=null){
            System.out.println("找到记录");
            myworld.setTodaymyword(mywordE.getTodaymyword());
            todayFeelingDao.updateFeeling(myworld);
        }
        //3、没有记录==》保存
        if (myworld==null){
            System.out.println("保存成功");
            todayFeelingDao.saveFeeling(mywordE);
        }

        return mywordE;
    }

    @Override
    public MywordEntity updateFeeling(MywordEntity mywordE) {
        return null;
    }
}
