package movieGroup.dao;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import movieGroup.model.Movie;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MovieDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    UserTransaction userTransaction;

    public List<Movie> getMovies() {
        return entityManager.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
    }

    public Movie getMovieById(Long id) {
        return entityManager.createQuery("SELECT m FROM Movie f WHERE m.id = :id", Movie.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public boolean addMovie(Movie movie) {
        try {
            userTransaction.begin();
            entityManager.persist(movie);
            userTransaction.commit();
            return true;
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, "JPA error" + e.getMessage());
            return false;
        }
    }

    public boolean updateMovieMember(Movie movieMember) {
        try {
            userTransaction.begin();
            if (movieMember != null) {
                entityManager.merge(movieMember);
            }
            userTransaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getGlobal().log(Level.SEVERE, "JPA error" + e.getMessage());
            return false;
        }
    }

    public boolean deleteMovieById(Long id) {
        try {
            userTransaction.begin();
            var result = entityManager.createQuery("SELECT m FROM Movie f WHERE m.id = :id", Movie.class)
                    .setParameter("id", id)
                    .getSingleResult();
            if (result != null) {
                entityManager.remove(result);
            }
            userTransaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getGlobal().log(Level.SEVERE, "JPA error" + e.getMessage());
            return false;
        }

    }
}
