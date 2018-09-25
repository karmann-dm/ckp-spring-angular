package org.ccfebras.ckp.service.auth;
import lombok.extern.slf4j.Slf4j;
import org.ccfebras.ckp.exception.AppException;
import org.ccfebras.ckp.exception.NotFoundException;
import org.ccfebras.ckp.model.Degree;
import org.ccfebras.ckp.model.Role;
import org.ccfebras.ckp.model.RoleName;
import org.ccfebras.ckp.model.User;
import org.ccfebras.ckp.repository.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Slf4j
public class AuthServiceImplTest {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthService authService;

    @Autowired
    private DegreeRepository degreeRepository;

    @Autowired
    private RankRepository rankRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Before
    public void prepareData() {
        User user = new User();
        user.setFirstName("TEST_BEFORE");
        user.setSecondName("USER_BEFORE");
        user.setLastName("AuthServiceImplTest");
        Role userRole = authService.findRoleByName(RoleName.ROLE_USER).orElseThrow(() -> new AppException("User role not set."));
        user.setRoles(Collections.singleton(userRole));

        user.setEmail("email2@email.email");
        user.setPassword(passwordEncoder.encode("qwe"));
        user.setDegree(degreeRepository.findById(1L).orElseThrow(() -> new NotFoundException("Degree", "id", 1)));
        user.setPosition(positionRepository.findById(1L).orElseThrow(() -> new NotFoundException("Position", "id", 1)));
        user.setRank(rankRepository.findById(1L).orElseThrow(() -> new NotFoundException("Rank", "id", 1)));
        user.setOrganization(organizationRepository.findById(1L).orElseThrow(() -> new NotFoundException("Organization", "id", 1)));
        user.setPhone("phone2");

        try {
            authService.saveUser(user);
        } catch (Exception e) {}
    }

    @Test
    public void testUserExistsByEmail() {
        assertTrue(authService.userExistsByEmail("email2@email.email"));
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setFirstName("TEST");
        user.setSecondName("USER");
        user.setLastName("AuthServiceImplTest");
        Role userRole = authService.findRoleByName(RoleName.ROLE_USER).orElseThrow(() -> new AppException("User role not set."));
        user.setRoles(Collections.singleton(userRole));

        user.setEmail("email@email.email");
        user.setPassword(passwordEncoder.encode("qwe"));
        user.setDegree(degreeRepository.findById(1L).orElseThrow(() -> new NotFoundException("Degree", "id", 1)));
        user.setPosition(positionRepository.findById(1L).orElseThrow(() -> new NotFoundException("Position", "id", 1)));
        user.setRank(rankRepository.findById(1L).orElseThrow(() -> new NotFoundException("Rank", "id", 1)));
        user.setOrganization(organizationRepository.findById(1L).orElseThrow(() -> new NotFoundException("Organization", "id", 1)));
        user.setPhone("phone");

        authService.saveUser(user);
    }

    @Test
    public void testFindRoleByName() {
        authService.findRoleByName(RoleName.ROLE_USER).orElseThrow(() -> new NotFoundException("Role", "name", "ROLE_USER"));
        authService.findRoleByName(RoleName.ROLE_MODERATOR).orElseThrow(() -> new NotFoundException("Role", "name", "ROLE_MODERATOR"));
        authService.findRoleByName(RoleName.ROLE_ADMIN).orElseThrow(() -> new NotFoundException("Role", "name", "ROLE_ADMIN"));
    }

    @After
    public void releaseData() {
        User savedUser1 = userRepository.findByEmail("email@email.email").orElse(null);
        if(savedUser1 != null) {
            userRepository.delete(savedUser1);
        }
        User savedUser2 = userRepository.findByEmail("email@email.email").orElse(null);
        if(savedUser2 != null) {
            userRepository.delete(savedUser2);
        }
    }
}
