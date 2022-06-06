package com.enigma.opo.service;

import com.enigma.opo.entity.Wallet;

import java.math.BigDecimal;
import java.util.List;

public interface WalletService {

    public Wallet createWallet(Wallet wallet);
    public void debit(String phoneNumber, BigDecimal amount);
    public Wallet topUp(String phoneNumber, BigDecimal amount);
    public List<Wallet> findAllWallet();
}
