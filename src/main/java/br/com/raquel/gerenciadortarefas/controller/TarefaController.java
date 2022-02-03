package br.com.raquel.gerenciadortarefas.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.raquel.gerenciadortarefas.controller.dto.DetalhesTarefaDto;
import br.com.raquel.gerenciadortarefas.controller.dto.TarefaDto;
import br.com.raquel.gerenciadortarefas.controller.form.AtualizacaoTarefaForm;
import br.com.raquel.gerenciadortarefas.controller.form.TarefaForm;
import br.com.raquel.gerenciadortarefas.model.Tarefa;
import br.com.raquel.gerenciadortarefas.repository.TarefaRepository;
import br.com.raquel.gerenciadortarefas.repository.UsuarioRepository;


@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {
	
	 
	@Autowired
	private TarefaRepository tarefaRepository;
	
	 
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	/*Seleciona todas as tarefas*/
	@GetMapping("/listartarefas")
	@Transactional
	public List<DetalhesTarefaDto> lista() {
		//List<Tarefa> tarefa = tarefaRepository.findAll();
		List<Tarefa> tarefas = tarefaRepository.findAll();
		return DetalhesTarefaDto.converter(tarefas);
	}
	
	/*Seleciona tarefa pelo identificador*/
	@GetMapping("/tarefas/{id}")
	@Transactional
	public  ResponseEntity<DetalhesTarefaDto> detalhesTarefa(@PathVariable Long id) {
		//Evitar que a exception seja devolvida para o cliente no corpo da resposta
		Optional<Tarefa> tarefa = tarefaRepository.findById(id);
		if (tarefa.isPresent()) {
			return ResponseEntity.ok(new DetalhesTarefaDto(tarefa.get()));
		}
	
		return ResponseEntity.notFound().build();
	}
	
	
	/*Criar nova tarefa
	 * Devolver codigo 201- ok cadastro */
	@PostMapping
	@Transactional
	public ResponseEntity<TarefaDto> cadastrarTarefa(@RequestBody @Valid TarefaForm form, UriComponentsBuilder uriBuilder) {
		
		Tarefa tarefa = form.converter(usuarioRepository);
		tarefaRepository.save(tarefa);
		
		URI uri = uriBuilder.path("/tarefas/{id}").buildAndExpand(tarefa.getId()).toUri();
		return ResponseEntity.created(uri).body(new TarefaDto(tarefa));
	}
	
	/*Atualizar tarefa */
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TarefaDto> atualizarTarefa(@PathVariable Long id, @RequestBody @Valid AtualizacaoTarefaForm form ) {
		Tarefa tarefa = form.atualizar(id, tarefaRepository);
		
		return ResponseEntity.ok(new TarefaDto(tarefa));
	}
    
	/*Deletar tarefa */
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> removerTarefa(@PathVariable Long id){
		Optional<Tarefa> optional = tarefaRepository.findById(id);
		if (optional.isPresent()) {
			tarefaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	/*Seleciona lista tarefas de um usuario pelo id*/
	@GetMapping("/tarefas/usuario/{id}")
	@Transactional
	public List<Tarefa> findByUsuarioId(@PathVariable(value="id") long id) {
		if (tarefaRepository.findByUsuarioId(id).isEmpty()) {
			return null;
		}else {
			return tarefaRepository.findByUsuarioId(id);
		}
		
	}
	/*
	@GetMapping
	public List<Tarefa> lista(String nome) {
		//List<Tarefa> tarefa = tarefaRepository.findAll();
		if (nome == null) {
			return tarefaRepository.findAll();
		}else {
			return tarefaRepository.findByUsuarioNome(nome);

		}
	}*/
	
	
}
