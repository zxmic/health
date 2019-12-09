package com.base.action;

import com.base.LoginBaseAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import po.entity.MypointEntity;
import po.entity.StudentloginEntity;

public class LoginAction extends LoginBaseAction implements ModelDriven<StudentloginEntity> {

    private StudentloginEntity stuE=new StudentloginEntity();


    public String studentLogin() throws Exception{
        //1、调用Service执行登录逻辑
        StudentloginEntity studentloginEntity=studentService.checkStu(stuE.getUsername(),stuE.getPassword());
        //2、将返回的StudentloginEntity对象放入session域
        ActionContext.getContext().getSession().put("studentloginEntity",studentloginEntity);

        //3、重定向到项目首页  表明在数据库中查询到学生信息
        if(studentloginEntity!=null){
            System.out.println("登录正确");
            //获得一系列的session
            MypointEntity mypointEntity= todayMoodService.findMoodByStuid(studentloginEntity.getStudentid());
            ActionContext.getContext().getSession().put("mypointEntity",mypointEntity);

            return "success";


        }else {
            System.out.println("登录错误");
            //数据库查询为空的结果
            return "error";
        }


    }
    public String teacherLogin() throws Exception{
//        if("xxx".equals(username)&&"xxx".equals(password)){
//            System.out.println("xxxok");
//            return "tok";
//        }
        System.out.println("xxxno");
        return "tno";
    }


    public String studentRegist() throws Exception{
        //补齐空缺字段
        stuE.setRealname("0");
        stuE.setClazz("0");
        stuE.setStudentid("0");
        stuE.setTel("0");
        stuE.setClassmaster("0");
        stuE.setMastertel("0");
        stuE.setCollege("0");
        stuE.setMajor("0");
        stuE.setDorm("0");
        StudentloginEntity studentloginEntity=studentService.saveStuInfoTwo(stuE);
        if (studentloginEntity==null){
            return "error";
        }else {
            return "success";
        }

    }


    @Override
    public StudentloginEntity getModel() {
        return stuE;
    }
}
