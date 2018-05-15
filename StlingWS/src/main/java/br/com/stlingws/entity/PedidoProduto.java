/**
 * 
 */
package br.com.stlingws.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Jaime Gomes
 * @version 1.0
 * 
 *          Classe que representa a entidade PedidoProduto do banco de dados
 */
@Entity
@Table(name = "pedido_produto")
@XmlRootElement
public class PedidoProduto implements Serializable, Entidade {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_pedido", nullable = false)
	private Pedido pedido;

	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;

	@ManyToOne
	@JoinColumn(name = "id_produto", nullable = false)
	private Produto produto;

	public PedidoProduto() {
	}

	/**
	 * @param pedido
	 * @param quantidade
	 * @param produto
	 */
	public PedidoProduto(Pedido pedido, Integer quantidade, Produto produto) {
		this.pedido = pedido;
		this.quantidade = quantidade;
		this.produto = produto;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}

	/**
	 * @param pedido
	 *            the pedido to set
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	/**
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade
	 *            the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return the produto
	 */
	public Produto getProduto() {
		return produto;
	}

	/**
	 * @param produto
	 *            the produto to set
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
