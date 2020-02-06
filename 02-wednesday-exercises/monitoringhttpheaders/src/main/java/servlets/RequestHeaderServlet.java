package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author carol
 */
@WebServlet(name = "RequestHeaderServlet", urlPatterns = {"/RequestHeaderServlet"})
public class RequestHeaderServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Made a List of the infomation that needs to be displayed in order to reduce code redundency 
        List<String> info = new ArrayList<>();
            info.add("host");
            info.add("connection");
            info.add("cache-control");
            info.add("accept");
            info.add("user-agent");
            info.add("accept-encoding");
            info.add("accept-language");
            
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RequestHeaderServlet</title>");
            out.println("<style>\n"
                    + "table, th, td {\n"
                    + "  border: 1px solid black;\n"
                    + "}\n"
                    + "</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table>\n"
                    + "  <tr>\n"
                    + "    <th>Header</th>\n"
                    + "    <th>Value</th>\n"
                    + "  </tr>\n");
            for (String string : info) {
                out.println("  <tr>\n"
                        + "    <td>" + string + "</td>\n"
                        + "    <td>" + request.getHeader(string) + "</td>\n");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
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
