package mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.extern.slf4j.Slf4j;
import mobile.enums.LoginTitle;
import mobile.helper.Helper;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ProfileScreen extends BaseScreen {
    public ProfileScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);//TODO:do we need this?
    }

    public void verifyLoginScreenOpened(LoginTitle loginTitle) {
        assertThat(Helper.isTextOnScreen(loginTitle.getValue()))
                .as("Check if the text '%s' is visible on screen", loginTitle.getValue())
                .isTrue();

        log.info("Verified '{}' text is visible", loginTitle.getValue());
    }
}
