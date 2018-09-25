package org.ccfebras.ckp.repository;

import org.ccfebras.ckp.model.Role;
import org.ccfebras.ckp.model.RoleName;
import org.ccfebras.ckp.repository.base.CommonRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CommonRepository<Role> {
    Optional<Role> findByName(RoleName roleName);
}
