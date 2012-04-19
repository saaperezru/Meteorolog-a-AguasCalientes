package org.meteorologaaguascalientes.vo;
/**
 *
 * @author Diego Gerena (SNIPERCAT) <dagerenaq@gmail.com>
 */

public class PluviosityVo extends VariableVo {

    public PluviosityVo(double value){
        super.setValue(value);
    }

    public PluviosityVo(){
        super.setValue(0);
    }

        @Override
    public boolean checkValue(double value){
        if(value > 0)
            return true;
        return false;
    }

}
