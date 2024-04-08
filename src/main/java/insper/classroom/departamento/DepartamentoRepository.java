package insper.classroom.departamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends CrudRepository<DepartamentoModel, String>{

    // public Optional<AulaModel> findByEmailAndHash(String email, String hash);
    

}
