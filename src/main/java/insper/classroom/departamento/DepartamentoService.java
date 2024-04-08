package insper.classroom.departamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import insper.classroom.departamento.Departamento;
import insper.classroom.departamento.DepartamentoRepository;
import insper.classroom.aula.AulaController;
import insper.classroom.aula.CreateAulaOut;
import insper.classroom.monitoria.CreateMonitoriaOut;
import insper.classroom.monitoria.MonitoriaController;
import java.util.ArrayList;
import org.springframework.http.ResponseEntity;
@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private AulaController aulaController;

    @Autowired
    private MonitoriaController monitoriaController;

    public Departamento create(Departamento in) {
        return departamentoRepository.save(new DepartamentoModel(in)).to();
    }

    public Departamento read(String id) {
        return departamentoRepository.findById(id).map(DepartamentoModel::to).orElse(null);
    }

    public List<CreateAulaOut> readByDepartamento(String id_departamento) {

        System.out.println(aulaController.getByDepartamento(id_departamento).getBody());

        ResponseEntity<List<CreateAulaOut>> aulas = aulaController.getByDepartamento(id_departamento);

        List<CreateAulaOut> aulasList = aulas.getBody();

        return aulasList;
        
     
    }

    public List<CreateMonitoriaOut> readMonitoriasByDepartamento(String id_departamento) {

        System.out.println(monitoriaController.getByDepartamento(id_departamento).getBody());

        ResponseEntity<List<CreateMonitoriaOut>> monitorias = monitoriaController.getByDepartamento(id_departamento);

        List<CreateMonitoriaOut> monitoriasList = monitorias.getBody();

        return monitoriasList;
        
    }
}
