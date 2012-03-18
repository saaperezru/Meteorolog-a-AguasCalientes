package org.meteorologaaguascalientes.Model;

import java.util.Date;

/**
 *
 * @author Diego Gerena (SNIPERCAT) <dagerenaq@gmail.com>
 */

public abstract class Variable {
    private double value;
    private Sample sample;

    public double getValue(){
        return value;
    }

    public void setValue(double value){
        this.value = value;
    }

    //Abstract class to check the value before insert it
    abstract boolean checkValue(double value);


    /*Methods to manage the variable sample*/
    public void setTime(Date timestamp){
        if (this.sample == null)
            this.sample = new Sample(timestamp);
        else
            this.sample.setTime(timestamp);
    }

    public Date getTime(){
        if (this.sample == null)
            return null;
        else
            return this.sample.getTime();
    }


}