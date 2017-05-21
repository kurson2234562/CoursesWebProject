package ua.kurson.coursesmanager.model;

import javax.persistence.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class Roles {
    private static final Logger logger = LoggerFactory.getLogger(Roles.class);
    private Long idRole;
    private String nameRole;

    public Roles() {
    }

    public Roles(long idRole) {
        this.idRole = idRole;
        if (idRole == 0) {
            this.nameRole = "Admin";
        } else if (idRole == 1) {
            this.nameRole = "Student";
        } else if (idRole == 2) {
            this.nameRole = "Lecturer";
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public String toString() {
        return "Roles{" +
                "idRole=" + idRole +
                ", nameRole='" + nameRole + '\'' +
                '}';
    }

    @Id
    @Column(name = "ID_ROLE", nullable = false, precision = 0)
    public long getIdRole() {
        logger.trace("Role is " + idRole);
        return idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    @Basic
    @Column(name = "NAME_ROLE", nullable = false, length = 10)
    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Roles roles = (Roles) o;

        if (idRole != roles.idRole) {
            return false;
        }
        if (nameRole != null ? !nameRole.equals(roles.nameRole) : roles.nameRole != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idRole ^ (idRole >>> 32));
        result = 31 * result + (nameRole != null ? nameRole.hashCode() : 0);
        return result;
    }
}
