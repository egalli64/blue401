package blue.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParkingDao {
	private static final Logger log = LoggerFactory.getLogger(ParkingDao.class);

	public Optional<ParkingObj> getParkingInfo(long vehicleId, String pName) {
		EntityManager em = null;
		try {
			em = JpaUtil.createEntityManager();
			String jpql = "FROM Parking c WHERE c.parkingName = :pName ";
			TypedQuery<Parking> query = em.createQuery(jpql, Parking.class);
			query.setParameter("pName", pName);
			Parking current = query.getSingleResult();

			if (vehicleId == 1) {
				ParkingObj parking = new ParkingObj(pName, current.getCostCar(), current.getCapacityCar());
				return Optional.of(parking);
			}

			else if (vehicleId == 2) {
				ParkingObj parking = new ParkingObj(pName, current.getCostBike(), current.getCapacityBike());
				return Optional.of(parking);
			}

			else if (vehicleId == 3) {
				ParkingObj parking = new ParkingObj(pName, current.getCostCamper(), current.getCapacityCamper());
				return Optional.of(parking);
			}

			else {
				ParkingObj parking = new ParkingObj(pName, current.getCostElectricVehicle(),
						current.getCapacityElectricVehicle());
				return Optional.of(parking);
			}

		} catch (NoResultException nre) {
			log.debug(String.format("Parking %s: %s", pName, nre.getMessage()));
			return Optional.empty();
		} finally {
			if (em != null) {
				em.close();
			}

		}

	}

	public boolean create(Parking parking) {

		EntityManager em = null;
		EntityTransaction tx = null;
		log.trace("enter");

		try {
			em = JpaUtil.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.persist(parking);
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

	public boolean update(Parking parking) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = JpaUtil.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.merge(parking);
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
				log.info("Can't remove missing parking " + id);
				return false;
			}
		} catch (Exception ex) {
			log.warn("Can't remove parking " + id, ex);
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
