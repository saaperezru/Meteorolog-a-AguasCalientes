package Model;
/**
 *
 * @author Diego Gerena (SNIPERCAT) <dagerenaq@gmail.com>
 */

public class Pluviosity extends Variable {

    Pluviosity(double value){
        super.setValue(value);
    }

    Pluviosity(){
        super.setValue(0);
    }

        @Override
    public boolean checkValue(double value){
        if(value > 0)
            return true;
        return false;
    }

}