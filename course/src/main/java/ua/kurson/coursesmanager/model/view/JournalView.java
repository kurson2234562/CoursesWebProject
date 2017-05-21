package ua.kurson.coursesmanager.model.view;

import javax.persistence.*;

import org.hibernate.annotations.Proxy;

import ua.kurson.coursesmanager.model.Courses;
import ua.kurson.coursesmanager.model.Students;

@Entity
@Table(name = "Journal_view")
@Proxy(lazy = false)
public class JournalView {

    @Id
    @Column(name = "id_student_course", nullable = false, precision = 0)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_course", referencedColumnName = "id_course")
    private Courses course;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_student", referencedColumnName = "id")
    private Students student;
    @Basic
    @Column(name = "mark", nullable = true, length = 70)
    private Long mark;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public Long getMark() {
        return mark;
    }

    public void setMark(Long mark) {
        this.mark = mark;
    }
}
