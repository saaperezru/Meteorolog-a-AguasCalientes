<%@page import="org.meteorologaaguascalientes.dao.DaoList"%>
<%@page import="org.meteorologaaguascalientes.dao.Dao"%>
<%@page contentType="text/json" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%--@page import="org.meteorologaaguascalientes.control.*" --%>
<%@taglib uri="http://www.atg.com/taglibs/json" prefix="json"%>
<%!    Map<Dao, Object> lastValues;
%>
<%--
    // LastValueControl invocation
    LastValueControl lastValueControl = new LastValueControl();
    lastValues = lastValueControl.getAllLastValues();
--%>
<%
    // Expected data model
    lastValues = new HashMap();
    List<Dao> daoList = DaoList.getDao();
    lastValues.put(daoList.get(0), new Date());
    lastValues.put(daoList.get(1), Math.random());
    lastValues.put(daoList.get(2), Math.random());
    lastValues.put(daoList.get(3), Math.random());
%>
<%
    Properties prop = new Properties();
    prop.load(getServletContext().getResourceAsStream("/WEB-INF/config.properties"));

    // Date formatting
    for (Map.Entry<Dao,Object> entry : lastValues.entrySet()) {
        if(entry.getValue() instanceof Date){
            SimpleDateFormat formatter = new SimpleDateFormat(prop.getProperty("dao." + entry.getKey().getVisibleName() + ".extra"));
            entry.setValue(formatter.format(entry.getValue()));
        }
    }
%>
<json:array var="entry" items="<%= lastValues.entrySet()%>">
    <json:object>
        <json:property name="name" value="${entry.getKey().getVisibleName()}" />
        <json:property name="value" value="${entry.getValue()}" />
    </json:object>
</json:array>