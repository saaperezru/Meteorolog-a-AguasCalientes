/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.model;

/**
 *
 * @author Diego Gerena (SNIPERCAT) <dagerenaq@gmail.com>
 */
public class Temperature  extends Variable{

    public Temperature(double value){
        super.setValue(value);
    }

    public Temperature(){
        super.setValue(0);
    }

        @Override
    public boolean checkValue(double value){
            return true;
    }

}