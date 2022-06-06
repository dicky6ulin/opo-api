package com.enigma.opo.controller;

import com.enigma.opo.constant.ApiURLConstant;
import com.enigma.opo.constant.ResponseMessage;
import com.enigma.opo.entity.Wallet;
import com.enigma.opo.service.WalletService;
import com.enigma.opo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(ApiURLConstant.WALLET)
public class WalletController {

    @Autowired
    WalletService walletService;

//    @PostMapping
//    public Wallet addWallet(@RequestBody Wallet wallet) {
//        return walletService.createWallet(wallet);
//    }
    @PostMapping
    public ResponseEntity<Response<Wallet>> addWallet(@RequestBody Wallet wallet) {
        Response<Wallet> response = new Response<>();
        String message = String.format(ResponseMessage.DATA_INSERT, "wallet");
        response.setMessage(message);
        response.setData(walletService.createWallet(wallet));
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @PostMapping("/debit")
    public void debitWallet(@RequestParam(name = "phoneNumber") String phoneNumber,
                            @RequestParam(name = "amount")BigDecimal amount) {
        walletService.debit(phoneNumber, amount);
    }

    @PostMapping("/topUp")
    public void topUpWallet(@RequestParam(name = "phoneNumber") String phoneNumber,
                            @RequestParam(name = "amount") BigDecimal amount) {
        walletService.topUp(phoneNumber, amount);
    }

    @GetMapping
    public List<Wallet> findAllWallet() {
        return walletService.findAllWallet();
    }
}
