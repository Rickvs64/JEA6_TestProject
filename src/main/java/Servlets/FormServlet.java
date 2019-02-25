package Servlets;

import Domains.Movie;
import Repositories.MovieRepo;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="FormServlet", urlPatterns="/form")
public class FormServlet extends HttpServlet {

    @EJB
    MovieRepo repo;



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("form1.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Getting an attribute from the index.jsp page, like an input field value
        Long id = Long.parseLong(request.getParameter("id_movie"));
        Movie movie = repo.getMovieById(id);

        request.setAttribute("movie", movie);
        RequestDispatcher view = request.getRequestDispatcher("form_result.jsp");
        view.forward(request, response);
    }
}