package net.dassi.services.impl.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.dassi.services.api.Service;

@Repository
@Transactional
public class ServicesDAO {

	SessionFactory sessionFactory;

	public ServicesDAO() {
		super();
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

	}

	public List<Service> getServices() {
		Session session = sessionFactory.openSession();

		List<Service> list = session.createCriteria(Service.class).list();
		session.close();
		return list;
	}
}
