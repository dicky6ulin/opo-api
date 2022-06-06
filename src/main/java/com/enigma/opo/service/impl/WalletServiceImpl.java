package com.enigma.opo.service.impl;

import com.enigma.opo.entity.Wallet;
import com.enigma.opo.repository.WalletRepository;
import com.enigma.opo.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service // supaya jadi beans
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public Wallet createWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public void debit(String phoneNumber, BigDecimal amount) {
        Wallet wallet = walletRepository.findWalletByPhoneNumber(phoneNumber);
        wallet.setBalance(wallet.getBalance().subtract(amount));
        walletRepository.save(wallet);
    }

    @Override
    public Wallet topUp(String phoneNumber, BigDecimal amount) {
        Wallet wallet = walletRepository.findWalletByPhoneNumber(phoneNumber);
        wallet.setBalance(wallet.getBalance().add(amount));
        return walletRepository.save(wallet);
    }

    @Override
    public List<Wallet> findAllWallet() {
        return walletRepository.findAll();
    }
}
