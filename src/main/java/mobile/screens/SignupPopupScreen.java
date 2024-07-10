package mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class SignupPopupScreen extends BaseScreen{
    public SignupPopupScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public static final String LOGIN_BUTTON_XPATH = "";
    public static final String LOGIN_BUTTON1_XPATH = "";
    public static final String LOGIN_BUTTON2_XPATH = "";


}
