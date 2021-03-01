package s01;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import s01.JpaUtil;
import s01.UserSuperPlain;

public class UserSuperDao {
    private static final Logger log = LoggerFactory.getLogger(UserSuperDao.class);

    public boolean create(UserSuperPlain userSuper) {
        EntityManager em = null;
        EntityTransaction tx = null;
        log.trace("enter");

        try {
            em = JpaUtil.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.persist(userSuper);
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

    public boolean update(UserSuperPlain userSuper) {
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            em = JpaUtil.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.merge(userSuper);
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
            UserSuperPlain entity = em.find(UserSuperPlain.class, id);
            if (entity != null) {
                tx = em.getTransaction();
                tx.begin();
                em.remove(entity);
                tx.commit();
                return true;
            } else {
                log.info("Can't remove missing super user " + id);
                return false;
            }
        } catch (Exception ex) {
            log.warn("Can't remove super user " + id, ex);
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
