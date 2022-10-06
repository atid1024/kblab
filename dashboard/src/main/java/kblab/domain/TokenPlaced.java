package kblab.domain;

import kblab.infra.AbstractEvent;
import lombok.Data;
import java.util.*;

@Data
public class TokenPlaced extends AbstractEvent {

    private Long id;
    private Integer userId;
    private Integer token;
}
