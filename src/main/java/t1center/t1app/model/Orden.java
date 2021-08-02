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
@Table(name = "ordenes")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden")
    private long id;

    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipo")
    private Equipo equipo;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "empleado")
    private Empleado empleado;

    @OneToMany(mappedBy = "orden")
    private List<Componente> componentes;

    @Column(nullable = false, length = 255)
    private String descripcion;

    @Column(nullable = false, length = 255)
    private String observaciones;

    @Column(length = 255)
    private String accesorios;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estado")
    private Estado estado;



}
