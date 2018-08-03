package org.ccfebras.ckp.service.auth;

import org.ccfebras.ckp.model.Role;
import org.ccfebras.ckp.model.RoleName;
import org.ccfebras.ckp.model.User;
import org.ccfebras.ckp.repository.RoleRepository;
import org.ccfebras.ckp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public boolean userExistsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Optional<Role> findRoleByName(RoleName roleName) {
        return roleRepository.findByName(roleName);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
