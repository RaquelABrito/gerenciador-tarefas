package br.com.raquel.gerenciadortarefas.controller.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import br.com.raquel.gerenciadortarefas.enums.EnumPrioridade;
import br.com.raquel.gerenciadortarefas.model.Tarefa;
import br.com.raquel.gerenciadortarefas.model.Usuario;
import br.com.raquel.gerenciadortarefas.repository.UsuarioRepository;


public class TarefaForm {
	
	@NotNull @NotEmpty @Length(min = 5)
	private String titulo;
	
	private String descricao;
	
	@NotNull 
	private Integer usuarioResponsavel;
	
	@NotNull  
	private EnumPrioridade statusPrioridade ;
	
	@NotNull  
	private Date deadline;
	
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
	
	public Integer getUsuarioResponsavel() {
		return usuarioResponsavel;
	}
	public void setUsuarioResponsavel(Integer usuarioResponsavel) {
		this.usuarioResponsavel = usuarioResponsavel;
	}
	public Tarefa converter(UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.findById(usuarioResponsavel);
		return new Tarefa(titulo, descricao,usuario,statusPrioridade, deadline);
	}
}
