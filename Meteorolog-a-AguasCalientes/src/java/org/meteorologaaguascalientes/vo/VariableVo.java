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

	@Override
	public String toString() {
		return "VariableVo{" + "value=" + value + ", time=" + time + '}';
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final VariableVo other = (VariableVo) obj;
		if (Double.doubleToLongBits(this.value) != Double.doubleToLongBits(other.value)) {
			return false;
		}
		if (this.time != other.time && (this.time == null || !this.time.equals(other.time))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 43 * hash + (int) (Double.doubleToLongBits(this.value) ^ (Double.doubleToLongBits(this.value) >>> 32));
		hash = 43 * hash + (this.time != null ? this.time.hashCode() : 0);
		return hash;
	}




 }