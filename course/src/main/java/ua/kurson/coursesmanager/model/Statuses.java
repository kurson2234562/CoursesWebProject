package ua.kurson.coursesmanager.model;

import javax.persistence.*;

@Entity
public class Statuses {
    private long idStatus;
    private String nameStatus;

    @Id
    @Column(name = "ID_STATUS", nullable = false, precision = 0)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(long idStatus) {
        this.idStatus = idStatus;
    }

    @Basic
    @Column(name = "NAME_STATUS", nullable = false, length = 25)
    public String getNameStatus() {
        return nameStatus;
    }

    public void setNameStatus(String nameStatus) {
        this.nameStatus = nameStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Statuses statuses = (Statuses) o;
        return idStatus == statuses.idStatus && (nameStatus != null ? nameStatus.equals(statuses.nameStatus) : statuses.nameStatus == null);
    }

    @Override
    public int hashCode() {
        int result = (int) (idStatus ^ (idStatus >>> 32));
        result = 31 * result + (nameStatus != null ? nameStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Statuses{" +
                "idStatus=" + idStatus +
                ", nameStatus='" + nameStatus + '\'' +
                '}';
    }
}
