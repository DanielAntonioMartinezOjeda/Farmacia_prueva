package com.farma.Service;



import com.farma.Model.Role;

import java.util.List;

public interface RoleService {

    public Role saveRole(Role role);

    public void deleteRole(long id);

    public Role findByIdRole(long id);

    public List<Role> findAllRole();
}
