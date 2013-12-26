/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.semeru.model.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author miguelporto
 */
public interface InterfaceDAO<T> {

    void save(T entity);

    void update(T entity);

    void remove(T entity);

    void merge(T entity);

    T getEntity(Serializable id);

    T getEntityByDetachedCriteria(DetachedCriteria criterio);

    List<T> getEntities();

    List<T> getListByDetachedCriteria(DetachedCriteria criteria);
}
