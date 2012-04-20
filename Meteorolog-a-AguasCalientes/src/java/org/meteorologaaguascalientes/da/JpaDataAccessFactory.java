package org.meteorologaaguascalientes.da;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaDataAccessFactory implements AbstractDataAccessFactory {

	public static String PERSISTENCE_UNIT = "AAAA";
	
	private String persistenceUnit;
	private EntityManagerFactory EMFactory;

	public JpaDataAccessFactory(String persistenceUnit) {
		this.persistenceUnit = persistenceUnit;
		EMFactory = Persistence.createEntityManagerFactory(persistenceUnit);
	}

	public DataAccessAdapter createDataAccess() {
		return new JpaDataAccess(EMFactory.createEntityManager());
	}
}
