/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dan.ms.tp.msusuarios.rest;

import dan.ms.tp.msusuarios.exception.EntityDuplicatedException;
import dan.ms.tp.msusuarios.exception.EntityNotFoundException;
import dan.ms.tp.msusuarios.modelo.Cliente;
import dan.ms.tp.msusuarios.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ezequ
 */
@RestController
@RequestMapping("api/clientes")
public class ClienteController 
{
    @Autowired
    private IClienteService service;
    
    @PostMapping
    public ResponseEntity insert(@RequestBody Cliente cliente)
    {
        try
        {
            return ResponseEntity.ok(service.insert(cliente));
            
        } catch(EntityDuplicatedException e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable int id)
    {
        try
        {
            service.delete(id);
            return ResponseEntity.ok(id);
            
        } catch(EntityNotFoundException e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping
    public ResponseEntity update(@RequestBody Cliente cliente)
    {
        try
        {
            service.update(cliente);
            return ResponseEntity.ok(cliente);
            
        } catch(EntityNotFoundException e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping(path = "/{id}")
    public ResponseEntity getById(@PathVariable int id)
    {
        return ResponseEntity.of(service.findById(id));
    }
    
    @GetMapping(path = "/{cuit}")
    public ResponseEntity getByCuit(@PathVariable String cuit)
    {
        return ResponseEntity.of(service.findByCuit(cuit));
    }
    
}
