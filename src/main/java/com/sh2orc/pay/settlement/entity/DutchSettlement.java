package com.sh2orc.pay.settlement.entity;

import com.sh2orc.pay.settlement.enums.SettlementStatus;
import jakarta.persistence.*;

@Entity
@Table(name="dutch_settlement",
        indexes = {
                @Index(name = "ix_owner_user_id", columnList = "owner_user_id")
        }
)
public class DutchSettlement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dutch_id")
    private Long id;

    // 정산 요청한 사람
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_user_id", referencedColumnName = "user_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private User ownerUser;

    // 정산금액
    @Column(name = "settlement_amount")
    private Long settlementAmount;

    // 더치페이 참여자수
    @Column(name = "dutch_people_count")
    private Integer dutchPeopleCount;

    // 나누기 정산금액 (1인당 정산금액)
    @Column(name = "divide_amount")
    private Long divideAmount;

    // 나머지 정산금액 (1/N 이후 나머지 꼬끼오가 지금하는 금액)
    @Column(name = "spare_amount")
    private Long spareAmount;

    // 정산 상태
    @Enumerated(value = EnumType.STRING)
    @Column(name = "settlement_status")
    private SettlementStatus settlementStatus;

}
