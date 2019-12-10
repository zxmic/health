package po.entity.teacher;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teacherlogin", schema = "jspssh", catalog = "")
public class TeacherloginEntity {
    private int id;
    private String username;
    private String password;
    private String realname;
    private String niname;
    private String college;
    private String tel;
    private String teacherage;

    @Override
    public String toString() {
        return "TeacherloginEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", niname='" + niname + '\'' +
                ", college='" + college + '\'' +
                ", tel='" + tel + '\'' +
                ", teacherage='" + teacherage + '\'' +
                '}';
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    @Column(name = "niname", nullable = true, length = 20)
    public String getNiname() {
        return niname;
    }

    public void setNiname(String niname) {
        this.niname = niname;
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
    @Column(name = "tel", nullable = true, length = 20)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "teacherage", nullable = true, length = 20)
    public String getTeacherage() {
        return teacherage;
    }

    public void setTeacherage(String teacherage) {
        this.teacherage = teacherage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherloginEntity that = (TeacherloginEntity) o;
        return id == that.id &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(realname, that.realname) &&
                Objects.equals(niname, that.niname) &&
                Objects.equals(college, that.college) &&
                Objects.equals(tel, that.tel) &&
                Objects.equals(teacherage, that.teacherage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, realname, niname, college, tel, teacherage);
    }
}
