package com.domain.model;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Table(name = "pedidos")
@Entity
public class Pedido {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY )
		private int num_ped;
		
		@ManyToOne
		@JoinColumn(name = "cod_cli")
		private Cliente cod_cli;
		
		@Column
		@NotBlank
		@DateTimeFormat
		private String data_inicial;
		
		@Column
		@NotBlank
		@DateTimeFormat
		private String data_final;		
		
		@Column
		@NotBlank
		@Size(max = 30)
		private String status_ped;

		@Column
		@NotBlank
		private double valor_total;
		
		
		public Pedido() {
		}

		public Pedido(Cliente cliente, String dataInicial, String dataFinal,
				String status) {
			this.cod_cli = cliente;
			this.data_inicial = dataInicial;
			this.data_final = dataFinal;
			this.status_ped = status;
		}

		public int getNum_ped() {
			return num_ped;
		}

		public void setNum_ped(int num_ped) {
			this.num_ped = num_ped;
		}

		public Cliente getCod_cli() {
			return cod_cli;
		}

		public void setCod_cli(Cliente cod_cli) {
			this.cod_cli = cod_cli;
		}

		public String getData_inicial() {
			return data_inicial;
		}

		public void setData_inicial(String data_inicial) {
			this.data_inicial = data_inicial;
		}

		public String getData_final() {
			return data_final;
		}

		public void setData_final(String data_final) {
			this.data_final = data_final;
		}

		public String getStatus_ped() {
			return status_ped;
		}

		public void setStatus_ped(String status_ped) {
			this.status_ped = status_ped;
		}

		public double getValor_total() {
			return valor_total;
		}

		public void setValor_total(double valor_total) {
			this.valor_total = valor_total;
		}
		
		
}
