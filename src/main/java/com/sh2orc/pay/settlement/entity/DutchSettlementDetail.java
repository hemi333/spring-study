package com.sh2orc.pay.settlement.entity;

import com.sh2orc.pay.settlement.enums.SettlementStatus;
import jakarta.persistence.*;

@Entity
@Table(name="dutch_settlement_detail")
public class DutchSettlementDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dutch_detail_id")
    private Long id;

    //더치정산 엔티티
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dutch_id", foreignKey = @ForeignKey(name = "fk_dutch_id"))
    private DutchSettlement dutchSettlement;

    //유저 엔티티
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT) )
    private User User;

    //세부 정산 상태
    @Enumerated(EnumType.STRING)
    @Column(name = "settlement_status")
    private SettlementStatus settlementStatus;

    //유저에게 할당된 정산 금액
    @Column(name = "settlement_amount")
    private Long settlementAmount;

    //유저에게 남은 정산 금액
    @Column(name = "unpaid_amount")
    private Long unpaidAmount;

}