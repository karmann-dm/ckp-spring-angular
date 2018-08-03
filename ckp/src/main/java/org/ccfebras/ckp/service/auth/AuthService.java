package org.ccfebras.ckp.service.auth;

import org.ccfebras.ckp.model.Role;
import org.ccfebras.ckp.model.RoleName;
import org.ccfebras.ckp.model.User;

import java.util.Optional;

public interface AuthService {
    boolean userExistsByEmail(String email);
    Optional<Role> findRoleByName(RoleName roleName);
    User saveUser(User user);
}
