package tests.account;

import mobile.enums.LoginTitle;
import mobile.helper.TestDescription;
import mobile.screens.JoomHomeScreen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class GetProfileScreenTest extends BaseTest {

    @Test
    @DisplayName("Open login Screen")
    @TestDescription("Close the add, skip the quiz, open profile screen")
    public void getLoginScreenTest(){
        LoginTitle loginTitle = LoginTitle.LOGIN_TITLE;

        JoomHomeScreen joomHomeScreen = new JoomHomeScreen(driver);
        joomHomeScreen
                .closeAdd()
                .skipQuiz()
                .openProfileScreen()
                .verifyLoginScreenOpened(loginTitle);
    }

    @Test
    @DisplayName("User registration")
    @TestDescription("Close the add, skip the quiz, open profile and signup")
    public void registrationUserTest(){

        JoomHomeScreen joomHomeScreen = new JoomHomeScreen(driver);
        joomHomeScreen
                .closeAdd()
                .skipQuiz()
                .openProfileScreen();

    }
}
