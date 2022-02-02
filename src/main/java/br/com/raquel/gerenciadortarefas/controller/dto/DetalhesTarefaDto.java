package br.com.raquel.gerenciadortarefas.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.raquel.gerenciadortarefas.model.Tarefa;

public class DetalhesTarefaDto {

	private Long id;
	
	private String titulo;	

	private String nomeUsuarioResponsavel;

	
	
	public DetalhesTarefaDto(Tarefa tarefa) {
		this.id = tarefa.getId();
		this.titulo = tarefa.getDescricao();
		this.nomeUsuarioResponsavel = tarefa.getUsuarioResponsavel().getNome();
	}
	
	
	
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getNomeUsuarioResponsavel() {
		return nomeUsuarioResponsavel;
	}

	public static List<DetalhesTarefaDto> converter(List<Tarefa> tarefa) {
		return tarefa.stream().map(DetalhesTarefaDto::new).collect(Collectors.toList());
	}
}
