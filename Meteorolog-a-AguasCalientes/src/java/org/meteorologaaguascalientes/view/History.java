package org.meteorologaaguascalientes.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.meteorologaaguascalientes.dao.DaoList;
import org.meteorologaaguascalientes.dao.AbstractVariableDao;

@WebServlet(name = "History", urlPatterns = {"/history"})
public class History extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Properties prop = new Properties();
        prop.load(getServletContext().getResourceAsStream("/WEB-INF/config.properties"));
        response.setContentType("text/csv;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String variableName = request.getParameter("variable");
            if (variableName != null) {
                for (AbstractVariableDao variableDao : DaoList.getVariables()) {
                    if (variableDao.getVisibleName().equals(variableName)) {
                        List<SortedMap<Date, Double>> dataList;
                        SortedMap<Date, Double> data;
                        /*
                         * HistoryControl invocation HistoryControl
                         * historyControl = new HistoryControl(); data =
                         * dataList = historyControl.getData(variableDao);
                         */
                        dataList = new ArrayList<SortedMap<Date, Double>>();
                        data = new TreeMap<Date, Double>();
                        Calendar c = Calendar.getInstance();
                        c.set(Calendar.DAY_OF_YEAR, 1);
                        int i = 1;
                        do {
                            data.put(c.getTime(), Math.random());
                            c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) + 1);
                        } while (i++ <= 365);
                        dataList.add(data);

                        data = new TreeMap<Date, Double>();
                        data.put(dataList.get(0).lastKey(), dataList.get(0).get(dataList.get(0).lastKey()));
                        i = 1;
                        do {
                            data.put(c.getTime(), Math.random());
                            c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) + 1);
                        } while (i++ <= 10);
                        dataList.add(data);

                        out.println(prop.getProperty("date") + "," + prop.getProperty("dao." + variableName) + "," + prop.getProperty("forecast"));

                        data = dataList.get(0);
                        for (Map.Entry<Date, Double> entry : data.entrySet()) {
                            out.println(formatter.format(entry.getKey())
                                    + "," + entry.getValue() + ",");
                        }
                        data = dataList.get(1);
                        for (Map.Entry<Date, Double> entry : data.entrySet()) {
                            out.println(formatter.format(entry.getKey())
                                    + ",," + entry.getValue());
                        }

                        return;
                    }
                }
            }

        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
