package org.meteorologaaguascalientes.Model;

import java.util.Date;

/**
 *
 * @author Diego Gerena (SNIPERCAT) <dagerenaq@gmail.com>
 */
public class Sample {
    private Date timestamp;
    
    Sample(Date timestamp){
        this.timestamp = timestamp;
    }
    
    public Date getTime(){
        return timestamp;
    }
    
    public void setTime(Date timestamp){
        this.timestamp = timestamp;
    }

}
