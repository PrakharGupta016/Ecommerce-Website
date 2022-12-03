package com.project.supermarketapp.respository;

import com.project.supermarketapp.entities.Wallet;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepo extends JpaRepository<Wallet,Integer> {

  List<Wallet> findAll();
}
