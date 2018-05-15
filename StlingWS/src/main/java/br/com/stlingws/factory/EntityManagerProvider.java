package br.com.stlingws.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {

	private static EntityManagerProvider instance;

	private final EntityManagerFactory factory;

	private EntityManagerProvider() {
		this.factory = Persistence.createEntityManagerFactory("persistence_unit_stling");
	}

	public static EntityManagerProvider getInstance() {
		if (instance == null) {
			instance = new EntityManagerProvider();
		}

		return instance;

	}

	public EntityManagerFactory getFactory() {
		return factory;
	}

	public EntityManager createManager() {
		return factory.createEntityManager();
	}

}
