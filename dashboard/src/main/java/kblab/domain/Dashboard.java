package kblab.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name="Dashboard_table")
@Data
public class Dashboard {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Integer couponPrice;
        private Integer pointAmount;
        private Integer tokenAmount;
        private Integer customerId;
        private String customerName;
        private Long couponId;
        private String status;


}