package br.com.stlingws.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Jaime Gomes
 * @version 1.0
 * 
 *          Classe que representa a entidade Pedido do banco de dados
 *
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
public class Pedido implements Serializable, Entidade {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_vendedor", nullable = false)
	private Usuario vendedor;

	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_cadastro", nullable = false)
	private Calendar dtCadastro;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_emissao")
	private Calendar dtEmissao;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_faturamento")
	private Calendar dtFaturamento;

	@OneToMany(mappedBy = "pedido", targetEntity = PedidoProduto.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PedidoProduto> itens;

	@Column(name = "valor_total", nullable = false)
	private BigDecimal valorTotal;

	public Pedido() {
	}

	/**
	 * @param vendedor
	 * @param cliente
	 * @param dtCadastro
	 * @param dtEmissao
	 * @param dtFaturamento
	 * @param itens
	 */
	public Pedido(Usuario vendedor, Cliente cliente, Calendar dtCadastro, Calendar dtEmissao, Calendar dtFaturamento,
			BigDecimal valorTotal) {
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.dtCadastro = dtCadastro;
		this.dtEmissao = dtEmissao;
		this.dtFaturamento = dtFaturamento;
		this.valorTotal = valorTotal;
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
	 * @return the vendedor
	 */
	public Usuario getVendedor() {
		return vendedor;
	}

	/**
	 * @param vendedor
	 *            the vendedor to set
	 */
	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the dtCadastro
	 */
	public Calendar getDtCadastro() {
		return dtCadastro;
	}

	/**
	 * @param dtCadastro
	 *            the dtCadastro to set
	 */
	public void setDtCadastro(Calendar dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	/**
	 * @return the dtEmissao
	 */
	public Calendar getDtEmissao() {
		return dtEmissao;
	}

	/**
	 * @param dtEmissao
	 *            the dtEmissao to set
	 */
	public void setDtEmissao(Calendar dtEmissao) {
		this.dtEmissao = dtEmissao;
	}

	/**
	 * @return the dtFaturamento
	 */
	public Calendar getDtFaturamento() {
		return dtFaturamento;
	}

	/**
	 * @param dtFaturamento
	 *            the dtFaturamento to set
	 */
	public void setDtFaturamento(Calendar dtFaturamento) {
		this.dtFaturamento = dtFaturamento;
	}

	/**
	 * @return the itens
	 */
	public List<PedidoProduto> getItens() {
		return itens;
	}

	/**
	 * @param itens
	 *            the itens to set
	 */
	public void setItens(List<PedidoProduto> itens) {
		this.itens = itens;
	}

	/**
	 * @return the valorTotal
	 */
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	/**
	 * @param valorTotal
	 *            the valorTotal to set
	 */
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}
