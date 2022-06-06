package com.enigma.opo.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "mst_wallet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Wallet {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "wallet_id")
    private String id;
    private String phoneNumber;
    private BigDecimal balance;

    public Wallet(String phoneNumber, BigDecimal balance) {
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }
}
