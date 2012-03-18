package org.meteorologaaguascalientes.model;
/**
 *
 * @author Diego Gerena (SNIPERCAT) <dagerenaq@gmail.com>
 */

public class Pluviosity extends Variable {

    public Pluviosity(double value){
        super.setValue(value);
    }

    public Pluviosity(){
        super.setValue(0);
    }

        @Override
    public boolean checkValue(double value){
        if(value > 0)
            return true;
        return false;
    }

}
