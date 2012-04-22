
package org.meteorologaaguascalientes.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import org.meteorologaaguascalientes.da.DataAccessAdapter;
import org.meteorologaaguascalientes.da.DataAccessException;
import org.meteorologaaguascalientes.dao.VariableDao;
import org.meteorologaaguascalientes.entity.VariableMappedSuperclass;
import org.meteorologaaguascalientes.vo.VariableVo;

public class JpaDaoVariable<E extends VariableVo, F extends VariableMappedSuperclass> implements VariableDao<EntityManager, E> {

	@Override
	public E insert(DataAccessAdapter<EntityManager> adapter, E vo) throws DataAccessException {
            checkNullParameters(adapter,"Adapter cannot be null");
            checkNullParameters(adapter.getDataAccess(),"EntityManager cannot be null");
            
            adapter.getDataAccess().persist(voToEntity (vo));
            return vo;
	}

	@Override
	public E update(DataAccessAdapter<EntityManager> adapter, E vo) throws DataAccessException {
            checkNullParameters(adapter,"Adapter cannot be null");
            checkNullParameters(adapter.getDataAccess(),"EntityManager cannot be null");
            
            adapter.getDataAccess().merge(voToEntity (vo));
            return vo;
	}

	@Override
	public void delete(DataAccessAdapter<EntityManager> adapter, Object id) throws DataAccessException {
                adapter.getDataAccess().remove(findById(adapter, id));
	}

	@Override
	public E findById(DataAccessAdapter<EntityManager> adapter, Object id) throws DataAccessException {
            checkNullParameters(adapter,"Adapter cannot be null");
            checkNullParameters(adapter.getDataAccess(),"EntityManager cannot be null");
            
            return (E) adapter.getDataAccess().find(((F)new Object()).getClass(), id).toVo();
	}

        private F voToEntity(E vo) {
            VariableMappedSuperclass<E> vms = new VariableMappedSuperclass<E>();
            vms.setTime(vo.getTime());
            vms.setValue(vo.getValue());
            return (F)vms;
	}
        
        private void checkNullParameters(Object o, String message){
            if(o == null)
                throw new NullPointerException(message);
        }

    @Override
    public E getLastValue(DataAccessAdapter<EntityManager> adapter) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E getLastNValues(DataAccessAdapter<EntityManager> adapter, int n) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<E> getAllValues(DataAccessAdapter<EntityManager> adapter) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
