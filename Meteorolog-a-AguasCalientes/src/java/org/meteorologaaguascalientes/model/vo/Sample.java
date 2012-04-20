package org.meteorologaaguascalientes.model.vo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Diego Gerena (SNIPERCAT) <dagerenaq@gmail.com>
 */
public class Sample implements Serializable {

    private Date timestamp;

    public Sample(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sample other = (Sample) obj;
        if (this.timestamp != other.timestamp && (this.timestamp == null || !this.timestamp.equals(other.timestamp))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.timestamp != null ? this.timestamp.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Sample{" + "timestamp=" + timestamp + '}';
    }

    public Date getTime() {
        return timestamp;
    }

    public void setTime(Date timestamp) {
        this.timestamp = timestamp;
    }
}
