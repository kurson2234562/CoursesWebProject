package ua.kurson.coursesmanager.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Journal {
    private long idStudentCourse;
    private long mark;

    @Id
    @Column(name = "ID_STUDENT_COURSE", nullable = false, precision = 0)
    public long getIdStudentCourse() {
        return idStudentCourse;
    }

    public void setIdStudentCourse(long idStudentCourse) {
        this.idStudentCourse = idStudentCourse;
    }

    @Basic
    @Column(name = "MARK", nullable = false, precision = 0)
    public long getMark() {
        return mark;
    }

    public void setMark(long mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Journal journal = (Journal) o;
        return idStudentCourse == journal.idStudentCourse && mark == journal.mark;
    }

    @Override
    public int hashCode() {
        int result = (int) (idStudentCourse ^ (idStudentCourse >>> 32));
        result = 31 * result + (int) (mark ^ (mark >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "idStudentCourse=" + idStudentCourse +
                ", mark=" + mark +
                '}';
    }
}
