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
        // in.hash(calculateHash(in.password()));
        // in.password(null);
        return departamentoRepository.save(new DepartamentoModel(in)).to();
    }

    public Departamento read(@NonNull String id) {
        return departamentoRepository.findById(id).map(DepartamentoModel::to).orElse(null);
    }

    // public Account read(@NonNull String id) {
    //     return accountRepository.findById(id).map(AccountModel::to).orElse(null);
    // }

    // public Account auth(String email, String password) {
    //     String hash = calculateHash(password);
    //     return accountRepository.findByEmailAndHash(email, hash).map(AccountModel::to).orElse(null);
    // }

    // private String calculateHash(String text) {
    //     try {
    //         MessageDigest digest = MessageDigest.getInstance("SHA-256");
    //         byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
    //         byte[] encoded = Base64.getEncoder().encode(hash);
    //         return new String(encoded);
    //     } catch (NoSuchAlgorithmException e) {
    //         throw new RuntimeException(e);
    //     }
    // }

}