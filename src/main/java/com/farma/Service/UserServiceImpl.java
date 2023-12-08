package com.farma.Service;

import com.farma.Model.User;
import com.farma.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

@Override
    public User saveUser(User user) {
        log.info("Se guardo Usuario con exito ");
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
        log.info("Se borro Usuario con exito " + id);
    }

    @Override
    public User findByIdUser(long id) {

        Optional<User> optional = userRepository.findById(id);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException(" Rol no se encontro por id :: " + id);
        }

        log.info("Se busco Usuario con exito " + id);
        return user;
    }
     @Override
    public List<User> findAllUser() {
        log.info("Se Busco todos los roles con exito ");
        return (List<User>) userRepository.findAll();
    }
}
