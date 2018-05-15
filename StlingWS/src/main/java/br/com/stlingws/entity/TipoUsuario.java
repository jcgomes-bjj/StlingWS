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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Jaime Gomes
 * @version 1.0
 * 
 *          Classe que representa a entidade TipoUsuario do banco de dados
 */
@Entity
@Table(name = "tipo_usuario")
@XmlRootElement
public class TipoUsuario implements Serializable, Entidade {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "descricao", nullable=false)
	private String descricao;

	public TipoUsuario() {
	}

	/**
	 * @param id
	 * @param descricao
	 */
	public TipoUsuario (String descricao) {
		this.descricao = descricao;
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

}
