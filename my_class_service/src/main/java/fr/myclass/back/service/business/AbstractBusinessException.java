package fr.myclass.back.service.business;

import fr.myclass.back.service.AbstractServiceException;

import static fr.myclass.back.service.business.StudentBS.MAXIMUM_STUDENT_AGE;
import static fr.myclass.back.service.business.StudentBS.MINIMUM_STUDENT_AGE;

public abstract class AbstractBusinessException extends AbstractServiceException{

    private static final String BUSINESS_TROUBLE = "Problème de validation métier : ";

    public static final String ERR_001 = "Un éleve doit avoir au moins un tuteur";
    public static final String ERR_002 = "Un éleve doit avoir un age compris entre "
            + MINIMUM_STUDENT_AGE + " ans et "
            + MAXIMUM_STUDENT_AGE + " ans";


    public AbstractBusinessException(String message) {
        super(BUSINESS_TROUBLE, message);
    }
}
