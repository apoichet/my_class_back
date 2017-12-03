package fr.myclass.back.service.handler.validator;

import fr.myclass.back.service.AbstractServiceException;

/**
 * Created by alex on 22/10/17.
 */
public abstract class AbstractValidationException extends AbstractServiceException{

    private static final String HANDLER_TROUBLE = "Problème de validation formulaire : ";

    public static final String ERR_001 = "Champ obligatoire : ";

    public static final String ERR_002 = "Date de naissance incorrect";

    public AbstractValidationException(String message) {
        super(HANDLER_TROUBLE, message);
    }
}
