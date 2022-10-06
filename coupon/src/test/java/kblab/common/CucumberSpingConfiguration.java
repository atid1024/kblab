package kblab.common;


import kblab.CouponApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { CouponApplication.class })
public class CucumberSpingConfiguration {
    
}
