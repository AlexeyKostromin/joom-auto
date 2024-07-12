package mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mobile.dto.AddUserData;
import mobile.enums.AccountTitle;
import mobile.helper.Helper;
import mobile.locators.SignupPopupLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SignupPopupScreen extends BaseScreen {
    public SignupPopupScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = SignupPopupLocators.SIGN_UP_BUTTON_XPATH)
    private WebElement signupButton;

    public void signUpClick() {
        wainUntilElementIsVisible(signupButton);
        signupButton.click();
    }

    @AndroidFindBy(xpath = SignupPopupLocators.INPUT_FIRST_NAME_XPATH)
    private WebElement inputFirstName;

    public void setFirstName(String firstName) {
        inputFirstName.click();
        inputFirstName.sendKeys(firstName);
    }

    @AndroidFindBy(xpath = SignupPopupLocators.INPUT_LAST_NAME_XPATH)
    private WebElement inputLastName;

    public void setLastName(String lastName) {
        inputLastName.click();
        inputLastName.sendKeys(lastName);
    }

    @AndroidFindBy(xpath = SignupPopupLocators.INPUT_EMAIL_XPATH)
    private WebElement inputEmail;

    public void setEmail(String email) {
        inputEmail.click();
        inputEmail.sendKeys(email);
    }

    @AndroidFindBy(xpath = SignupPopupLocators.INPUT_PASSWORD_XPATH)
    private WebElement inputPassword;

    public void setPassword(String firstName) {
        inputPassword.click();
        inputPassword.sendKeys(firstName);
    }

    @AndroidFindBy(xpath = SignupPopupLocators.INPUT_CONFIRM_PASSWORD_XPATH)
    private WebElement inputConfirmPassword;

    public void setPasswordConfirmation(String confirmationPassword) {
        inputConfirmPassword.click();
        inputConfirmPassword.sendKeys(confirmationPassword);
    }

    @AndroidFindBy(xpath = SignupPopupLocators.CONFIRM_SIGN_UP_BUTTON_XPATH)
    private WebElement confirmSignupButton;

    public void confirmSignup() {
        confirmSignupButton.click();
        log.info("User signup: submitted");
    }

    @SneakyThrows
    public SignupPopupScreen registrationNewUser(AddUserData addUserData) {
        signUpClick();

        setFirstName(addUserData.getUserFirstName());
        setLastName(addUserData.getUserLastName());
        setEmail(addUserData.getUserEmail());
        setPassword(addUserData.getUserPassword());
        setPasswordConfirmation(addUserData.getUserPasswordConfirmation());

        confirmSignup();
        Thread.sleep(1000);
        log.info("Registration: User '{}' submitted", addUserData.getUserEmail());
        return this;
    }

    public void verifyUserRegistered(AccountTitle accountTitle){
        assertThat(Helper.isTextOnScreen(accountTitle.getValue()))
                .as("Check is text '%s' is visible", accountTitle.getValue())
                .isTrue();

        log.info("Verified '{}' text is visible", accountTitle.getValue());
    }

}
