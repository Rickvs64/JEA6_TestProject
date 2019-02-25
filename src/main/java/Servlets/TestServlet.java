package Servlets;

import Domains.Movie;
import Repositories.IMovieRepo;
import Repositories.MovieRepo;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="TestServlet", urlPatterns="/test")
public class TestServlet extends HttpServlet {

    @EJB
    MovieRepo repo;



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Movie movie = new Movie();
        movie.setName("The Avengers");
        repo.addMovie(movie);
        request.setAttribute("movies", repo.getAllMovies());

        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Getting an attribute from the index.jsp page, like an input field value
        // String test1 = request.getParameter("name")
        // repo.getMovieById(test1.toString());

        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }
}
