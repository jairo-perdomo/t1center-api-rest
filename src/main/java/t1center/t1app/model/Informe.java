package t1center.t1app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "informes")
public class Informe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_informe")
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaEntrega;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orden")
    private Orden orden;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    @Column(nullable = false, length = 255)
    private String descripcion;

    @Column(nullable = true, columnDefinition = "Double(10,2)")
    private double presupuesto;

    @Column(nullable = true, columnDefinition = "Double(10,2)")
    private double manoObra;

    @Column(nullable = true, columnDefinition = "Double(10,2)")
    private double total;

}
