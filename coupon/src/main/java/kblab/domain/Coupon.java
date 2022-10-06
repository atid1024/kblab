package kblab.domain;

import kblab.domain.CouponPurchased;
import kblab.CouponApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Coupon_table")
@Data

public class Coupon  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Integer customerId;
    
    
    
    
    
    private Integer price;
    
    
    
    
    
    private String name;
    
    
    
    
    
    private String customerName;

    @PostPersist
    public void onPostPersist(){


        CouponPurchased couponPurchased = new CouponPurchased(this);
        couponPurchased.publishAfterCommit();

    }

    public static CouponRepository repository(){
        CouponRepository couponRepository = CouponApplication.applicationContext.getBean(CouponRepository.class);
        return couponRepository;
    }



    public void cancelCoupon(){
        CouponCancelled couponCancelled = new CouponCancelled(this);
        couponCancelled.publishAfterCommit();

    }



}
