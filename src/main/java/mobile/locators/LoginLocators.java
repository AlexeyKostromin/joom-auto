package mobile.locators;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobile.screens.BaseScreen;
import org.openqa.selenium.support.PageFactory;

public class LoginLocators extends BaseScreen {
    public LoginLocators(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public static final String LOGIN_BUTTON_XPATH = "//android.widget.Button[@resource-id='com.joom:id/profile_header_name']";
    public static final String MORE_OPTIONS_BUTTON_XPATH = "//android.widget.TextView[@resource-id='com.joom:id/button_title' and @text='Show more login options']";
    public static final String LOGIN_WITH_EMAIL_BUTTON_XPATH = "//android.widget.TextView[@resource-id='com.joom:id/button_title' and @text='Email']";


}
