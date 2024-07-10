package mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import mobile.locators.JoomHomeLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Slf4j
@Setter//TODO:remove?
public class JoomHomeScreen extends BaseScreen {
    public JoomHomeScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public JoomHomeScreen closeAdd() {
        int x = 990;
        int y = 260;

        tapByCoordinates(x, y);
        log.info("Advertisement: closed");

        return new JoomHomeScreen(driver);
    }

    @AndroidFindBy(xpath = JoomHomeLocators.SKIP_QUIZ_WHEEL_XPATH)
    private WebElement skipQuizButton;

    public JoomHomeScreen skipQuiz(){
        wainUntilElementIsVisible(skipQuizButton);
        skipQuizButton.click();
        log.info("Spinning wheel quiz: skipped");

        return new JoomHomeScreen(driver);
    }

    @AndroidFindBy(xpath = JoomHomeLocators.PROFILE_BUTTON_XPATH)
    private WebElement openProfileButton;

    public ProfileScreen openProfileScreen(){
        wainUntilElementIsVisible(openProfileButton);
        openProfileButton.click();
        log.info("Profile: opened");

        return new ProfileScreen(driver);
    }

}
