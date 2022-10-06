package kblab.domain;

import kblab.domain.*;
import kblab.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PointDecreased extends AbstractEvent {

    private Long id;
    private Integer holder;
    private Integer amount;

    public PointDecreased(Point aggregate){
        super(aggregate);
    }
    public PointDecreased(){
        super();
    }
}
