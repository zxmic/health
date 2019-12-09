package com.base.action;

import com.base.todayMoodBaseAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import po.entity.MypointEntity;
import po.entity.StudentloginEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TodayMoodAction extends todayMoodBaseAction implements ModelDriven<MypointEntity> {
    private MypointEntity mypointE=new MypointEntity();

    @Override
    public MypointEntity getModel() {
        return mypointE;
    }

    public String savetodayMood(){
        //获得当前登录学生信息
        StudentloginEntity sE = (StudentloginEntity)ActionContext.getContext().getSession().get("studentloginEntity");
        System.out.println(sE);
        //1、获得保存心情指数 当前日期 学生id
        //获得当前年月日
        LocalDate date = LocalDate.now();
        //格式化时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String sdate=date.format(formatter);
        mypointE.setWhichday(sdate);
        mypointE.setStudentid(sE.getStudentid());
        System.out.println("真实保存的"+mypointE);
        //把mypointE保存到数据库中
        todayMoodService.saveTodayMood(mypointE);
        //把心情保存到session中
        ActionContext.getContext().getSession().put("mypointEntity",mypointE);




        return "success";
    }


}
