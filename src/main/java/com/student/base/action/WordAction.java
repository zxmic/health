package com.student.base.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import po.entity.student.MywordEntity;
import po.entity.student.StudentloginEntity;
import service.TodayFeelingService;

public class WordAction extends ActionSupport implements ModelDriven<MywordEntity> {
    private TodayFeelingService todayFeelingService;

    public TodayFeelingService getTodayFeelingService() {
        return todayFeelingService;
    }

    public void setTodayFeelingService(TodayFeelingService todayFeelingService) {
        this.todayFeelingService = todayFeelingService;
    }


    private MywordEntity mywordE=new MywordEntity();

    public String saveTodayWord(){
        //获得当前登录学生信息
        StudentloginEntity sE = (StudentloginEntity) ActionContext.getContext().getSession().get("studentloginEntity");
        System.out.println(sE);
        //1、获得学生id
        mywordE.setStudentid(sE.getStudentid());
        System.out.println("真实保存的"+mywordE);
        //把mypointE保存到数据库中
        MywordEntity wd=todayFeelingService.saveFeeling(mywordE);
        //把心情保存到session中
        ActionContext.getContext().getSession().put("mywordEntity",wd);
        return "success";


    }
    @Override
    public MywordEntity getModel() {
        return mywordE;
    }
}
