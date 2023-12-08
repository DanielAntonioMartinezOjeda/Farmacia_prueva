package com.farma.Service;


import com.farma.Model.Role;
import com.farma.Repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService  {

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public Role saveRole(Role role) {
        log.info("Se guardo Role con exito ");
        return roleRepository.save(role);
    }
    @Override
    public void deleteRole(long id) {
        log.info("Se borro Role con exito " + id);
        roleRepository.deleteById(id);
    }

    @Override
    public Role findByIdRole(long id) {
        log.info("Se busco Role con exito " + id);

        Optional<Role> optional = roleRepository.findById(id);
        Role role = null;
        if (optional.isPresent()) {
            role = optional.get();
        } else {
            throw new RuntimeException(" Role no se encontro por id :: " + id);
        }
        return role;
    }

    @Override
    public List<Role> findAllRole() {
        log.info("Se Busco todos los rolescon exito ");
        return (List<Role>) roleRepository.findAll();
    }
}
