package fr.myclass.back.core.domain;

import fr.myclass.back.core.enumeration.BloodGroup;
import fr.myclass.back.core.enumeration.ClassRoom;
import org.apache.commons.collections4.Predicate;

import java.time.Period;

import static java.time.LocalDate.now;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

/**
 * Created by alex on 06/10/17.
 */
public class Student extends Person{

    private ClassRoom classRoom;
    private BloodGroup bloodGroup;
    private SkillAppreciations skillAppreciations = new SkillAppreciations();
    private Tutors tutors = new Tutors();

    public Predicate<Student> haveTutors(){
        return student -> isNotEmpty(tutors);
    }

    private Student(StudentBuilder builder) {
        super(builder);
        this.classRoom = builder.classRoom;
        this.bloodGroup = builder.bloodGroup;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public SkillAppreciations getSkillAppreciations() {
        return skillAppreciations;
    }

    public Tutors getTutors() {
        return tutors;
    }

    public boolean addSkillAppreciation(SkillAppreciation skillAppreciation){
        if (skillAppreciations.exists(skillAppreciation)) {
            return false;
        }
        return skillAppreciations.add(skillAppreciation);
    }

    public int getAge(){
        return Period.between(birthDate, now()).getYears();
    }

    public static StudentBuilder builder(){
        return new StudentBuilder();
    }

    public static class StudentBuilder extends PersonBuilder<Student> {
        private ClassRoom classRoom;
        private BloodGroup bloodGroup;

        public StudentBuilder withClassRoom(ClassRoom classRoom) {
            this.classRoom = classRoom;
            return this;
        }

        public StudentBuilder withBloodGroup(BloodGroup bloodGroup) {
            this.bloodGroup = bloodGroup;
            return this;
        }

        public Student build(){
            return new Student(this);
        }
    }



}
