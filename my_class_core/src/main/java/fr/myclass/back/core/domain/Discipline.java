package fr.myclass.back.core.domain;

import java.util.List;

/**
 * Created by alex on 06/10/17.
 */
public class Discipline {

    private String name;
    private Skills skills;
    private List<Discipline> themes;

    public Discipline(String name) {
        this.name = name;
    }

    public Discipline(String name, Skills skills, List<Discipline> themes) {
        this.name = name;
        this.skills = skills;
        this.themes = themes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Discipline that = (Discipline) o;

        return name != null ? name.equals(that.name) : that.name != null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (skills != null ? skills.hashCode() : 0);
        result = 31 * result + (themes != null ? themes.hashCode() : 0);
        return result;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Discipline> getThemes() {
        return themes;
    }

    public void setThemes(List<Discipline> themes) {
        this.themes = themes;
    }
}
