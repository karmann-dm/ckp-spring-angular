package org.ccfebras.ckp.service.user;

import org.ccfebras.ckp.model.User;

public interface UserService {
    User findUserById(Long id);
}
