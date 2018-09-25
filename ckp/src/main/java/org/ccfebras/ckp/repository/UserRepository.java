package org.ccfebras.ckp.repository;

import org.ccfebras.ckp.model.User;
import org.ccfebras.ckp.repository.base.CommonRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CommonRepository<User> {
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
}
