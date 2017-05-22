package ua.kurson.coursesmanager.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Courses {
    private Long idCourse;
    private String nameCourse;
    private Date startDate;
    private Date endDate;
    private Long price;
    private Statuses statusesByIdState;
    private Lecturers lecturersByIdLecturer;
    private Themes themesByIdTheme;

    @Id
    @Column(name = "ID_COURSE", nullable = false, precision = 0)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    @Basic
    @Column(name = "NAME_COURSE", nullable = false, length = 40)
    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    @Basic
    @Column(name = "START_DATE", nullable = true)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "END_DATE", nullable = true)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "PRICE", nullable = true, precision = 0)
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_THEME", referencedColumnName = "ID_THEME")
    public Themes getThemeByIdTheme() {
        return themesByIdTheme;
    }

    public void setThemeByIdTheme(Themes themesByIdTheme) {
        this.themesByIdTheme = themesByIdTheme;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_LECTURER", referencedColumnName = "ID")
    public Lecturers getLecturersByIdLecturer() {
        return lecturersByIdLecturer;
    }

    public void setLecturersByIdLecturer(Lecturers lecturersByIdLecturer) {
        this.lecturersByIdLecturer = lecturersByIdLecturer;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_STATUS", referencedColumnName = "ID_STATUS")
    public Statuses getStatusByIdStatus() {
        return statusesByIdState;
    }

    public void setStatusByIdStatus(Statuses statusesByIdState) {
        this.statusesByIdState = statusesByIdState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Courses courses = (Courses) o;
        return idCourse.equals(courses.idCourse) && (nameCourse != null ? nameCourse.equals(courses.nameCourse) : courses.nameCourse == null) && (startDate != null ? startDate.equals(courses.startDate) : courses.startDate == null) && (endDate != null ? endDate.equals(courses.endDate) : courses.endDate == null) && (price != null ? price.equals(courses.price) : courses.price == null) && (lecturersByIdLecturer != null ? lecturersByIdLecturer.equals(courses.lecturersByIdLecturer) : courses.lecturersByIdLecturer == null) && (themesByIdTheme != null ? !themesByIdTheme.equals(courses.themesByIdTheme) : courses.themesByIdTheme == null) && (statusesByIdState != null ? !statusesByIdState.equals(courses.statusesByIdState) : courses.statusesByIdState == null);
    }

    @Override
    public int hashCode() {
        int result = (int) (idCourse ^ (idCourse >>> 32));
        result = 31 * result + (nameCourse != null ? nameCourse.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (lecturersByIdLecturer != null ? lecturersByIdLecturer.hashCode() : 0);
        result = 31 * result + (themesByIdTheme != null ? themesByIdTheme.hashCode() : 0);
        result = 31 * result + (statusesByIdState != null ? statusesByIdState.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "idCourse=" + idCourse +
                ", nameCourse='" + nameCourse + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                ", statusesByIdState=" + statusesByIdState +
                ", lecturersByIdLecturer=" + lecturersByIdLecturer +
                ", themesByIdTheme=" + themesByIdTheme +
                '}';
    }
}
