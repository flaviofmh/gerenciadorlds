package com.lds.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name = "SEQ_HINO", sequenceName = "SEQ_HINO", initialValue = 1)
public class Hino {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="SEQ_HINO")
	private Long id;
	
	private String titulo;
	
	private Integer numero;
	
	@Temporal(TemporalType.DATE)
	private Date dataUsado;
	
	public Hino() {
		super();
	}

	public Hino(String titulo, Integer numero, Date dataUsado) {
		super();
		this.titulo = titulo;
		this.numero = numero;
		this.dataUsado = dataUsado;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getDataUsado() {
		return dataUsado;
	}

	public void setDataUsado(Date dataUsado) {
		this.dataUsado = dataUsado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataUsado == null) ? 0 : dataUsado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hino other = (Hino) obj;
		if (dataUsado == null) {
			if (other.dataUsado != null)
				return false;
		} else if (!dataUsado.equals(other.dataUsado))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

}
