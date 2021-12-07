package com.customer.backend.project.repository;

import com.customer.backend.project.model.data.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    public Address findAddressById(long id);

}
