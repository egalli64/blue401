package blue.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao {
	private static final Logger log = LoggerFactory.getLogger(UserDao.class);

	public  Optional<User> getLogin(String username, String password) {
		EntityManager em = null;
		try {
			em = JpaUtil.createEntityManager();
			String jpql = "FROM User c WHERE c.eMail = :username and c.password = :password";
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			return Optional.of(query.getSingleResult());
		} catch (NoResultException nre) {
			log.debug(String.format("User %s %s: %s", username, password, nre.getMessage()));
			return Optional.empty();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public boolean create(User user) {
		EntityManager em = null;
		EntityTransaction tx = null;
		log.trace("enter");

		try {
			em = JpaUtil.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.persist(user);
			tx.commit();
			return true;
		} catch (Exception ex) {
			log.error("Can't persist entity", ex);
			try {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
			} catch (Exception e) {
				log.warn("Can't rollback transaction", e);
			}
			return false;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public boolean update(User user) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = JpaUtil.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.merge(user);
			tx.commit();
			return true;
		} catch (Exception ex) {
			log.warn("Can't merge entity", ex);
			try {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
			} catch (Exception e) {
				log.warn("Can't rollback transaction", e);
			}
			return false;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public boolean delete(long id) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = JpaUtil.createEntityManager();
			User entity = em.find(User.class, id);
			if (entity != null) {
				tx = em.getTransaction();
				tx.begin();
				em.remove(entity);
				tx.commit();
				return true;
			} else {
				log.info("Can't remove missing user " + id);
				return false;
			}
		} catch (Exception ex) {
			log.warn("Can't remove user " + id, ex);
			try {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
			} catch (Exception e) {
				log.warn("Can't rollback transaction", e);
			}
			return false;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
}
