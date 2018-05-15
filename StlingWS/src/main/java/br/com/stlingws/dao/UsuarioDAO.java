package br.com.stlingws.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.stlingws.entity.Usuario;
import br.com.stlingws.factory.EntityManagerProvider;

public class UsuarioDAO {

	private static UsuarioDAO instance;
	private EntityManagerProvider provider = null;
	private EntityManagerFactory factory = null;
	private EntityManager entityManager = null;

	public UsuarioDAO() {
		this.provider = EntityManagerProvider.getInstance();
		this.factory = provider.getFactory();
		this.entityManager = provider.createManager();
		this.entityManager.getTransaction().begin();
	}

	/**
	 * Singleton
	 * 
	 * @return instance
	 */
	public static UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listarVenderores() {
		return this.entityManager
				.createQuery("SELECT u FROM " + Usuario.class.getName() + " u WHERE u.tipoUsuario.id = :vendedor")
				.setParameter("vendedor", 1).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> findByEmail(String email) {
		return this.entityManager
				.createQuery("SELECT u FROM " + Usuario.class.getName() + " u WHERE u.email LIKE :email")
				.setParameter("email", email).getResultList();
	}

	/**
	 * Buscar por id
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public Usuario findById(Integer id) {
		return this.entityManager.find(Usuario.class, id);
	}

	/**
	 * Listar
	 * 
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		return this.entityManager.createQuery("FROM " + Usuario.class).getResultList();
	}

	/**
	 * Salvar (Insere ou Edita)
	 * 
	 * @param obj
	 */
	public Boolean salvar(Usuario usuario) {
		try {
			if (usuario.getId() == null) {
				this.entityManager.persist(usuario);
			} else {
				this.entityManager.merge(usuario);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * Remover
	 * 
	 * @param clazz
	 * @param id
	 */
	public Boolean remover(Integer id) {
		Usuario usuarioBanco = findById(id);
		try {
			this.entityManager.remove(usuarioBanco);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void rollBack() {
		this.entityManager.getTransaction().rollback();
	}

	public void init() {
		if (!this.entityManager.getTransaction().isActive()) {
			this.entityManager.getTransaction().begin();
		}
	}

	public void end() {
		this.entityManager.getTransaction().commit();
	}

	/**
	 * @return the factory
	 */
	public EntityManagerFactory getFactory() {
		return factory;
	}

	/**
	 * @param factory
	 *            the factory to set
	 */
	public void setFactory(EntityManagerFactory factory) {
		this.factory = factory;
	}

	/**
	 * @return the this.entityManager
	 */
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	/**
	 * @param this.entityManager
	 *            the this.entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
