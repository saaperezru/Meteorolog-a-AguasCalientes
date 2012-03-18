/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.model;

/**
 *
 * @author Diego Gerena (SNIPERCAT) <dagerenaq@gmail.com>
 */
public class AtmosphericPressure extends Variable {

    public AtmosphericPressure(double value){
        super.setValue(value);
    }

    public AtmosphericPressure(){
        super.setValue(0);
    }

        @Override
    public boolean checkValue(double value){
        if(value >= 0)
            return true;
        return false;
    }

}
