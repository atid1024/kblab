package kblab.domain;

import kblab.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class CouponCancelled extends AbstractEvent {

    private Long id;
    private Integer customerId;
    private Integer price;
    private String customerName;
}
