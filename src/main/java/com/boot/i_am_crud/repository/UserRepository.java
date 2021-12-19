package com.boot.i_am_crud.repository;

import com.boot.i_am_crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    User findUserByName(String name);

//    @Query("select u from User u where u.gender =: g")
//    User findUserByGender(@RequestParam("g") String gender);
}
