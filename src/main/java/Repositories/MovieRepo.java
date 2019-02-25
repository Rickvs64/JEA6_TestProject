package Repositories;

import Domains.Movie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;

@Stateless
public class MovieRepo {

    @PersistenceContext(unitName = "payaraHibernate")
    private EntityManager em;


    public List<Movie> getAllMovies() {
        return em.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
    }


    public Movie getMovieById(Long id) {
        return em.find(Movie.class, id);
    }


    @Transactional(REQUIRED)
    public void addMovie(Movie movie) {
        em.persist(movie);
    }
}
