/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.vo;

/**
 *
 * @author Diego Gerena (SNIPERCAT) <dagerenaq@gmail.com>
 */
public class TemperatureVo  extends VariableVo{

    public TemperatureVo(double value){
        super.setValue(value);
    }

    public TemperatureVo(){
        super.setValue(0);
    }

        @Override
    public boolean checkValue(double value){
            return true;
    }

}