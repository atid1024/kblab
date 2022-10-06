package kblab.domain;

import kblab.domain.*;
import kblab.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class TokenPlaced extends AbstractEvent {

    private Long id;
    private Integer userId;
    private Integer token;

    public TokenPlaced(Lab aggregate){
        super(aggregate);
    }
    public TokenPlaced(){
        super();
    }
}
