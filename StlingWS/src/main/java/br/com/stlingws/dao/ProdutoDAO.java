/**
 * 
 */
package br.com.stlingws.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.stlingws.entity.Produto;
import br.com.stlingws.factory.EntityManagerProvider;

/**
 * @author Jaime Gomes
 * @version 1.0
 */
public class ProdutoDAO {

	private static ProdutoDAO instance;
	private EntityManagerProvider provider = null;
	private EntityManagerFactory factory = null;
	private EntityManager entityManager = null;

	public ProdutoDAO() {
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
	public static  ProdutoDAO getInstance() {
		if (instance == null) {
			instance = new ProdutoDAO();
		}
		return instance;
	}

	/**
	 * Buscar por id
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public Produto findById(Integer id) {
		return this.entityManager.find(Produto.class, id);
	}

	/**
	 * Listar
	 * 
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Produto> listar() {
		return this.entityManager.createQuery("FROM " + Produto.class.getName()).getResultList();
	}

	/**
	 * Salvar (Insere ou Edita)
	 * 
	 * @param obj
	 */
	public Boolean salvar(Produto produto) {
		try {
			if (produto.getId() == null) {
				this.entityManager.persist(produto);
			} else {
				this.entityManager.merge(produto);
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
		Produto produtoBanco = findById(id);
		try {
			this.entityManager.remove(produtoBanco);
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
