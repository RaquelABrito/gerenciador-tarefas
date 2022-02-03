package br.com.raquel.gerenciadortarefas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.raquel.gerenciadortarefas.model.Tarefa;
import br.com.raquel.gerenciadortarefas.model.Usuario;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
	
	//List<Tarefa> findByUsuarioNome(String nome);
	
	@Query("SELECT t FROM Tarefa  t WHERE id=?1")
	public Tarefa findById(long id);
			
	@Query("SELECT t FROM Tarefa  t WHERE id_usuario =?1")
	public List<Tarefa> findByUsuarioId(long id);

	@Query("SELECT t FROM Tarefa  t WHERE t.situacaoTarefa='EM_ANDAMENTO'")
	public List<Tarefa> findAllAtivas();

	//@Query("SELECT id_usuario FROM Tarefa as t where t.id=?1")
	//public Tarefa findUserFromTaskId(long id);
}
