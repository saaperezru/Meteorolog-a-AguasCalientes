package org.meteorologaaguascalientes.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import org.meteorologaaguascalientes.vo.VariableVo;

/**
 *
 * @author Administrator
 */
@MappedSuperclass
public abstract class VariableMappedSuperclass<E extends VariableVo> implements Serializable, Entity<E> {

    private static final long serialVersionUID = 1L;
    @Id
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "sampleTime", nullable = false)
    private Date time;
    @Column(name = "sample", nullable = false)
    private double value;

    public VariableMappedSuperclass() {
    }

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
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VariableMappedSuperclass other = (VariableMappedSuperclass) obj;
        if (this.time != other.time && (this.time == null || !this.time.equals(other.time))) {
            return false;
        }
        if (Double.doubleToLongBits(this.value) != Double.doubleToLongBits(other.value)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (this.time != null ? this.time.hashCode() : 0);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.value) ^ (Double.doubleToLongBits(this.value) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "VariableMappedSuperclass{" + "time=" + time + ", value=" + value + '}';
    }

    @Override
    public E toVo() {
        E e = getVo();
        e.setTime(this.getTime());
        e.setValue(this.getValue());
        return e;
    }
    
    public abstract E getVo();
}
