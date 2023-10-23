/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dan.ms.tp.msusuarios.service;

import dan.ms.tp.msusuarios.dao.ClienteJpaRepository;
import dan.ms.tp.msusuarios.exception.EntityDuplicatedException;
import dan.ms.tp.msusuarios.exception.EntityNotFoundException;
import dan.ms.tp.msusuarios.modelo.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ezequ
 */
public class ClienteService implements IClienteService 
{
    @Autowired private ClienteJpaRepository repo;

    @Override
    public Cliente insert(Cliente cliente) throws EntityDuplicatedException 
    {
        if(cliente.getId() != null) if(repo.existsById(cliente.getId())) throw new EntityDuplicatedException();
        return repo.save(cliente);
    }

    @Override
    public void delete(int id) throws EntityNotFoundException 
    {
        if(repo.existsById(id)) repo.deleteById(id);
        else throw new EntityNotFoundException();
    }

    @Override
    public void update(Cliente cliente) throws EntityNotFoundException 
    {
        if(cliente.getId() != null) 
            if(repo.existsById(cliente.getId())) { 
                repo.save(cliente);
                return;
            }
        throw new EntityNotFoundException();
    }

    @Override
    public Optional<Cliente> findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Optional<Cliente> findByCuit(String cuit) {
        List<Cliente> lista = repo.findByCuit(cuit);
        if(lista.isEmpty()) return Optional.empty();
        else return Optional.of(lista.get(0));
    }
    
    
}
