package com.project.supermarketapp.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.supermarketapp.entities.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer>
{


}

