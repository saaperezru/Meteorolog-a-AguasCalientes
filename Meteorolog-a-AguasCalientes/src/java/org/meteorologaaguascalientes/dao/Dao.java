/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.dao;

/**
 *
 * @author tuareg
 */
public interface Dao<E> {

    public abstract boolean createRecord(E record);
}
