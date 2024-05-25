package kz.spring.diplom_project.service;

import kz.spring.diplom_project.model.Parent;
import kz.spring.diplom_project.repo.ParentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParentService implements UserDetailsService {
    private final ParentRepo parentRepo;
    private final PasswordEncoder passwordEncoder;

    public ParentService(@Lazy ParentRepo parentRepo, PasswordEncoder passwordEncoder) {
        this.parentRepo = parentRepo;
        this.passwordEncoder = passwordEncoder;
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
        return parentRepo.save(parent);
    }

    public Parent findByIin(String iin) {
        return parentRepo.findByIin(iin);
    }
}
