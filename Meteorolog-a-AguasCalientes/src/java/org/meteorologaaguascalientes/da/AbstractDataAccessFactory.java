package org.meteorologaaguascalientes.da;

public interface AbstractDataAccessFactory {

    public DataAccessAdapter createDataAccess() throws DataAccessException;
}
