package fr.myclass.back.service.handler.validator;

import fr.myclass.back.service.handler.form.StudentForm;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static fr.myclass.back.service.handler.validator.AbstractValidationException.ERR_001;
import static fr.myclass.back.service.handler.validator.AbstractValidationException.ERR_002;
import static java.time.format.ResolverStyle.STRICT;

/**
 * Created by alex on 01/11/17.
 */
public class StudentFormValidator implements FormValidator<StudentForm>{

    @Override
    public void validate(StudentForm form) throws AbstractValidationException {
        validateMandatoryInput(form);
        validateBirthDate(form);

    }

    private void validateBirthDate(StudentForm form) throws StudentFormValidationException {
        try{
            LocalDate.parse(form.getBirthDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy").withResolverStyle(STRICT));
        }
        catch (Exception e){
            throw new StudentFormValidationException(ERR_002);
        }
    }

    private void validateMandatoryInput(StudentForm form) throws StudentFormValidationException {
        Map<String, String> mandatoryInput = Collections.unmodifiableMap(new HashMap(){
            {
                put("Nom", form.getLastName());
                put("Prenom", form.getFirstName());
            }
        });


        Optional<String> emptyInput = mandatoryInput.entrySet().stream()
                .filter(o -> StringUtils.isEmpty(o.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();

        if (emptyInput.isPresent()) throw new StudentFormValidationException(ERR_001, emptyInput.get());
    }
}
