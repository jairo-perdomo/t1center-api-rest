package t1center.t1app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "componentes")
public class Componente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_componente")
    private long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo")
    private Tipo tipo;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "marca")
    private Marca marca;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "modelo")
    private Modelo modelo;

    @Column(nullable = false, length = 50, unique = true)
    private String serie;

    @Column(nullable = false, length = 100)
    private String descripcion;

    @Column(nullable = false, columnDefinition = "Double(10,2)")
    private double precio;

    @Column(nullable = false)
    private boolean estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orden")
    private Orden orden;

}
