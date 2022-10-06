package kblab.domain;

import kblab.domain.*;
import kblab.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class CouponPurchased extends AbstractEvent {

    private Long id;
    private Integer customerId;
    private Integer price;
    private String customerName;
}


