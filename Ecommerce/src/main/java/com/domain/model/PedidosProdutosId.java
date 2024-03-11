package com.domain.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class PedidosProdutosId implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "id_prod")
	private Produto id_prod;
	
	@ManyToOne
	@JoinColumn(name = "num_ped")
    private Pedido pedido;

    // default constructor

    
 


	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Produto getId_prod() {
		return id_prod;
	}



	public void setId_prod(Produto id_prod) {
		this.id_prod = id_prod;
	}



	public Pedido getNum_ped() {
		return pedido;
	}



	public void setNum_ped(Pedido pedido) {
		this.pedido = pedido;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id_prod, pedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidosProdutosId other = (PedidosProdutosId) obj;
		return Objects.equals(id_prod, other.id_prod) && Objects.equals(pedido, other.pedido);
	}

   
}