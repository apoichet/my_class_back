package fr.myclass.back.service.connector.das;

import java.util.List;

/**
 * Created by alex on 06/10/17.
 */
public interface Das<E> {

    public E add(E e);

    public boolean remove(E e);

    public E update(E e);

    public List<E> findAll();

    public E find(Integer id);

}
