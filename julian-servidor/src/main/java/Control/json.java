/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Bean.ReplyBean;
import Connection.ConnectionInterface;
import Helper.AppConfigurationHelper;
import Helper.EstadoHelper;
import Helper.Log4jConfigurationHelper;
import Helper.MappingServiceHelper;
import static Helper.ParameterCookHelper.prepareCamelCaseObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julian
 */
public class json extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {
        ReplyBean oReplyBean = null;
        try (PrintWriter out = response.getWriter()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (Exception ex) {
                oReplyBean = new ReplyBean(500, "Database Connection Error: Please contact your administrator");
            }
            String ob = prepareCamelCaseObject(request);
            String op = request.getParameter("operacion");
            if (("".equalsIgnoreCase(ob) && "".equalsIgnoreCase(op)) || (ob == null && op == null)) {
                Connection oConnection = null;
                ConnectionInterface oPooledConnection = null;
                response.setContentType("text/html;charset=UTF-8");
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head><title>Proyecto Generico Servidor</title></head>");
                out.println("<body style=\"background: url(trolleyes426.png) no-repeat center center fixed;\">");
                out.println("<h1>Welcome to generic server project</h1><h2>Servlet controller json listening at " + InetAddress.getLocalHost().getHostAddress() + ":" + request.getLocalPort() + request.getContextPath() + "</h2>");
                out.println("");
                try {
                    oPooledConnection = AppConfigurationHelper.getSourceConnection();
                    oConnection = oPooledConnection.newConnection();
                    out.print("<h3>Database Connection OK</h3>");
                } catch (Exception ex) {
                    out.print("<h3>Database Conexión KO</h3>");
                } finally {
                    out.println("</body>");
                    out.println("</html>");
                    if (oConnection != null) {
                        oConnection.close();
                    }
                    if (oPooledConnection != null) {
                        oPooledConnection.disposeConnection();
                    }
                }
            } else {
                response.setContentType("application/json;charset=UTF-8");
                response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
                response.setHeader("Access-Control-Allow-Methods", "GET,POST");
                response.setHeader("Access-Control-Max-Age", "86400");
                response.setHeader("Access-Control-Allow-Credentials", "true");
                response.setHeader("Access-Control-Allow-Headers", "Origin, Accept, x-requested-with, Content-Type");
                try {
                    oReplyBean = (ReplyBean) MappingServiceHelper.executeMethodService(request);
                } catch (Exception ex) {
                    if (EstadoHelper.getTipo_estado() == EstadoHelper.Tipo_estado.Debug) {
                        out.println(ex);
                        ex.printStackTrace(out);
                    } else {
                        oReplyBean = new ReplyBean(500, "Server Error. Please, contact your administrator.");
                    }
                    Log4jConfigurationHelper.errorLog(this.getClass().getName() + ":" + (ex.getStackTrace()[0]).getMethodName(), ex);
                    oReplyBean = new ReplyBean(500, "Object or Operation not found : Please contact your administrator");
                }
                response.setStatus(oReplyBean.getCode());
                out.print("{\"status\":" + oReplyBean.getCode() + ", \"json\":" + oReplyBean.getJson() + "}");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(json.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(json.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    } // </editor-fold>
}
