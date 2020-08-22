package com.example.app.config.stepdefs;

import com.example.app.config.CucumberConfig;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = CucumberConfig.class)
public class CucumberSpringConfiguration {
}
