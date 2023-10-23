/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dan.ms.tp.msusuarios.config;

import dan.ms.tp.msusuarios.service.ClienteService;
import dan.ms.tp.msusuarios.service.IClienteService;
import dan.ms.tp.msusuarios.service.IUsuarioService;
import dan.ms.tp.msusuarios.service.UsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author ezequ
 */
@Configuration
public class AppMainConfig 
{
    @Bean
    public IUsuarioService getUsuarioServiceImpl()
    {
        return new UsuarioService();
    }
    
    @Bean
    public IClienteService getClienteServiceImpl()
    {
        return new ClienteService();
    }
    
}
