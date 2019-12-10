package po.entity.student;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "myword", schema = "jspssh")
public class MywordEntity {
    private int id;
    private String studentid;
    private String todaymyword;

    @Override
    public String toString() {
        return "MywordEntity{" +
                "id=" + id +
                ", studentid='" + studentid + '\'' +
                ", todaymyword='" + todaymyword + '\'' +
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
    @Column(name = "studentid", nullable = true, length = 20)
    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    @Basic
    @Column(name = "todaymyword", nullable = true, length = 200)
    public String getTodaymyword() {
        return todaymyword;
    }

    public void setTodaymyword(String todaymyword) {
        this.todaymyword = todaymyword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MywordEntity that = (MywordEntity) o;
        return id == that.id &&
                Objects.equals(studentid, that.studentid) &&
                Objects.equals(todaymyword, that.todaymyword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentid, todaymyword);
    }
}
