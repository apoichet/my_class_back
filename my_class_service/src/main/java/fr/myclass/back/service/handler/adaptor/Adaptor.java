package fr.myclass.back.service.handler.adaptor;

/**
 * Created by alex on 17/11/17.
 */
public interface Adaptor<F, D>{

    D adapt(F form);

}
