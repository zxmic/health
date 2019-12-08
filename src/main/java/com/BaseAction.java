package com;

import com.opensymphony.xwork2.ActionSupport;
import service.StudentService;

public class BaseAction extends ActionSupport {
    //BaseAction定义service接口，所有Action继承父类，不用每个action都引入
    protected StudentService studentService;

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
