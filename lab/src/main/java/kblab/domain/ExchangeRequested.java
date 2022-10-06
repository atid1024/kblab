package kblab.domain;

import kblab.domain.*;
import kblab.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ExchangeRequested extends AbstractEvent {

    private Long id;
    private Integer userId;
    private Integer token;

    public ExchangeRequested(Lab aggregate){
        super(aggregate);
    }
    public ExchangeRequested(){
        super();
    }
}
