package ua.kurson.coursesmanager.model;

import javax.persistence.*;

@Entity
public class Admins {
    private Long id;
    private String surname;
    private String name;
    private String patronymic;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

        Admins admins = (Admins) o;

        if (id != admins.id) {
            return false;
        }
        if (surname != null ? !surname.equals(admins.surname) : admins.surname != null) {
            return false;
        }
        if (name != null ? !name.equals(admins.name) : admins.name != null) {
            return false;
        }
        if (patronymic != null ? !patronymic.equals(admins.patronymic) : admins.patronymic != null) {
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
        return "Admins{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }
}
