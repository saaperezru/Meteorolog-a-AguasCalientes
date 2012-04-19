/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.businesslogic.service;

import org.meteorologaaguascalientes.vo.AtmosphericPressureVo;

/**
 *
 * @author tuareg
 */
public class AtmosphericPressureService extends AbstractVariableService<AtmosphericPressureVo> {

	@Override
	public boolean createRecord(AtmosphericPressureVo record) {
		boolean add = data.add(record);
		if (lastRecord == null || (lastRecord.getTime().compareTo(record.getTime()))<=0){
			lastRecord = record;
		}
		return true;
	}
}
