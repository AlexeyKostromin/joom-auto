package tests.account;

import mobile.dto.AddUserData;
import mobile.enums.AccountTitle;
import mobile.enums.LoginTitle;
import mobile.generator.FakeDataGenerator;
import mobile.helper.TestDescription;
import mobile.screens.JoomHomeScreen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static mobile.utils.Constants.*;

public class GetProfileScreenTest extends BaseTest {

    @Test
    @DisplayName("Open login Screen")
    @TestDescription("Close the add, skip the quiz, open profile screen")
    public void getLoginScreenTest() {
        LoginTitle loginTitle = LoginTitle.LOGIN_TITLE;

        JoomHomeScreen joomHomeScreen = new JoomHomeScreen(driver);
        joomHomeScreen
                .closeAdd()
                .enableNotifications()
                .allowNotifications()
                .skipQuiz()
                .openProfileScreen()
                .verifyLoginScreenOpened(loginTitle);
    }

    @Test
    @DisplayName("User registration")
    @TestDescription("Close the add, skip the quiz, open profile and signup")
    public void registrationUserTest() {

        AccountTitle randomAccountTitle = FakeDataGenerator.getRandomOption(AccountTitle.class);

        AddUserData addUserData = AddUserData.builder()
                .userFirstName(USER_FIRST_NAME)
                .userLastName(USER_LAST_NAME)
                .userEmail(USER_EMAIL)
                .userPassword(USER_PASSWORD)
                .userPasswordConfirmation(USER_PASSWORD_CONFIRMATION)
                .build();

        JoomHomeScreen joomHomeScreen = new JoomHomeScreen(driver);
        joomHomeScreen
                .closeAdd()
                .enableNotifications()
                .allowNotifications()
                .skipQuiz()
                .openProfileScreen()
                .openRegistrationForm()
                .signupWithEmailSelect()
                .registrationNewUser(addUserData)
                .verifyUserRegistered(randomAccountTitle);
    }
}
