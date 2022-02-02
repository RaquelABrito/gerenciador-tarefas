package br.com.raquel.gerenciadortarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.raquel.gerenciadortarefas.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	

	
	@Query("SELECT u FROM Usuario  u WHERE id_usuario =?1")
	public Usuario findByIdUser(Integer id);

	public Usuario findById(Integer usuarioResponsavel);
    
	
}
