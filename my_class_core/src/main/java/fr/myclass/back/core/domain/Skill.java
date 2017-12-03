package fr.myclass.back.core.domain;

import java.util.List;

/**
 * Created by alex on 06/10/17.
 */
public class Skill {

    private String name;
    private String description;
    private List<Discipline> disciplines;

    public Skill(String name) {
        this.name = name;
    }

    public Skill(String name, String description, List<Discipline> disciplines) {
        this.name = name;
        this.description = description;
        this.disciplines = disciplines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Skill skill = (Skill) o;

        return name != null ? name.equals(skill.name) : skill.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }
}
