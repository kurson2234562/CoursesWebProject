package ua.kurson.coursesmanager.model;

import javax.persistence.*;

@Entity
public class Themes {
    private long idTheme;
    private String nameTheme;

    @Id
    @Column(name = "ID_THEME", nullable = false, precision = 0)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(long idTheme) {
        this.idTheme = idTheme;
    }

    @Basic
    @Column(name = "NAME_THEME", nullable = false, length = 30)
    public String getNameTheme() {
        return nameTheme;
    }

    public void setNameTheme(String nameTheme) {
        this.nameTheme = nameTheme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Themes themes = (Themes) o;

        if (idTheme != themes.idTheme) {
            return false;
        }
        if (nameTheme != null ? !nameTheme.equals(themes.nameTheme) : themes.nameTheme != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idTheme ^ (idTheme >>> 32));
        result = 31 * result + (nameTheme != null ? nameTheme.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Themes{" +
                "idTheme=" + idTheme +
                ", nameTheme='" + nameTheme + '\'' +
                '}';
    }
}
