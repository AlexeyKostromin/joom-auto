package tests;

import io.appium.java_client.AppiumDriver;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mobile.Initializer;
import mobile.helper.Helper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

@Slf4j
public class BaseTest {

    protected static AppiumDriver driver;

    @BeforeEach
    @SneakyThrows //allows to call methods that throw checked exceptions without explicitly handling them using try-catch blocks or declaring them with a throws clause.
    public void SetUp() {
        log.info("Driver: initializing before test\n");
        driver = Initializer.getDriver();
        Helper.setDriver(driver);
        Thread.sleep(2000);

        log.info("!!! Starting the TEST\n");
    }

    @AfterEach
    public void tearDown(){
        log.info("Driver: closing after test\n");
        Initializer.quitDriver();
    }

}
