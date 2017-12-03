package fr.myclass.back.core.domain;

import fr.myclass.back.core.enumeration.Appreciation;

/**
 * Created by alex on 06/10/17.
 */
public class SkillAppreciation {

    private Appreciation appreciation;
    private final Skill skill;
    private final Discipline discipline;

    public SkillAppreciation(Appreciation appreciation, Skill skill, Discipline discipline) {
        this.appreciation = appreciation;
        this.skill = skill;
        this.discipline = discipline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SkillAppreciation that = (SkillAppreciation) o;

        if (skill != null ? !skill.equals(that.skill) : that.skill != null) return false;
        return discipline != null ? discipline.equals(that.discipline) : that.discipline == null;
    }

    @Override
    public int hashCode() {
        int result = appreciation != null ? appreciation.hashCode() : 0;
        result = 31 * result + (skill != null ? skill.hashCode() : 0);
        result = 31 * result + (discipline != null ? discipline.hashCode() : 0);
        return result;
    }

    public Appreciation getAppreciation() {
        return appreciation;
    }

    public Skill getSkill() {
        return skill;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setAppreciation(Appreciation appreciation) {
        this.appreciation = appreciation;
    }
}
