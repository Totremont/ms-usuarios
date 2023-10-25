package dan.ms.tp.msusuarios.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dan.ms.tp.msusuarios.modelo.Cliente;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteJpaRepository extends JpaRepository<Cliente,Integer> 
{
    //Busqueda por firma: find + ByCuit
    public List<Cliente> findByCuit(String cuit);
}
