package kblab.domain;

import kblab.domain.*;
import kblab.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CouponPurchased extends AbstractEvent {

    private Long id;
    private Integer customerId;
    private Integer price;
    private String customerName;

    public CouponPurchased(Coupon aggregate){
        super(aggregate);
    }
    public CouponPurchased(){
        super();
    }
}
