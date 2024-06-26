package insper.classroom.departamento;

import insper.classroom.departamento.Departamento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;


@Entity
@Table(name = "departamento")
@EqualsAndHashCode(of = "id")
@Builder @Getter @Setter @Accessors(chain = true, fluent = true)
@NoArgsConstructor @AllArgsConstructor
public class DepartamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_departamento")
    private String id;

    @Column(name = "tx_name")
    private String nome;

    @Column(name = "tx_description")
    private String descricao;

    @Column(name = "id_professor")
    private String id_professor;




    public DepartamentoModel(Departamento o) {
        this.id = o.id();
        this.nome = o.nome();
        this.descricao = o.descricao();
        this.id_professor = o.id_professor();

    }

    public Departamento to() {
        return Departamento.builder()
                .id(id)
                .nome(nome)
                .descricao(descricao)
                .id_professor(id_professor)
                .build();
    }

}