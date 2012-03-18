/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.dao;

import java.util.ArrayList;
import org.meteorologaaguascalientes.model.Sample;

/**
 *
 * @author tuareg
 */
public class SampleDao implements Dao<Sample>{

	private ArrayList<Sample> samples = new ArrayList<Sample>();

	@Override
	public void createRecord(Sample record) {
		samples.add(record);
	}

}
