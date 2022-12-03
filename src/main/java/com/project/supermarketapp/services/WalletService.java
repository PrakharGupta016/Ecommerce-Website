package com.project.supermarketapp.services;
import com.project.supermarketapp.entities.Wallet;
import com.project.supermarketapp.exceptions.WalletException;
import com.project.supermarketapp.respository.WalletRepo;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
  public class WalletService {

  @Autowired
  public WalletRepo walletRepo;

  public List<Wallet> getAll(){
    return walletRepo.findAll();
  }
  public Wallet getById(Integer id){
    Optional<Wallet> wallet=walletRepo.findById(id);
    if (wallet.isPresent()){
      return wallet.get();
    }
    //TODO
    throw new WalletException("wallet with"+id+"does not exist");
  }
  public Wallet createOrUpdate(Wallet wallet){
      if (wallet.getId()==null){
    walletRepo.save(wallet);
      }
      else{
        walletRepo.save(wallet);
      }
      return wallet;
  }
  public boolean delete(Integer id){
    Optional<Wallet> wallet=walletRepo.findById(id);
    if (wallet.isPresent()){
      walletRepo.delete(wallet.get());
      return true;
    }
    //TODO
    throw new WalletException("wallet with"+id+"does not exist");
  }

}
