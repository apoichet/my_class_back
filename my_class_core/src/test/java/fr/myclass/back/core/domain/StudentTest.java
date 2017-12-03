package fr.myclass.back.core.domain;

import fr.myclass.back.core.enumeration.Appreciation;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;

import static java.time.LocalDate.now;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Created by alex on 21/10/17.
 */
public class StudentTest {

    public static final String FRANCAIS = "Français";
    public static final String SAVOIR_LIRE = "Savoir Lire";
    public static final String MATHEMATIQUE = "Mathematique";
    public static final String SAVOIR_COMPTER = "Savoir compter";
    private Student student;

    @Test
    public void should_give_the_correct_age(){
        //Given
        given_student();
        with_birth_date(1999, 7,18);

        //When
        int age = student.getAge();
        int expect = Period.between(student.birthDate, now()).getYears();

        //Then
        assertThat(age).isEqualTo(expect);
    }

    @Test
    public void should_add_new_skill_appreciation(){
        //Given
        given_student();
        with_skill_appreciation(FRANCAIS, SAVOIR_LIRE, Appreciation.ECA);
        SkillAppreciation skillAppreciation = give_appreciation(MATHEMATIQUE, SAVOIR_COMPTER, Appreciation.A);

        //When
        boolean add = student.addSkillAppreciation(skillAppreciation);

        //Then
        assertThat(add).isTrue();
        assertThat(student.getSkillAppreciations()).hasSize(2);
    }

    @Test
    public void should_not_add_skill_appreciation_when_already_exists(){
        //Given
        given_student();
        with_skill_appreciation(FRANCAIS, SAVOIR_LIRE, Appreciation.ECA);
        SkillAppreciation skillAppreciation = give_appreciation(FRANCAIS, SAVOIR_LIRE, Appreciation.A);

        //When
        boolean add = student.addSkillAppreciation(skillAppreciation);

        //Then
        assertThat(add).isFalse();
        assertThat(student.getSkillAppreciations()).hasSize(1);
    }

    private void with_skill_appreciation(String disciplineName, String skillName, Appreciation appreciation){
        student.addSkillAppreciation(give_appreciation(disciplineName, skillName, appreciation));
    }

    private void with_birth_date(int year, int month, int day){
        student.setBirthDate(LocalDate.of(year, month, day));
    }

    private void given_student(){
        student = Student.builder().build();
    }

    private SkillAppreciation give_appreciation(String disciplineName, String skillName, Appreciation appreciation){
        Discipline discipline = new Discipline(disciplineName);
        Skill skill = new Skill(skillName);
        return new SkillAppreciation(appreciation, skill, discipline);
    }

}