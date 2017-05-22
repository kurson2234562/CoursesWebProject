package ua.kurson.coursesmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT_COURSE", schema = "SYSTEM")
public class StudentCourse {
    private long idStudentCourse;
    private Students idStudent;
    private Courses idCourse;

    @Id
    @Column(name = "ID_STUDENT_COURSE", nullable = false)
    public long getIdStudentCourse() {
        return idStudentCourse;
    }

    public void setIdStudentCourse(long idStudentCourse) {
        this.idStudentCourse = idStudentCourse;
    }

    @ManyToOne
    @JoinColumn(name = "ID_STUDENT", referencedColumnName = "ID")
    public Students getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Students idStudent) {
        this.idStudent = idStudent;
    }

    @ManyToOne
    @JoinColumn(name = "ID_COURSE", referencedColumnName = "ID_COURSE")
    public Courses getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Courses idCourse) {
        this.idCourse = idCourse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentCourse that = (StudentCourse) o;
        return idStudentCourse == that.idStudentCourse;
    }

    @Override
    public int hashCode() {
        return (int) (idStudentCourse ^ (idStudentCourse >>> 32));
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "idStudentCourse=" + idStudentCourse +
                '}';
    }
}
