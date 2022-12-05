package com.project.supermarketapp.controllers;


import com.project.supermarketapp.entities.Wallet;
import com.project.supermarketapp.exceptions.WalletException;
import com.project.supermarketapp.services.ValidateErrorService;
import com.project.supermarketapp.services.WalletService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.config.annotation.web.configurers.UrlAuthorizationConfigurer.StandardInterceptUrlRegistry;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/wallet")
public class WalletController {

  @Autowired
  private WalletService walletService;
  @Autowired
  private ValidateErrorService validateErrorService;


  @GetMapping
  public ResponseEntity<?> getAll(){
    return new ResponseEntity<>(walletService.getAll(),HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable Integer id) {
    return new ResponseEntity<>(walletService.getById(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody Wallet wallet , BindingResult result) {
    ResponseEntity errors = validateErrorService.validate(result);
    if (errors != null)
      return errors;
    Wallet walletSaved = walletService.createOrUpdate(wallet);
    return new ResponseEntity<Wallet>(walletSaved, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody Wallet wallet , BindingResult result){
    ResponseEntity errors=validateErrorService.validate(result);
    if (errors!=null) return errors;
    wallet.setId(id);
    Wallet walletSaved= walletService.createOrUpdate(wallet);
    return new ResponseEntity<Wallet>(walletSaved,HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id){
    walletService.delete(id);
    return new ResponseEntity(HttpStatus.OK);
  }

}
