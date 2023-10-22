/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dan.ms.tp.msusuarios.service;

import dan.ms.tp.msusuarios.exception.EntityDuplicatedException;
import dan.ms.tp.msusuarios.exception.EntityNotFoundException;
import dan.ms.tp.msusuarios.modelo.Cliente;
import java.util.Optional;

/**
 *
 * @author ezequ
 */
public interface IClienteService 
{
    public int insert(Cliente cliente) throws EntityDuplicatedException;;
    public void delete(int id) throws EntityNotFoundException;
    public void update(Cliente cliente) throws EntityNotFoundException;
    public Optional<Cliente> getById(int id);
    public Optional<Cliente> getByCuit(String cuit);
    
}
