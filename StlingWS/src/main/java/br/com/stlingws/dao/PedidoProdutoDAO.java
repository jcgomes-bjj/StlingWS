/**
 * 
 */
package br.com.stlingws.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.stlingws.entity.Pedido;
import br.com.stlingws.entity.PedidoProduto;
import br.com.stlingws.factory.EntityManagerProvider;

/**
 * @author Jaime Gomes
 * @version 1.0
 */
public class PedidoProdutoDAO {

	private static PedidoProdutoDAO instance;
	private EntityManagerProvider provider = null;
	private EntityManagerFactory factory = null;
	private EntityManager entityManager = null;

	public PedidoProdutoDAO() {
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
	public static PedidoProdutoDAO getInstance() {
		if (instance == null) {
			instance = new PedidoProdutoDAO();
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
	public PedidoProduto findById(Integer id) {
		return this.entityManager.find(PedidoProduto.class, id);
	}

	/**
	 * Listar
	 * 
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<PedidoProduto> listar() {
		return this.entityManager.createQuery("FROM " + PedidoProduto.class.getName()).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PedidoProduto> findItensPedido(Pedido pedido) throws Exception {
		return this.entityManager
				.createQuery("SELECT u FROM " + PedidoProduto.class.getName() + " u WHERE u.pedido = :pedido")
				.setParameter("pedido", pedido).getResultList();
	}

	/**
	 * Salvar (Insere ou Edita)
	 * 
	 * @param obj
	 */
	public Boolean salvar(PedidoProduto pedidoProduto) {
		try {
			if (pedidoProduto.getId() == null) {
				this.entityManager.persist(pedidoProduto);
			} else {
				this.entityManager.merge(pedidoProduto);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean salvarItens(List<PedidoProduto> listItens) {
		try {

			for (PedidoProduto pedidoProduto : listItens) {
				if (pedidoProduto.getId() == null) {
					this.entityManager.persist(pedidoProduto);
				} else {
					this.entityManager.merge(pedidoProduto);
				}
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
		PedidoProduto pedidoProdutoBanco = findById(id);
		try {
			this.entityManager.remove(pedidoProdutoBanco);
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
