package kz.spring.diplom_project.service;

import kz.spring.diplom_project.model.Address;
import kz.spring.diplom_project.repo.AddressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepo addressRepo;

    public List<Address> getAllAddress() {
        return addressRepo.findAll();
    }

    public Address getAddress(Long id) {
        return addressRepo.getOne(id);
    }

    public Address addAddress(Address address) {
        return addressRepo.save(address);
    }

    public Address updateAddress(Address address) {
        return addressRepo.save(address);
    }

    public void deleteAddress(Long id) {
        addressRepo.deleteById(id);
    }
}
