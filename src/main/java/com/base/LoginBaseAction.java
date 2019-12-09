package com.base;

import com.opensymphony.xwork2.ActionSupport;
import service.StudentService;
import service.TodayMoodService;

public class LoginBaseAction extends ActionSupport {
    //BaseAction定义service接口，所有Action继承父类，不用每个action都引入
    protected StudentService studentService;
    protected TodayMoodService todayMoodService;

    public TodayMoodService getTodayMoodService() {
        return todayMoodService;
    }

    public void setTodayMoodService(TodayMoodService todayMoodService) {
        this.todayMoodService = todayMoodService;
    }


    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
