package fr.myclass.back.service.business;

import fr.myclass.back.core.domain.Student;
import fr.myclass.back.service.connector.das.StudentDas;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static fr.myclass.back.service.business.AbstractBusinessException.ERR_001;
import static fr.myclass.back.service.business.AbstractBusinessException.ERR_002;


/**
 * Created by alex on 01/11/17.
 */
public class StudentBS{

    public static int MINIMUM_STUDENT_AGE = 4;
    public static int MAXIMUM_STUDENT_AGE = 12;

    private StudentDas das;

    public List<String> create(Student student) throws StudentBusinessException {

        List<String> warnings = new ArrayList<>();

        if (CollectionUtils.isEmpty(student.getTutors())){
            throw new StudentBusinessException(ERR_001);
        }

        if (student.getAge() < MINIMUM_STUDENT_AGE || student.getAge() > MAXIMUM_STUDENT_AGE){
            throw  new StudentBusinessException(ERR_002);
        }

        //Ok pour le business on passe au das
        das.add(student);

        return warnings;


    }



}
