package kblab.domain;

import kblab.domain.TokenPlaced;
import kblab.domain.ExchangeRequested;
import kblab.LabApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Lab_table")
@Data

public class Lab  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Integer userId;
    
    
    
    
    
    private Integer token;

    @PostPersist
    public void onPostPersist(){


        TokenPlaced tokenPlaced = new TokenPlaced(this);
        tokenPlaced.publishAfterCommit();

    }
    @PostUpdate
    public void onPostUpdate(){


        ExchangeRequested exchangeRequested = new ExchangeRequested(this);
        exchangeRequested.publishAfterCommit();

    }

    public static LabRepository repository(){
        LabRepository labRepository = LabApplication.applicationContext.getBean(LabRepository.class);
        return labRepository;
    }






}
