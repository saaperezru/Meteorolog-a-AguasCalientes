package org.meteorologaaguascalientes.dao;

/**
 *
 * @author tuareg
 */
public class DaoFactory {

    
    //private HashMap<String, Dao> daoList = new HashMap<String, Dao>();
    //private HashMap<String, AbstractVariableDao> variablesDao = new HashMap<String, AbstractVariableDao>();
    private static DaoFactory instance;

    private DaoFactory() {
//        Dao<Sample> dao = new SampleDao();
//        daoList.put("sample", dao);
//
//        AbstractVariableDao daoV = new PluviosityDao();
//        String variableName = "pluviosity";
//        daoList.put(variableName, daoV);
//        variablesDao.put(variableName, daoV);
//
//        daoV = new TemperatureDao();
//        variableName = "temperature";
//        daoList.put(variableName, daoV);
//        variablesDao.put(variableName, daoV);
//
//        daoV = new AtmosphericPressureDao();
//        variableName = "atmosphericPressure";
//        daoList.put(variableName, daoV);
//        variablesDao.put(variableName, daoV);
    }

    public static AbstractVariableDao getAtmosphericPressureDaoInstance() {
        return AtmosphericPressureDao.getInstance();
    }

    public static AbstractVariableDao getPluviosityDaoInstance() {
        return PluviosityDao.getInstance();
    }

    public static AbstractVariableDao getTemperatureDaoInstance() {
        return TemperatureDao.getInstance();
    }
    
    public static SampleDao getSampleDaoInstance() {
        return SampleDao.getInstance();
    }

    //public HashMap<String, Dao> getDaoMap() {
    //return daoList;
    //}
    //public HashMap<String, AbstractVariableDao> getVariablesDaoMap() {
    //return variablesDao;
    //}
    //public static List<Dao> getDao() {
    //return new ArrayList<Dao>(DaoFactory.getInstance().getDaoMap().values());
    //}
    //public static List<AbstractVariableDao> getVariables() {
    //return new ArrayList<AbstractVariableDao>(DaoFactory.getInstance().getVariablesDaoMap().values());
    //}
    public synchronized static DaoFactory getInstance() {

        if (instance == null) {
            instance = new DaoFactory();
        }

        return instance;

    }
}
