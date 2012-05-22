package cz.nejdr.pexeso.controller;

import cz.nejdr.pexeso.model.Game;
import cz.nejdr.pexeso.model.Player;
import cz.nejdr.pexeso.model.Stats;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mige
 */
@WebServlet(name = "NewGameController", urlPatterns = {"/NewGame"})
public class NewGameController extends HttpServlet {

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

        String viewUrl = "/index.jsp";
        HttpSession session = request.getSession();

        String[] usernames = request.getParameterValues("user");
        String theme = request.getParameter("theme");

        try {
            int size = Integer.parseInt(request.getParameter("size"));

            if (usernames == null || usernames.length < 2 || usernames[0].trim().compareTo("") == 0
                    || usernames[1].trim().compareTo("") == 0) {
                request.setAttribute("error", "Nebylo vyplněno jméno hráče.");
            } else if (size != 16 && size != 64) {
                request.setAttribute("error", "Nepovolená velikost hracího pole");
            } else {
                viewUrl = "/Game";

                Game newGame = new Game(size);
                newGame.addPlayer(new Player(usernames[0]));
                newGame.addPlayer(new Player(usernames[1]));

                session.setAttribute("game", newGame);
                session.setAttribute("theme", theme);

                if (session.getAttribute("stats") == null) {
                    Stats stats = new Stats();
                    session.setAttribute("stats", stats);
                }
            }
        } catch (NumberFormatException ex) {
            request.setAttribute("error", "Nepodařilo se zjistit velikost hracího pole.");
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(viewUrl);
        if (null != dispatcher) {
            dispatcher.forward(request, response);
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
