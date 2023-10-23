package dan.ms.tp.msusuarios.dao;

import dan.ms.tp.msusuarios.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dan.ms.tp.msusuarios.modelo.Usuario;
import java.util.List;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<Usuario,Integer>
{
    public List<Usuario> findByCliente(Cliente cliente);
    public List<Usuario> findByTipoUsuario(String tipo);
    
}
