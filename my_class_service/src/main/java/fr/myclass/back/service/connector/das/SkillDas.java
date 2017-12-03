package fr.myclass.back.service.connector.das;

import fr.myclass.back.core.domain.Skill;

/**
 * Created by alex on 06/10/17.
 */
public interface SkillDas extends Das<Skill> {

    Skill findByName(String name);



}
