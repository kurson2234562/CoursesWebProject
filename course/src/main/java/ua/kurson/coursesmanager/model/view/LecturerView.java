package ua.kurson.coursesmanager.model.view;


import javax.persistence.*;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "lecturer_view")
@Proxy(lazy = false)
public class LecturerView {

    @Id
    @Column(name = "id_user", nullable = false, precision = 0)
    private long id;

    @Basic
    @Column(name = "name_course", nullable = true, length = 70)
    private String nameCourse;

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
    @Column(name="lecturer_id_user", length = 40)
    private String lecturerIdUser;

    public String getLecturerIdUser() {
        return lecturerIdUser;
    }

    public void setLecturerIdUser(String lecturerIdUser) {
        this.lecturerIdUser = lecturerIdUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "LecturerView{" +
                "id=" + id +
                ", nameCourse='" + nameCourse + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", lecturerIdUser='" + lecturerIdUser + '\'' +
                '}';
    }
}
