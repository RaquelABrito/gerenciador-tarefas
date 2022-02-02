package br.com.raquel.gerenciadortarefas.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_usuario")
	private Integer id;
	
	@Column(name="nome", length = 200, nullable = false)
	private String nome;
	
	@Column(name="senha", length = 20, nullable = false)
	private String senha;
	//private String login;
	

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(senha, other.senha);
	}
	
	
	public Integer getId() {
		return id;
	}
	
	public Usuario() {
	
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
	
}
