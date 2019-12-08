package po.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component("student1")
@Entity
@Table(name = "studentlogin", schema = "jspssh")
public class StudentloginEntity implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String realname;
    private String clazz;
    private String studentid;
    private String tel;
    private String classmaster;
    private String mastertel;
    private String college;
    private String major;
    private String dorm;

    @Override
    public String toString() {
        return "StudentloginEntity{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public StudentloginEntity() {

    }

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = true, length = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "realname", nullable = true, length = 20)
    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Basic
    @Column(name = "class", nullable = true, length = 20)
    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @Basic
    @Column(name = "studentid", nullable = true, length = 20)
    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    @Basic
    @Column(name = "tel", nullable = true, length = 20)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "classmaster", nullable = true, length = 20)
    public String getClassmaster() {
        return classmaster;
    }

    public void setClassmaster(String classmaster) {
        this.classmaster = classmaster;
    }

    @Basic
    @Column(name = "mastertel", nullable = true, length = 20)
    public String getMastertel() {
        return mastertel;
    }

    public void setMastertel(String mastertel) {
        this.mastertel = mastertel;
    }

    @Basic
    @Column(name = "college", nullable = true, length = 20)
    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Basic
    @Column(name = "major", nullable = true, length = 20)
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Basic
    @Column(name = "dorm", nullable = true, length = 20)
    public String getDorm() {
        return dorm;
    }

    public void setDorm(String dorm) {
        this.dorm = dorm;
    }

    StudentloginEntity(Integer id, String username, String password, String realname, String clazz, String studentid, String tel, String classmaster, String mastertel, String college, String major, String dorm) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.clazz = clazz;
        this.studentid = studentid;
        this.tel = tel;
        this.classmaster = classmaster;
        this.mastertel = mastertel;
        this.college = college;
        this.major = major;
        this.dorm = dorm;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) {return false;}

        StudentloginEntity that = (StudentloginEntity) o;

        if (id != that.id) {return false;}
        if (username != null ? !username.equals(that.username) : that.username != null) {return false;}
        if (password != null ? !password.equals(that.password) : that.password != null) {return false;}
        if (realname != null ? !realname.equals(that.realname) : that.realname != null) {return false;}
        if (clazz != null ? !clazz.equals(that.clazz) : that.clazz != null) {return false;}
        if (studentid != null ? !studentid.equals(that.studentid) : that.studentid != null) {return false;}
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) {return false;}
        if (classmaster != null ? !classmaster.equals(that.classmaster) : that.classmaster != null) {return false;}
        if (mastertel != null ? !mastertel.equals(that.mastertel) : that.mastertel != null) {return false;}
        if (college != null ? !college.equals(that.college) : that.college != null) {return false;}
        if (major != null ? !major.equals(that.major) : that.major != null) {return false;}
        if (dorm != null ? !dorm.equals(that.dorm) : that.dorm != null) {return false;}

        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;//id;
//        result = 31 * result + (username != null ? username.hashCode() : 0);
//        result = 31 * result + (password != null ? password.hashCode() : 0);
//        result = 31 * result + (realname != null ? realname.hashCode() : 0);
//        result = 31 * result + (clazz != null ? clazz.hashCode() : 0);
//        result = 31 * result + (studentid != null ? studentid.hashCode() : 0);
//        result = 31 * result + (tel != null ? tel.hashCode() : 0);
//        result = 31 * result + (classmaster != null ? classmaster.hashCode() : 0);
//        result = 31 * result + (mastertel != null ? mastertel.hashCode() : 0);
//        result = 31 * result + (college != null ? college.hashCode() : 0);
//        result = 31 * result + (major != null ? major.hashCode() : 0);
//        result = 31 * result + (dorm != null ? dorm.hashCode() : 0);
        return result;
    }
}
