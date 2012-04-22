<%@page import="org.meteorologaaguascalientes.businesslogic.service.ServicesFactory"%>
<%@page import="org.meteorologaaguascalientes.control.measure.MeasuresList"%>
<%@page import="org.meteorologaaguascalientes.control.measure.Measure"%>
<%@page import="org.meteorologaaguascalientes.dao.Dao"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Properties prop = new Properties();
    prop.load(getServletContext().getResourceAsStream("/WEB-INF/config.properties"));
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Central Meteorológica Aguas Calientes</title>
        <link href="favicon.ico" rel="icon" type="image/x-icon" />
        <link href='http://fonts.googleapis.com/css?family=Didact+Gothic' rel='stylesheet' type='text/css'>
        <link href="css/smoothness/jquery-ui-1.8.18.custom.css" rel="stylesheet" type="text/css" />
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="js/jquery-1.7.1.min.js" ></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js" ></script>
        <script type="text/javascript" src="js/dygraph-combined.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function(){
                var g = null;
                jQuery("input:submit").button();
                jQuery("#tabs").tabs();
                jQuery("#variable").buttonset();
                jQuery("#variable input[type=radio]").click(function(){
                    var j = jQuery(this);
                    if(g != null) {
                        g.updateOptions({file: "history?variable=" + j.val()});
                    } else {
                        g = new Dygraph(document.getElementById("dygraph"), "history?variable=" + j.val(), {animatedZooms: true});
                    }
                });
                jQuery("#variable input[type=radio]:first").click();
                jQuery("#centralTendency").change(function(){
                    getReport(jQuery(this), "CentralTendency");
                });
                jQuery("#spread").change(function(){
                    getReport(jQuery(this), "Spread");
                });
                var f = jQuery("#insertForm");
                f.submit(function(){
                    jQuery.post(f.attr("action"), f.serialize(), function(data){
                        var m = jQuery("#message");
                        m.removeClass("success");
                        m.removeClass("error");
                        if(data.success){
                            m.html("Inserción exitosa");
                            m.addClass("success");
                            updateGraph();
                            getLastValues();
                        } else {
                            m.html("Error en la inserción");
                            m.addClass("error");
                        }
                    });
                    return false;
                });
                getLastValues();
            });
            
            function updateGraph(){
                jQuery("#variable input[type=radio]:checked").click();
            }
            
            function getLastValues() {
                jQuery.get("lastValues.jsp", function(data){
                    for(var i in data){
                        jQuery("#" + data[i].name + "LastValue").html(data[i].value);
                    }
                });
            }
            
            function getReport(j, suffix){
                var measure = j.val();
                if("" == measure){
                    jQuery("td[id$='" + suffix + "']").html("-");
                } else {
                    jQuery.get("report.jsp?measure=" + measure, function(data){
                        for(var i in data){
                            jQuery("#" + data[i].name + suffix).html(data[i].value);
                        }
                    });
                }
            }
        </script>
    </head>
    <body>
        <div style="width: 80%; margin-left: auto; margin-right: auto;">
            <h1>Central Meteorológica Aguas Calientes</h1>
            <form id="insertForm" action="insert.jsp" method="post">
                <table class="main-table">
                    <thead>
                        <tr>
                            <th>&nbsp;</th>
                            <%
                                for (String key : ServicesFactory.VARIABLES_NAMES) {
                            %>
                            <th><%= prop.getProperty(key)%> [<%= prop.getProperty(key + ".extra")%>]</th>
                            <%}%>
                            <th><%= prop.getProperty("sample")%> [<%= prop.getProperty("sample.extra")%>]</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Último valor</td>
                            <%
                                for (String key : ServicesFactory.VARIABLES_NAMES) {
                            %>
                            <td id="<%= key%>LastValue">-</td>
                            <%}%>
                            <td id="<%= "sample"%>LastValue">-</td>
                        </tr>
                        <tr>
                            <td>Nuevo valor</td>
                            <%
                                for (String key : ServicesFactory.VARIABLES_NAMES) {
                            %>
                            <td>        
                                <input type="text" name="<%= key%>" required="required" />
                            </td>
                            <%}%>
                            <td>        
                                <input type="text" name="<%= "sample"%>" required="required" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="<%= ServicesFactory.VARIABLES_NAMES.length%>" id="message" style="text-align: right;"></td>
                            <td style="text-align: right;"><input type="submit" value="Enviar"/></td>
                        </tr>
                    </tbody>
                </table>
                <br/><br/>
            </form>
            <div id="tabs">
                <ul>
                    <li><a href="#tab-1">Histórico</a></li>
                    <li><a href="#tab-2">Reportes</a></li>
                </ul>
                <div id="tab-1">
                    <form id="historyForm" action="history.jsp" method="get">
                        <div id="variable">
                            <%
                                for (String key : ServicesFactory.VARIABLES_NAMES) {
                            %>
                            <input type="radio" name="variable" id="variable<%= key%>" value="<%= key%>"><label for="variable<%= key%>"><%= prop.getProperty(key)%> [<%= prop.getProperty(key + ".extra")%>]</label></input>
                            <%        }
                            %>
                        </div>
                        <div id="dygraph">
                        </div>
                    </form>
                </div>
                <div id="tab-2">
                    <table>
                        <thead>
                            <tr>
                                <th>Medida</th>
                                <%
                                    for (String key : ServicesFactory.VARIABLES_NAMES) {
                                %>
                                <th><%= prop.getProperty(key)%> [<%= prop.getProperty(key + ".extra")%>]</th>
                                <%        }
                                %>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (String typeKey : MeasuresList.getInstance().getMeasuresTypes()) {
                            %>
                            <tr>
                                <td>
                                    <select id="<%= typeKey%>">
                                        <option value=""></option>
                                        <%
                                            for (String key : MeasuresList.getInstance().getMeasuresKeys(typeKey)) {
                                        %>
                                        <option value="<%=key%>"><%= prop.getProperty("measure." + key)%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </td>
                        <div id="variable">
                            <%
                                for (String key : ServicesFactory.VARIABLES_NAMES) {
                            %>
                            <td id="<%= key + typeKey.replaceFirst(typeKey.substring(0, 1),typeKey.substring(0, 1).toUpperCase())%>">-</td>
                            <%  
                                }
                            %>
                            </tr>
                            <% }%>
                            </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
