package org.meteorologaaguascalientes.model.vo;

import java.io.Serializable;

/**
 *
 * @author Diego Gerena (SNIPERCAT) <dagerenaq@gmail.com>
 */
public abstract class Variable implements Serializable {

    private double value;
    private Sample sample;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Variable other = (Variable) obj;
        if (Double.doubleToLongBits(this.value) != Double.doubleToLongBits(other.value)) {
            return false;
        }
        if (this.sample != other.sample && (this.sample == null || !this.sample.equals(other.sample))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.value) ^ (Double.doubleToLongBits(this.value) >>> 32));
        hash = 31 * hash + (this.sample != null ? this.sample.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Variable{" + "value=" + value + ", sample=" + sample + '}';
    }

    public Sample getSample() {
        return sample;
    }

    public void setSample(Sample sample) {
        this.sample = sample;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}