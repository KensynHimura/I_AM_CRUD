package com.boot.i_am_crud.repository;

import com.boot.i_am_crud.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository <Role, Long> {
}
