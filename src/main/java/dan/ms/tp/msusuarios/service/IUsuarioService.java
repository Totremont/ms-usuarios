/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dan.ms.tp.msusuarios.service;

import dan.ms.tp.msusuarios.exception.EntityDuplicatedException;
import dan.ms.tp.msusuarios.exception.EntityNotFoundException;
import dan.ms.tp.msusuarios.modelo.Cliente;
import dan.ms.tp.msusuarios.modelo.Usuario;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ezequ
 */
public interface IUsuarioService 
{
    public int insert(Usuario usuario) throws EntityDuplicatedException;
    public void delete(int id) throws EntityNotFoundException;
    public void update(Usuario usuario) throws EntityNotFoundException;
    public Optional<Usuario> getById(int id);
    public Optional<List<Usuario>> getByClient(Cliente cliente);
    public Optional<List<Usuario>> getByTipo(String tipo);
    
}
