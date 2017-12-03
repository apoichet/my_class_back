package fr.myclass.back.service.handler;

import fr.myclass.back.core.domain.Student;
import fr.myclass.back.service.business.StudentBusinessException;
import fr.myclass.back.service.business.StudentBS;
import fr.myclass.back.service.handler.adaptor.StudentAdapator;
import fr.myclass.back.service.handler.form.StudentForm;
import fr.myclass.back.service.handler.validator.AbstractValidationException;
import fr.myclass.back.service.handler.validator.FormValidator;

import java.util.List;

import static fr.myclass.back.service.business.Grade.*;
import static org.apache.commons.lang3.StringUtils.EMPTY;

/**
 * Created by alex on 06/10/17.
 */
public class StudentHandler implements IStudentHandler{

    private FormValidator validator;
    private StudentAdapator adapator;
    private StudentBS service;

    public void create(StudentForm studentForm) throws AbstractValidationException{

        try {
            validator.validate(studentForm);
            Student student = adapator.adapt(studentForm);
            List<String> warnings = service.create(student);

            //Les warings
            warnings.forEach(s -> studentForm.addResponse(WARNING, s));

            //En cas de succès
            studentForm.addResponse(SUCCESS, EMPTY);

        }
        catch (StudentBusinessException e){
            studentForm.addResponse(ERROR, e.getMessage());
        }

    }

}
