/**
 * 
 */
package br.com.stlingws.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Jaime Gomes
 * @version 1.0
 * 
 *          CLasse que representa a entidade Produto do banco de dados
 */
@Entity
@Table(name = "produto")
@XmlRootElement
public class Produto implements Serializable, Entidade {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "descricao", nullable=false)
	private String descricao;

	@Column(name = "valor", nullable=false)
	private BigDecimal valor;

	public Produto() {
	}

	/**
	 * @param id
	 * @param descricao
	 * @param valor
	 */
	public Produto(String descricao, BigDecimal valor) {
		this.descricao = descricao;
		this.valor = valor;
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
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
