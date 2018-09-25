package org.ccfebras.ckp.service.user;

import org.ccfebras.ckp.exception.NotFoundException;
import org.ccfebras.ckp.model.User;
import org.ccfebras.ckp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User", "id", id));
    }
}
