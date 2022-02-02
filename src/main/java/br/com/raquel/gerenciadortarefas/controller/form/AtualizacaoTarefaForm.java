package br.com.raquel.gerenciadortarefas.controller.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.raquel.gerenciadortarefas.controller.dto.DetalhesTarefaDto;
import br.com.raquel.gerenciadortarefas.enums.EnumPrioridade;
import br.com.raquel.gerenciadortarefas.model.Tarefa;
import br.com.raquel.gerenciadortarefas.model.Usuario;
import br.com.raquel.gerenciadortarefas.repository.TarefaRepository;
import br.com.raquel.gerenciadortarefas.repository.UsuarioRepository;

public class AtualizacaoTarefaForm {

	@NotNull @NotEmpty @Length(min = 5)
	private String titulo;
	
	private String descricao;
	
	//@NotNull 
	//private Integer usuarioResponsavel;
	
	@NotNull  
	private EnumPrioridade statusPrioridade ;
	
	@NotNull  
	private Date deadline;

	UsuarioRepository usuarioRepository;
	
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

	/*
	public Integer getUsuarioResponsavel() {
		return usuarioResponsavel;
	}
    
	
	public void setUsuarioResponsavel(Integer usuarioResponsavel) {
		this.usuarioResponsavel = usuarioResponsavel;
	}

	*/
	
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

	public Tarefa atualizar(long id, TarefaRepository tarefaRepository) {
		
		//Usuario usuario = tarefaRepository.findById(id);
		Tarefa tarefa = tarefaRepository.findById(id);
		tarefa.setTitulo(this.titulo);
		tarefa.setDescricao(this.descricao);
		//tarefa.setUsuarioResponsavel(usuario); //pegar usuario, seta o id e muda o usuario responsavel
		tarefa.setStatusPrioridade(this.statusPrioridade);
		tarefa.setDeadline(this.deadline);
		
		return tarefa;
	}
	
	
}
