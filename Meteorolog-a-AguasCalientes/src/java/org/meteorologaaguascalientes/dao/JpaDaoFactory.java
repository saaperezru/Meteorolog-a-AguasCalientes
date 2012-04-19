package org.meteorologaaguascalientes.dao;

import javax.persistence.EntityManager;
import org.xtremeware.testapp.dao.AbstractDaoFactory;
import org.xtremeware.testapp.da.JpaDataAccess;
import org.xtremeware.testapp.dao.UserDao;

public class JpaDaoFactory extends AbstractDaoFactory<JpaDataAccess> {

    private static JpaDaoFactory instance = null;


    private JpaDaoFactory(){}

    public static JpaDaoFactory getInstance(){
	    if(instance == null){
		    instance = new JpaDaoFactory();
	    }
	    return instance;
    }

    @Override
    public UserDao getUserDao() {
	    return UserJpaDao.getInstance();
    }
}
