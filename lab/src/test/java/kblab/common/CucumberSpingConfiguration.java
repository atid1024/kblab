package kblab.common;


import kblab.LabApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { LabApplication.class })
public class CucumberSpingConfiguration {
    
}
