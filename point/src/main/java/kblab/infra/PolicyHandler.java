package kblab.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import kblab.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import kblab.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired PointRepository pointRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CouponPurchased'")
    public void wheneverCouponPurchased_PointGeneration(@Payload CouponPurchased couponPurchased){

        CouponPurchased event = couponPurchased;
        System.out.println("\n\n##### listener PointGeneration : " + couponPurchased + "\n\n");


        

        // Sample Logic //
        Point.pointGeneration(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CouponCancelled'")
    public void wheneverCouponCancelled_PointDeduction(@Payload CouponCancelled couponCancelled){

        CouponCancelled event = couponCancelled;
        System.out.println("\n\n##### listener PointDeduction : " + couponCancelled + "\n\n");


        

        // Sample Logic //
        Point.pointDeduction(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='ExchangeRequested'")
    public void wheneverExchangeRequested_ChangeToken(@Payload ExchangeRequested exchangeRequested){

        ExchangeRequested event = exchangeRequested;
        System.out.println("\n\n##### listener ChangeToken : " + exchangeRequested + "\n\n");


        

        // Sample Logic //
        Point.changeToken(event);
        

        

    }

}


