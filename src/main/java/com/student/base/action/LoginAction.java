package com.student.base.action;

import com.student.base.LoginBaseAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import po.entity.student.MypointEntity;
import po.entity.student.MywordEntity;
import po.entity.student.StudentloginEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
            //mypointEntity保存 学生某一天的心情点数
            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String sdate=date.format(formatter);
            MypointEntity mypointEntity= todayMoodService.findMoodByStuidAndData(studentloginEntity.getStudentid(),sdate);
            ActionContext.getContext().getSession().put("mypointEntity",mypointEntity);
            //mypointEntities保存学生心情点数链表
            List<MypointEntity> mypointEntities= todayMoodService.findMoodByStuid(studentloginEntity.getStudentid());
            ActionContext.getContext().getSession().put("mypointEntities",mypointEntities);
            //mywordEntity保存我的留言
            MywordEntity mywordEntity=todayFeelingService.fingFeelingByStudentid(studentloginEntity.getStudentid());
            ActionContext.getContext().getSession().put("mywordEntity",mywordEntity);
            System.out.println("login  mywordEntity"+mywordEntity);

            return "success";


        }else {
            System.out.println("登录错误");
            //数据库查询为空的结果
            return "error";
        }


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

    public String teacherLogin() throws Exception{

        System.out.println("xxxno");
        return "tno";
    }

    public String teacherRegist() throws Exception{

        System.out.println("xxxno");
        return "tno";
    }


    @Override
    public StudentloginEntity getModel() {
        return stuE;
    }
}
