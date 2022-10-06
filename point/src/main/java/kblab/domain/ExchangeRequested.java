package kblab.domain;

import kblab.domain.*;
import kblab.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class ExchangeRequested extends AbstractEvent {

    private Long id;
    private Integer userId;
    private Integer token;
}


