package fr.myclass.back.service.connector.das;

import fr.myclass.back.core.domain.Student;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by alex on 06/10/17.
 */
public interface StudentDas extends Das<Student> {

    List<Student> findByFirstName(String name);

    List<Student> findByLastName(String name);

    List<Student> findByClassRoom(String classRoom);

    List<Student> findByBirthDate(LocalDate birthDate);



}
