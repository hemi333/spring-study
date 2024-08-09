package com.sh2orc.pay.settlement.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SettlementStatus implements BaseJsonEnum {
    READY("정산대기"),
    ONGOING("정산중"),
    COMPLETE("정산완료");

    private String type;

    @Override
    public String getKey() {
        return this.name();
    }

    @Override
    public String getValue() {
        return this.type;
    }
}