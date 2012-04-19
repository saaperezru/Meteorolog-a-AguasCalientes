/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteorologaaguascalientes.businesslogic.service;

import org.meteorologaaguascalientes.vo.TemperatureVo;
/**
 *
 * @author tuareg
 */
public class TemperatureService extends AbstractVariableService<TemperatureVo> {

	@Override
	public boolean createRecord(TemperatureVo record) {
		boolean add = data.add(record);
		if (lastRecord == null || (lastRecord.getTime().compareTo(record.getTime()))<=0){
			lastRecord = record;
		}
		return true;
	}
	
}
