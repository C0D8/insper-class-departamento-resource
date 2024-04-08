package insper.classroom.departamento;

// import java.nio.charset.StandardCharsets;
// import java.security.MessageDigest;
// import java.security.NoSuchAlgorithmException;
// import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.NonNull;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Departamento create(Departamento in) {
        return departamentoRepository.save(new DepartamentoModel(in)).to();
    }

    public Departamento read(@NonNull String id) {
        return departamentoRepository.findById(id).map(DepartamentoModel::to).orElse(null);
    }
          

}