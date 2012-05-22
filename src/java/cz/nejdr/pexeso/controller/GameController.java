/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.nejdr.pexeso.controller;

import cz.nejdr.pexeso.model.Game;
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
@WebServlet(name = "GameController", urlPatterns = {"/Game"})
public class GameController extends HttpServlet {

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

        String viewUrl = "/game.jsp";
        HttpSession session = request.getSession(false); // nevytvářet novou session
        if (session == null || session.getAttribute("game") == null) {
            request.setAttribute("error", "Relace vypršela.");
            viewUrl = "/index.jsp";
        } else {
            String action = request.getParameter("action");
            Game game = (Game) session.getAttribute("game");

            if (action != null && action.compareTo("turn") == 0) {
                int position = Integer.parseInt(request.getParameter("position")) - 1;
                game.turnTheCard(position);
            }
            else
            {
                game.hideFacingCards();
            }

            if (game.isGameFinished()) {
                request.setAttribute("gameFinished", true);
            }
            else if(game.isSecondCardFacing())
                request.setAttribute("refresh", true);

        }

        RequestDispatcher rd = getServletContext().getRequestDispatcher(viewUrl);
        try {
            rd.forward(request, response);
        } catch (Exception e) {
            System.err.println("Nepodarilo se provest predani rizeni.");
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
