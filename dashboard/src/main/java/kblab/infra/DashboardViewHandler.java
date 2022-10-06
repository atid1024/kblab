package kblab.infra;

import kblab.domain.*;
import kblab.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DashboardViewHandler {


    @Autowired
    private DashboardRepository dashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCouponPurchased_then_CREATE_1 (@Payload CouponPurchased couponPurchased) {
        try {

            if (!couponPurchased.validate()) return;

            // view 객체 생성
            Dashboard dashboard = new Dashboard();
            // view 객체에 이벤트의 Value 를 set 함
            dashboard.setCustomerId(couponPurchased.getCustomerId());
            dashboard.setCouponPrice(couponPurchased.getPrice());
            dashboard.setPointAmount(0);
            dashboard.setTokenAmount(0);
            dashboard.setCustomerName(couponPurchased.getCustomerName());
            dashboard.setStatus("processing");
            // view 레파지 토리에 save
            dashboardRepository.save(dashboard);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenCouponCancelled_then_UPDATE_1(@Payload CouponCancelled couponCancelled) {
        try {
            if (!couponCancelled.validate()) return;
                // view 객체 조회

                List<Dashboard> dashboardList = dashboardRepository.findByCouponId(couponCancelled.getId());
                for(Dashboard dashboard : dashboardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashboard.setCouponId(dashboard.getCouponId() - couponCancelled.getPrice());
                    dashboard.setStatus("processing");
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPointIncreased_then_UPDATE_2(@Payload PointIncreased pointIncreased) {
        try {
            if (!pointIncreased.validate()) return;
                // view 객체 조회

                List<Dashboard> dashboardList = dashboardRepository.findByCustomerId(pointIncreased.getHolder());
                for(Dashboard dashboard : dashboardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashboard.setPointAmount(dashboard.getPointAmount() + pointIncreased.getAmount());
                    dashboard.setStatus("complete");
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPointDecreased_then_UPDATE_3(@Payload PointDecreased pointDecreased) {
        try {
            if (!pointDecreased.validate()) return;
                // view 객체 조회

                List<Dashboard> dashboardList = dashboardRepository.findByCustomerId(pointDecreased.getHolder());
                for(Dashboard dashboard : dashboardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashboard.setPointAmount(dashboard.getPointAmount() - pointDecreased.getAmount());
                    dashboard.setStatus("completed");
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenTokenPlaced_then_UPDATE_4(@Payload TokenPlaced tokenPlaced) {
        try {
            if (!tokenPlaced.validate()) return;
                // view 객체 조회

                List<Dashboard> dashboardList = dashboardRepository.findByCustomerId(tokenPlaced.getUserId());
                for(Dashboard dashboard : dashboardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashboard.setTokenAmount(dashboard.getTokenAmount() + tokenPlaced.getToken());
                    dashboard.setStatus("processing");
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

