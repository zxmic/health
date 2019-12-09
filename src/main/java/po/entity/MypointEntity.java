package po.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mypoint", schema = "jspssh", catalog = "")
public class MypointEntity {
    private int id;
    private String studentid;
    private String moodpoint;
    private String whichday;

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
    @Column(name = "moodpoint", nullable = true, length = 20)
    public String getMoodpoint() {
        return moodpoint;
    }

    public void setMoodpoint(String moodpoint) {
        this.moodpoint = moodpoint;
    }

    @Basic
    @Column(name = "whichday", nullable = true, length = 20)
    public String getWhichday() {
        return whichday;
    }

    public void setWhichday(String whichday) {
        this.whichday = whichday;
    }

    @Override
    public String toString() {
        return "MypointEntity{" +
                "id=" + id +
                ", studentid='" + studentid + '\'' +
                ", moodpoint='" + moodpoint + '\'' +
                ", whichday='" + whichday + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MypointEntity that = (MypointEntity) o;
        return id == that.id &&
                Objects.equals(studentid, that.studentid) &&
                Objects.equals(moodpoint, that.moodpoint) &&
                Objects.equals(whichday, that.whichday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentid, moodpoint, whichday);
    }
}
