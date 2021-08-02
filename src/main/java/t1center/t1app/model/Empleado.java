package t1center.t1app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private long id;

    @Column(nullable = false, length = 50)
    private String nombres;

    @Column(nullable = false, length = 50)
    private String apellidos;

    @Column(nullable = false, length = 15, unique = true)
    private String movil;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departamento")
    private Departamento departamento;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ciudad")
    private Ciudad ciudad;

    @Column(nullable = false, length = 255)
    private String direccion;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 50)
    private String contactoAlterno;

    @Column(nullable = false, length = 15)
    private String telefonoContactoAlterno;

    @Column(nullable = false)
    private boolean estado;

}
