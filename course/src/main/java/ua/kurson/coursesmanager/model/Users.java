package ua.kurson.coursesmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class Users {
    private long idUser;
    private String login;
    private String password;
    private String email;
    private Roles rolesByIdRole;
    private States statesByIdState;

    @Id
    @Column(name = "ID_USER", nullable = false, precision = 0)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "LOGIN", nullable = false, length = 30)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "PASSWORD", nullable = false, length = 40)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "EMAIL", nullable = true, length = 70)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Users users = (Users) o;

        return idUser == users.idUser && (login != null ? login.equals(users.login) : users.login == null) && (password != null ? password.equals(users.password) : users.password == null) && (email != null ? email.equals(users.email) : users.email == null);
    }

    @Override
    public int hashCode() {
        int result = (int) (idUser ^ (idUser >>> 32));
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID_ROLE")
    public Roles getRolesByIdRole() {
        return rolesByIdRole;
    }

    public void setRolesByIdRole(Roles rolesByIdRole) {
        this.rolesByIdRole = rolesByIdRole;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_STATE", referencedColumnName = "ID_STATE")
    public States getStatesByIdState() {
        return statesByIdState;
    }

    public void setStatesByIdState(States statesByIdState) {
        this.statesByIdState = statesByIdState;
    }

    @Override
    public String toString() {
        return "Users{" +
                "idUser=" + idUser +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", rolesByIdRole=" + rolesByIdRole +
                ", statesByIdState=" + statesByIdState +
                '}';
    }
}
