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

public class loginAction extends BaseAction implements ModelDriven<StudentloginEntity> {
//    private String username;
//    private String password;
////    private studentServiceImpl stuServiceImpl=(studentServiceImpl)stuService.;
////    Session session = sessionFactory.openSession();
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    public String studentLogin() throws Exception{
        //从Application域获得spring容器
        //1、获得servletContext对象
        ServletContext sc= ServletActionContext.getServletContext();
        //2、从sc中获得ac容器
        WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
        //3、从容器中获得studentService
        StudentService ss= (StudentService) ac.getBean("studentService");

        //=========================================================================================
        //接收参数
        String inputUserName=ServletActionContext.getRequest().getParameter("username");
        String inputPassword=ServletActionContext.getRequest().getParameter("password");
        //1、调用Service执行登录逻辑
        StudentloginEntity studentloginEntity=studentService.findStuInfoByStuUsername(inputUserName);
        System.out.println("查询报空1");
        //2、将返回的StudentloginEntity对象放入session域
        ActionContext.getContext().getSession().put("studentloginEntity",studentloginEntity);
        System.out.println("查询报空2");
        //3、重定向到项目首页  表明在数据库中查询到学生信息
        if(studentloginEntity!=null){
            System.out.println("查询报空3正确");
            return "sok";

        }else {
            System.out.println("查询报空3错误");
            //数据库查询为空的结果
            return "sno";
        }




        //从数据库查询登录信息
//        StudentloginEntity studentloginEntity=studentService.findStuInfoByStuUsername(username);

//        if (!studentloginEntities.isEmpty()){
//            for(StudentloginEntity studentloginEntity : studentloginEntities){
//                if(studentloginEntity.getPassword()==password){
//                    System.out.println("sok");
//                    return "sok";
//                }
//            }
//        }
//        if(studentloginEntities.isEmpty()){
//            System.out.println("empty  no");
//            return "sno";
//        }

    }
    public String teacherLogin(){
//        if("xxx".equals(username)&&"xxx".equals(password)){
//            System.out.println("xxxok");
//            return "tok";
//        }
        System.out.println("xxxno");
        return "tno";
    }


    @Override
    public StudentloginEntity getModel() {
        return null;
    }
}
