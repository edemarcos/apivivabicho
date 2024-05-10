package com.vivabicho.api.repositories;


import com.vivabicho.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<User, Long> {

    UserDetails findByLogin(String login);

}
