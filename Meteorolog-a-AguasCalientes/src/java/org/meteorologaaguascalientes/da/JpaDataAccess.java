package org.meteorologaaguascalientes.da;

import javax.persistence.EntityManager;
import org.meteorologaaguascalientes.dao.AbstractDaoFactory;
import org.xtremeware.testapp.dao.AbstractDaoFactory;
import org.xtremeware.testapp.dao.AbstractDaoFactory.DaoFactoryTypes;

public class JpaDataAccess extends DataAccessAdapter<EntityManager> {

	public JpaDataAccess(EntityManager dataAccess) {
		super(dataAccess);
	}

	@Override
	protected void checkDataAccessClass(EntityManager dataAccess) {
		if (dataAccess != null && !(dataAccess instanceof EntityManager)) {
			throw new IllegalArgumentException("The data access argument must be an instance of javax.persistence.EntityManager");
		}
	}

	@Override
	public void beginTransaction() throws DataAccessException {
		checkDataAccessNotNull();
		dataAccess.getTransaction().begin();
	}

	@Override
	public void commit() throws DataAccessException {
		checkDataAccessNotNull();
		dataAccess.getTransaction().commit();
	}

	@Override
	public void rollback() throws DataAccessException {
		checkDataAccessNotNull();
		dataAccess.getTransaction().rollback();
	}

	@Override
	public void close() throws DataAccessException {
		checkDataAccessNotNull();
		dataAccess.clear();
		dataAccess.close();
	}

	@Override
	public DaoFactoryTypes getType() {
		return AbstractDaoFactory.DaoFactoryTypes.JPA;
	}
}
