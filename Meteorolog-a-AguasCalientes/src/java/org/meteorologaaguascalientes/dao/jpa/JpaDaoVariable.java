
package org.meteorologaaguascalientes.dao.jpa;

import javax.persistence.EntityManager;
import org.meteorologaaguascalientes.da.DataAccessAdapter;
import org.meteorologaaguascalientes.da.DataAccessException;
import org.meteorologaaguascalientes.dao.VariableDao;
import org.meteorologaaguascalientes.entity.VariableMappedSuperclass;
import org.meteorologaaguascalientes.vo.VariableVo;

public abstract class JpaDaoVariable<E extends VariableVo, F extends VariableMappedSuperclass> implements VariableDao<EntityManager, E> {

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

        public abstract F voToEntity(E vo);
        
        private void checkNullParameters(Object o, String message){
            if(o == null)
                throw new NullPointerException(message);
        }
}
