package kz.spring.diplom_project.service;

import kz.spring.diplom_project.model.Parent;
import kz.spring.diplom_project.model.Role;
import kz.spring.diplom_project.repo.ParentRepo;
import kz.spring.diplom_project.repo.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ParentService implements UserDetailsService {
    private final ParentRepo parentRepo;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepo roleRepo;

    public ParentService(@Lazy ParentRepo parentRepo, PasswordEncoder passwordEncoder, RoleRepo roleRepo) {
        this.parentRepo = parentRepo;
        this.passwordEncoder = passwordEncoder;
        this.roleRepo = roleRepo;
    }

    public List<Parent> getAllParent() {
        return parentRepo.findAll();
    }

    public Parent getParent(Long id) {
        return parentRepo.getOne(id);
    }

    public Parent addParent(Parent parent) {
        return parentRepo.save(parent);
    }

    public Parent updateParent(Parent parent) {
        return parentRepo.save(parent);
    }

    public void deleteParent(Long id) {
        parentRepo.deleteById(id);
    }

    @PostConstruct
    public void initRoles() {
        if (roleRepo.findByName("ROLE_USER").isEmpty()) {
            Role userRole = new Role();
            userRole.setName("ROLE_USER");
            roleRepo.save(userRole);
        }
        if (roleRepo.findByName("ROLE_ADMIN").isEmpty()) {
            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
            roleRepo.save(adminRole);
        }
    }


    @Override
    public UserDetails loadUserByUsername(String iin) throws UsernameNotFoundException {
        Parent parent = parentRepo.findByIin(iin);
        if (parent == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(parent.getIin(), parent.getPassword(), new ArrayList<>());
    }

    public Parent saveUser(Parent parent) {
        if (parent.getPassword() == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        parent.setPassword(passwordEncoder.encode(parent.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepo.findByName("ROLE_USER").get());
        parent.setRoles(roles);
        return parentRepo.save(parent);
    }

    public Parent findByIin(String iin) {
        return parentRepo.findByIin(iin);
    }
}
