/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.control.measure;

/**
 *
 * @author juan
 */
public class MeasuresFactory {
    
    private static MeasuresFactory instance;
    
    private MeasuresFactory() {
    }
    
    public synchronized static MeasuresFactory getInstance() {
        while (instance == null) {
			instance = new MeasuresFactory();
		}

		return instance;
    }
    
}
