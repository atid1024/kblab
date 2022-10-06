package kblab.domain;

import kblab.domain.PointIncreased;
import kblab.domain.PointDecreased;
import kblab.PointApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Point_table")
@Data

public class Point  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Integer holder;
    
    
    
    
    
    private Integer amount;

    @PostPersist
    public void onPostPersist(){


        PointIncreased pointIncreased = new PointIncreased(this);
        pointIncreased.publishAfterCommit();

    }
    @PostUpdate
    public void onPostUpdate(){


        PointDecreased pointDecreased = new PointDecreased(this);
        pointDecreased.publishAfterCommit();

    }

    public static PointRepository repository(){
        PointRepository pointRepository = PointApplication.applicationContext.getBean(PointRepository.class);
        return pointRepository;
    }




    public static void pointGeneration(CouponPurchased couponPurchased){

        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        */

        /** Example 2:  finding and process
        
        repository().findById(couponPurchased.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);


         });
        */

        
    }
    public static void pointDeduction(CouponCancelled couponCancelled){

        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        */

        /** Example 2:  finding and process
        
        repository().findById(couponCancelled.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);


         });
        */

        
    }
    public static void changeToken(ExchangeRequested exchangeRequested){

        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        */

        /** Example 2:  finding and process
        
        repository().findById(exchangeRequested.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);


         });
        */

        
    }


}
