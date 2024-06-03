package kz.spring.diplom_project.service;

import kz.spring.diplom_project.model.Request;
import kz.spring.diplom_project.repo.RequestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepo requestRepo;

    public List<Request> getAllRequest() {
        return requestRepo.findAll();
    }

    public Request getRequest(Long id) {
        return requestRepo.getOne(id);
    }

    public Request addRequest(Request request) {
        return requestRepo.save(request);
    }

    public Request updateRequest(Request request) {
        return requestRepo.save(request);
    }

    public void deleteRequest(Long id) {
        requestRepo.deleteById(id);
    }
}
