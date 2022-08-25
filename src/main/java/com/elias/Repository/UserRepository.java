package com.elias.Repository;

import com.elias.model.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query(nativeQuery = true, value = "SELECT MAX(ID) FROM USERS")
    Integer findbyLastId();

    Users findByEmailAndSenha(String email, String senha);


}
