package org.meteorologaaguascalientes.vo;

import java.util.Date;

/**
 *
 * @author Diego Gerena (SNIPERCAT) <dagerenaq@gmail.com>
 */

public abstract class VariableVo extends ValueObject{
    private double value;
    private Date time;

    //Abstract class to check the value before insert it
    abstract boolean checkValue(double value);

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}


 }