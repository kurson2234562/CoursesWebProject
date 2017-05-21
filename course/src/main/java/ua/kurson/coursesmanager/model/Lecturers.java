package ua.kurson.coursesmanager.model;

import javax.persistence.*;

@Entity
public class Lecturers {
    private long id;
    private String surname;
    private String name;
    private String patronymic;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "SURNAME", nullable = false, length = 30)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "PATRONYMIC", nullable = true, length = 50)
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Lecturers lecturers = (Lecturers) o;

        if (id != lecturers.id) {
            return false;
        }
        if (surname != null ? !surname.equals(lecturers.surname) : lecturers.surname != null) {
            return false;
        }
        if (name != null ? !name.equals(lecturers.name) : lecturers.name != null) {
            return false;
        }
        if (patronymic != null ? !patronymic.equals(lecturers.patronymic) : lecturers.patronymic != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Lecturers{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }
}
