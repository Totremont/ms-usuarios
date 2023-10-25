/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dan.ms.tp.msusuarios.service;

import dan.ms.tp.msusuarios.exception.EntityDuplicatedException;
import dan.ms.tp.msusuarios.exception.EntityNotFoundException;
import dan.ms.tp.msusuarios.modelo.Usuario;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ezequ
 */
public interface IUsuarioService 
{
    public Usuario insert(Usuario usuario) throws EntityDuplicatedException;
    public void delete(int id) throws EntityNotFoundException;
    public void update(Usuario usuario) throws EntityNotFoundException;
    public Optional<Usuario> findById(int id);
    public Optional<List<Usuario>> findByCliente(int clienteId);
    public Optional<List<Usuario>> findByTipoUsuario(String tipo);
    
}
