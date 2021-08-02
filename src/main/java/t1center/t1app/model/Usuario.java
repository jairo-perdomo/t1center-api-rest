package t1center.t1app.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length = 50)
    private String userName;

    @Column(nullable = false, length = 50)
    private String password;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaRegistro;

    @Column(nullable = false)
    private boolean estado;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuarioperfil",
               joinColumns = @JoinColumn(name = "id_usuario"),
               inverseJoinColumns = @JoinColumn(name = "id_perfil"))
    private List<Perfil> perfiles;
}
