package insper.classroom.departamento;

// import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;

// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import insper.classroom.departamento.Departamento;
import insper.classroom.departamento.DepartamentoParser;
import insper.classroom.aula.CreateAulaOut;
import insper.classroom.monitoria.CreateMonitoriaOut;
import java.util.List;


@RestController
public class DepartamentoResource implements DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    // @GetMapping("/accounts/info")
    // public ResponseEntity<Map<String, String>> info() {
    //     return new ResponseEntity<Map<String, String>>(
    //             Map.ofEntries(
    //                     Map.entry("microservice.name", AccountApplication.class.getSimpleName()),
    //                     Map.entry("os.arch", System.getProperty("os.arch")),
    //                     Map.entry("os.name", System.getProperty("os.name")),
    //                     Map.entry("os.version", System.getProperty("os.version")),
    //                     Map.entry("file.separator", System.getProperty("file.separator")),
    //                     Map.entry("java.class.path", System.getProperty("java.class.path")),
    //                     Map.entry("java.home", System.getProperty("java.home")),
    //                     Map.entry("java.vendor", System.getProperty("java.vendor")),
    //                     Map.entry("java.vendor.url", System.getProperty("java.vendor.url")),
    //                     Map.entry("java.version", System.getProperty("java.version")),
    //                     Map.entry("line.separator", System.getProperty("line.separator")),
    //                     Map.entry("path.separator", System.getProperty("path.separator")),
    //                     Map.entry("user.dir", System.getProperty("user.dir")),
    //                     Map.entry("user.home", System.getProperty("user.home")),
    //                     Map.entry("user.name", System.getProperty("user.name")),
    //                     Map.entry("jar", new java.io.File(
    //                             AccountApplication.class.getProtectionDomain()
    //                                     .getCodeSource()
    //                                     .getLocation()
    //                                     .getPath()
    //                     ).toString())
    //             ), HttpStatus.OK
    //     );
    // }

    @Override
    public ResponseEntity<CreateDepartamentoOut> create(CreateDepartamentoIn in) {
        // parser
        Departamento departamento = DepartamentoParser.to(in);
        // insert using service
        departamento = departamentoService.create(departamento);
        // return
        return ResponseEntity.created(
                        ServletUriComponentsBuilder
                                .fromCurrentRequest()
                                .path("/{id}")
                                .buildAndExpand(departamento.id())
                                .toUri())
                .body(DepartamentoParser.to(departamento));
    }

    @Override
    public ResponseEntity<Departamento> get(String id) {
        Departamento departamento = departamentoService.read(id);
        if (departamento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(departamento);
    }

    // chamar rota para listar aulas baseado no departamento

    @Override
    public ResponseEntity<List<CreateAulaOut>> getAulas(String id) {

        List<CreateAulaOut> aulas = departamentoService.readByDepartamento(id);
        if (aulas == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(aulas);
    }


    @Override
    public ResponseEntity<List<CreateMonitoriaOut>> getMonitorias(String id) {

        List<CreateMonitoriaOut> monitorias = departamentoService.readMonitoriasByDepartamento(id);
        if (monitorias == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(monitorias);
    }




}