package kblab.domain;

import kblab.domain.*;
import kblab.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PointIncreased extends AbstractEvent {

    private Long id;
    private Integer holder;
    private Integer amount;

    public PointIncreased(Point aggregate){
        super(aggregate);
    }
    public PointIncreased(){
        super();
    }
}
