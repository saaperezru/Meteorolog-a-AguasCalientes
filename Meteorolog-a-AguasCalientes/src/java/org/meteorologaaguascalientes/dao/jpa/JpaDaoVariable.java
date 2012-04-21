
package org.meteorologaaguascalientes.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import org.meteorologaaguascalientes.da.DataAccessAdapter;
import org.meteorologaaguascalientes.da.DataAccessException;
import org.meteorologaaguascalientes.dao.VariableDao;
import org.meteorologaaguascalientes.vo.VariableVo;

public class JpaDaoVariable<E extends VariableVo> implements VariableDao<EntityManager, E> {

	@Override
	public E getLastValue(DataAccessAdapter<EntityManager> adapter) throws DataAccessException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public E getLastNValues(DataAccessAdapter<EntityManager> adapter, int n) throws DataAccessException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public E insert(DataAccessAdapter<EntityManager> adapter, E vo) throws DataAccessException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public E update(DataAccessAdapter<EntityManager> adapter, E vo) throws DataAccessException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void delete(DataAccessAdapter<EntityManager> adapter, long id) throws DataAccessException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public E findById(DataAccessAdapter<EntityManager> adapter, long id) throws DataAccessException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public List<E> getAllValues(DataAccessAdapter<EntityManager> adapter) throws DataAccessException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
