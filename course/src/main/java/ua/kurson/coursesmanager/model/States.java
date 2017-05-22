package ua.kurson.coursesmanager.model;

import javax.persistence.*;

@Entity
public class States {
    private Long idState;
    private String nameState;

    public States() {
    }

    public States(long idState) {
        this.idState = idState;
        if (idState == 0) {
            this.nameState = "locked";
        } else if (idState == 1) {
            this.nameState = "unlocked";
        } else {
            throw new EntityNotFoundException();
        }
    }

    public States(long idState, String nameState) {
        this.idState = idState;
        this.nameState = nameState;
    }

    @Id
    @Column(name = "ID_STATE", nullable = false, precision = 0)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getIdState() {
        return idState;
    }

    public void setIdState(Long idState) {
        this.idState = idState;
    }

    @Basic
    @Column(name = "NAME_STATE", nullable = false, length = 10)
    public String getNameState() {
        return nameState;
    }

    public void setNameState(String nameState) {
        this.nameState = nameState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        States states = (States) o;
        return idState.equals(states.idState) && (nameState != null ? nameState.equals(states.nameState) : states.nameState == null);
    }

    @Override
    public int hashCode() {
        int result = (int) (idState ^ (idState >>> 32));
        result = 31 * result + (nameState != null ? nameState.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "States{" +
                "idState=" + idState +
                ", nameState='" + nameState + '\'' +
                '}';
    }

}
