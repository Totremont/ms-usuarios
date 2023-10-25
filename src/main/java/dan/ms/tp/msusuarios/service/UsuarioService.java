/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dan.ms.tp.msusuarios.service;

import dan.ms.tp.msusuarios.dao.UsuarioJpaRepository;
import dan.ms.tp.msusuarios.exception.EntityDuplicatedException;
import dan.ms.tp.msusuarios.exception.EntityNotFoundException;
import dan.ms.tp.msusuarios.modelo.Cliente;
import dan.ms.tp.msusuarios.modelo.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ezequ
 */
public class UsuarioService implements IUsuarioService 
{

    @Autowired private UsuarioJpaRepository repo;
    @Autowired private IClienteService clienteService;
    
    @Override
    public Usuario insert(Usuario usuario) throws EntityDuplicatedException 
    {
        if(usuario.getId() != null) if(repo.existsById(usuario.getId())) throw new EntityDuplicatedException();
        return repo.save(usuario);
        
    }

    @Override
    public void delete(int id) throws EntityNotFoundException {
        if(repo.existsById(id)) repo.deleteById(id);
        else throw new EntityNotFoundException();
    }

    @Override
    public void update(Usuario usuario) throws EntityNotFoundException {
        if(usuario.getId() != null) 
            if(repo.existsById(usuario.getId())) { 
                repo.save(usuario);
                return;
            }
        throw new EntityNotFoundException();
    }

    @Override
    public Optional<Usuario> findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Optional<List<Usuario>> findByCliente(int clientId) 
    {
        Optional<Cliente> cliente = clienteService.findById(clientId);
        if(cliente.isPresent())
        {
            List<Usuario> lista = repo.findByCliente(cliente.get());
            return Optional.of(lista);
        } else return Optional.empty();
    }

    @Override
    public Optional<List<Usuario>> findByTipoUsuario(String tipo) {
        List<Usuario> lista = repo.findByTipoUsuario(tipo);
        if(lista.isEmpty()) return Optional.empty();
        else return Optional.of(lista);
    }
    
    
}
