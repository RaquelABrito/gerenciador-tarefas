package br.com.raquel.gerenciadortarefas.controller.dto;

import java.util.Date;


import br.com.raquel.gerenciadortarefas.enums.EnumPrioridade;
import br.com.raquel.gerenciadortarefas.model.Tarefa;
import br.com.raquel.gerenciadortarefas.model.Usuario;

public class TarefaDto {

	
	
	private String titulo;
	
	
	private String descricao;
	

	private Usuario usuarioResponsavel;
	
	
	private EnumPrioridade statusPrioridade ;

	private Date deadline;

	public TarefaDto(Tarefa tarefa) {
		this.titulo = tarefa.getTitulo();
		this.descricao = tarefa.getDescricao();
		this.usuarioResponsavel = tarefa.getUsuarioResponsavel();
		this.statusPrioridade = tarefa.getStatusPrioridade();
		this.deadline = tarefa.getDeadline();
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
