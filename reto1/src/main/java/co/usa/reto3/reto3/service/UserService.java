package co.usa.reto3.reto3.service;
import co.usa.reto3.reto3.repository.UserRepository;
import co.usa.reto3.reto3.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    public User save(User c) {
        if (c.getId() == null) {
            if (existeEmail(c.getEmail()) == false) {
                return userRepository.save(c);
            } else {
                return c;
            }
        } else {
            return c;
        }
    }

    public boolean existeEmail(String email) {
        return userRepository.emailExistente(email);
    }

    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = userRepository.autenticarUsuario(email, password);
        if (usuario.isEmpty()) {
            return new User(email,password,"NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }
}


