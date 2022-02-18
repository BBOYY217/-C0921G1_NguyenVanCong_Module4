package com.codegym.casestudy.repository.user;

import com.codegym.casestudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,String> {

}
