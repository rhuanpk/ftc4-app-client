package org.example.client.bdd;


import io.cucumber.spring.CucumberContextConfiguration;
import org.example.client.AppClientApplication;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = AppClientApplication.class)
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
public class CucumberTest {
}
