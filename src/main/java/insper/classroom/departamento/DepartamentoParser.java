package insper.classroom.departamento;

public class DepartamentoParser {

    public static Departamento to(CreateDepartamentoIn in) {
        return Departamento.builder()
                .id_professor(in.id_professor())
                .nome(in.nome())
                .descricao(in.descricao())
                .data(in.data())
                .duracao(in.duracao())
                .build();
    }
    
    public static CreateDepartamentoOut to(Departamento departamento) {
        return CreateDepartamentoOut.builder()
                .id(departamento.id())
                .build();

    }


}