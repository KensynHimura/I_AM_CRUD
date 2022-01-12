package com.boot.i_am_crud.service;


import com.boot.i_am_crud.model.Role;
import com.boot.i_am_crud.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> allRoles() {
        return roleRepository.findAll();
    }
}

