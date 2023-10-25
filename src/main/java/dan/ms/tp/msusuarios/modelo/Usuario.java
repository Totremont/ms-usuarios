package dan.ms.tp.msusuarios.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "USR_USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "USER_NAME")
    private String userName;
    private String password;
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "ID_TIPO_USUARIO")
    private TipoUsuario tipoUsuario;

    public Usuario(String userName, String password, String correoElectronico) {
        this.userName = userName;
        this.password = password;
        this.correoElectronico = correoElectronico;
    }
    
    public Usuario(){};
    
    
    
}
