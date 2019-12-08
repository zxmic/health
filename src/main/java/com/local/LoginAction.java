package com.local;

import com.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import po.entity.StudentloginEntity;
import service.StudentService;

import javax.servlet.ServletContext;

public class LoginAction extends BaseAction implements ModelDriven<StudentloginEntity> {

    private StudentloginEntity stuE=new StudentloginEntity();


    public String studentLogin() throws Exception{
        //1、调用Service执行登录逻辑
        StudentloginEntity studentloginEntity=studentService.checkStu(stuE.getUsername(),stuE.getPassword());
        //2、将返回的StudentloginEntity对象放入session域
        ActionContext.getContext().getSession().put("studentloginEntity",studentloginEntity);
        //3、重定向到项目首页  表明在数据库中查询到学生信息
        if(studentloginEntity!=null){
            System.out.println("查询报空3正确");
            return "success";


        }else {
            System.out.println("查询报空3错误");
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
