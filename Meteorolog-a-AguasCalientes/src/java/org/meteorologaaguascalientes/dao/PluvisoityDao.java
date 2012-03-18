/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.dao;

import java.util.ArrayList;
import java.util.List;
import org.meteorologaaguascalientes.model.Pluviosity;
import org.meteorologaaguascalientes.model.Variable;

/**
 *
 * @author tuareg
 */
public class PluvisoityDao extends AbstractVariableDao<Pluviosity>{

	@Override
	public void createRecord(Pluviosity record) {
		boolean add = data.add(record);
		if (lastRecord == null || (lastRecord.getTime().compareTo(record.getTime()))>0){
			lastRecord = record;
		}
	}

	
	
}
