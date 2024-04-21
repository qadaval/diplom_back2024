package kz.spring.diplom_project.controller;

import kz.spring.diplom_project.mapper.AddressMapper;
import kz.spring.diplom_project.model.Address;
import kz.spring.diplom_project.model.dto.AddressDto;
import kz.spring.diplom_project.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressRestController {
    private final AddressService addressService;
    private final AddressMapper addressMapper;

    @GetMapping("/all")
    public ResponseEntity<List<AddressDto>> getAllAddress() {
        List<Address> addressList = addressService.getAllAddress();
        List<AddressDto> addressDtoList = addressMapper.toDtoList(addressList);
        return new ResponseEntity<>(addressDtoList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<AddressDto> getAddress(
            @PathVariable(name = "id") Long id
    ) {
        Address address = addressService.getAddress(id);
        AddressDto addressDto = addressMapper.toDto(address);
        return new ResponseEntity<>(addressDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<AddressDto> addAddress(
            @RequestBody AddressDto addressDto
    ) {
        return new ResponseEntity<>(addressMapper.toDto(addressService.addAddress(addressMapper.toModel(addressDto))), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<AddressDto> updateAddress(
            @RequestBody AddressDto addressDto
    ) {
        return new ResponseEntity<>(addressMapper.toDto(addressService.updateAddress(addressMapper.toModel(addressDto))), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteChild(
            @PathVariable(name = "id") Long id
    ) {
        addressService.deleteAddress(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
