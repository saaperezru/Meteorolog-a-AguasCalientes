<%@page import="org.meteorologaaguascalientes.dao.DaoList"%>
<%@page import="org.meteorologaaguascalientes.dao.Dao"%>
<%@page contentType="text/json" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%--@page import="org.meteorologaaguascalientes.control.*" --%>
<%@taglib uri="http://www.atg.com/taglibs/json" prefix="json"%>
<%!    Map<String, Object> lastValues;
%>
<%--
    // LastValueControl invocation
    LastValueControl lastValueControl = new LastValueControl();
    lastValues = lastValueControl.getAllLastValues();
--%>
<%
    // Expected data model
    lastValues = new HashMap<String,Object>();
    lastValues.put("sample", new Date());
    lastValues.put("temperature", Math.random());
    lastValues.put("atmosphericPressure", Math.random());
    lastValues.put("pluviosity", Math.random());
%>
<%
    Properties prop = new Properties();
    prop.load(getServletContext().getResourceAsStream("/WEB-INF/config.properties"));

    // Date formatting
    for (Map.Entry<String,Object> entry : lastValues.entrySet()) {
        if(entry.getValue() instanceof Date){
            SimpleDateFormat formatter = new SimpleDateFormat(prop.getProperty("dao." + entry.getKey() + ".extra"));
            entry.setValue(formatter.format(entry.getValue()));
        }
    }
%>
<json:array var="entry" items="<%= lastValues.entrySet()%>">
    <json:object>
        <json:property name="name" value="${entry.getKey()}" />
        <json:property name="value" value="${entry.getValue()}" />
    </json:object>
</json:array>