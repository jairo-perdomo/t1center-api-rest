package t1center.t1app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "equipos")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo")
    private long id;

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

    @Column(nullable = false)
    private boolean estado;
}
