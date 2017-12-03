package fr.myclass.back.core.domain;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by alex on 06/10/17.
 */
public class SkillAppreciations extends ArrayList<SkillAppreciation> {

    public boolean exists(SkillAppreciation skillAppreciation){
        return this.stream()
                .filter(Objects::nonNull)
                .anyMatch(sk -> sk.equals(skillAppreciation));
    }

}
