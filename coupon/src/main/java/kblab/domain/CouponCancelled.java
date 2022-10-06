package kblab.domain;

import kblab.domain.*;
import kblab.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CouponCancelled extends AbstractEvent {

    private Long id;
    private Integer customerId;
    private Integer price;
    private String customerName;

    public CouponCancelled(Coupon aggregate){
        super(aggregate);
    }
    public CouponCancelled(){
        super();
    }
}
