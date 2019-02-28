package API;

import Domains.Movie;
import Repositories.MovieRepo;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/movie")
public class MovieAPI {

    @Inject
    private MovieRepo movieRepo;

    @GET
    public List<Movie> getAllMovies() {
        return movieRepo.getAllMovies();
    }

    @Path("/{ID}")
    @GET
    public Movie getMovieById(@PathParam("ID") Integer id) {
        Long l = new Long(id);
        return movieRepo.getMovieById(l);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addMovie(Movie movie) {
        // We will return a custom string
        String response = "";

        if (movieRepo.addMovie(movie)) {
            response = movie.getName() + " has been added.";
        }
        else {
            response = movie.getName() + " could NOT be added.";
        }

        return response;
    }
}
