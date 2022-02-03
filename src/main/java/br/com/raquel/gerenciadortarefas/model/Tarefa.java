package br.com.raquel.gerenciadortarefas.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


import br.com.raquel.gerenciadortarefas.enums.EnumPrioridade;
import br.com.raquel.gerenciadortarefas.enums.EnumSituacaoTarefa;

@Entity
@Table(name="tarefa")
public class Tarefa {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="titulo", length = 200, nullable = false)
	private String titulo;
	
	@Column(name="descricao", length = 2000, nullable = false)
	private String descricao;
	
	@JoinColumn(name="id_usuario")
	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario usuarioResponsavel;
	
	@Enumerated(EnumType.STRING) 
	@Column(name="statusPrioridade")
	private EnumPrioridade statusPrioridade ;
	
	@Enumerated(EnumType.STRING) 
	@Column(name="situacaoTarefa")
	private EnumSituacaoTarefa situacaoTarefa = EnumSituacaoTarefa.EM_ANDAMENTO;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date deadline;
	
	public Tarefa() {
		
	}
	
	public Tarefa(Tarefa tarefa) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.usuarioResponsavel = usuarioResponsavel;
		this.statusPrioridade = statusPrioridade;
		this.situacaoTarefa = situacaoTarefa;
		this.deadline = deadline;
	}
	
	
	public Tarefa(Long id, String titulo, String descricao, Usuario usuarioResponsavel, EnumPrioridade statusPrioridade,
			EnumSituacaoTarefa situacaoTarefa, Date deadline) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.usuarioResponsavel = usuarioResponsavel;
		this.statusPrioridade = statusPrioridade;
		this.situacaoTarefa = situacaoTarefa;
		this.deadline = deadline;
	}

	public Tarefa(String titulo, String descricao, Usuario usuarioResponsavel, EnumPrioridade statusPrioridade,
			Date deadline) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.usuarioResponsavel = usuarioResponsavel;
		this.statusPrioridade = statusPrioridade;
		this.deadline = deadline;
	}






	@Override
	public int hashCode() {
		return Objects.hash(deadline, descricao, id, statusPrioridade, titulo, usuarioResponsavel);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(deadline, other.deadline) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && statusPrioridade == other.statusPrioridade
				&& Objects.equals(titulo, other.titulo) && Objects.equals(usuarioResponsavel, other.usuarioResponsavel);
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Usuario getUsuarioResponsavel() {
		return usuarioResponsavel;
	}
	public void setUsuarioResponsavel(Usuario usuarioResponsavel) {
		this.usuarioResponsavel = usuarioResponsavel;
	}
	public EnumPrioridade getStatusPrioridade() {
		return statusPrioridade;
	}
	public void setStatusPrioridade(EnumPrioridade statusPrioridade) {
		this.statusPrioridade = statusPrioridade;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	
	
	
}
