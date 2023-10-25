package dan.ms.tp.msusuarios.dao;

import dan.ms.tp.msusuarios.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dan.ms.tp.msusuarios.modelo.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<Usuario,Integer>
{
    //@Query("SELECT u FROM Usuario u WHERE u.tipoUsuario = tipo")
    public List<Usuario> findByCliente(Cliente cliente);
    
    @Query("SELECT u FROM Usuario u WHERE u.tipoUsuario.tipo = ?1")
    public List<Usuario> findByTipoUsuario(String tipo);
    
}
