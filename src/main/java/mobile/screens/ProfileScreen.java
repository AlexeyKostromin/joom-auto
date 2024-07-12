package mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import mobile.enums.LoginTitle;
import mobile.helper.Helper;
import mobile.locators.LoginLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ProfileScreen extends BaseScreen {
    public ProfileScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void verifyLoginScreenOpened(LoginTitle loginTitle) {
        assertThat(Helper.isTextOnScreen(loginTitle.getValue()))
                .as("Check if the text '%s' is visible on screen", loginTitle.getValue())
                .isTrue();

        log.info("Verified '{}' text is visible", loginTitle.getValue());
    }

    @AndroidFindBy(xpath = LoginLocators.LOGIN_BUTTON_XPATH)
    private WebElement registrationButton;

    public ProfileScreen openRegistrationForm() {
        wainUntilElementIsVisible(registrationButton);
        registrationButton.click();
        log.info("Login profile: opened");
        return this;
    }

    @AndroidFindBy(xpath = LoginLocators.MORE_OPTIONS_BUTTON_XPATH)
    private WebElement showMoreOptionsButton;

    public ProfileScreen showMoreOptions() {
        wainUntilElementIsVisible(showMoreOptionsButton);
        showMoreOptionsButton.click();
        return this;
    }

    @AndroidFindBy(xpath = LoginLocators.LOGIN_WITH_EMAIL_BUTTON_XPATH)
    private WebElement signupWithEmailButton;

    public SignupPopupScreen signupWithEmailSelect() {
        showMoreOptions();

        wainUntilElementIsVisible(signupWithEmailButton);
        signupWithEmailButton.click();
        log.info("Signup with email: selected");
        return new SignupPopupScreen(driver);
    }

}
