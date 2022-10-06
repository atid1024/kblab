package kblab.domain;

import kblab.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class PointIncreased extends AbstractEvent {

    private Long id;
    private Integer holder;
    private Integer amount;
}
