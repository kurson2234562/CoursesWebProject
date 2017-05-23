package ua.kurson.coursesmanager.model.view;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "marks_view")
@Proxy(lazy = false)
public class MarksView {
    @Id
    @Column(name="id_student_course")
    private long idStudentCourse;

    @Basic
    @Column(name = "id_user", nullable = false, precision = 0)
    private long idLecturer;

    @Basic
    @Column(name = "name_course", nullable = true, length = 70)
    private String nameCourse;

    @Basic
    @Column(name = "start_date")
    private Date startDate;

    @Basic
    @Column(name = "end_date")
    private Date endDate;

    @Basic
    @Column(name = "surname", nullable = true, length = 70)
    private String surname;

    @Basic
    @Column(name = "name", nullable = true, length = 70)
    private String name;

    @Basic
    @Column(name = "patronymic", nullable = true, length = 70)
    private String patronymic;

    @Basic
    @Column(name="mark")
    private long mark;

    public long getIdLecturer() {
        return idLecturer;
    }

    public void setIdLecturer(long idLecturer) {
        this.idLecturer = idLecturer;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public long getMark() {
        return mark;
    }

    public void setMark(long mark) {
        this.mark = mark;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "MarksView{" +
                "idLecturer=" + idLecturer +
                ", nameCourse='" + nameCourse + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", mark=" + mark +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
