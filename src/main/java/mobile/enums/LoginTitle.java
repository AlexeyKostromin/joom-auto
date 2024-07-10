package mobile.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//@Getter
//@RequiredArgsConstructor
//public enum LoginTitle {
//    LOGIN_TITLE("Log in"),
//    SIGNUP_TITLE("Sign up");
//
//    private final String value;
//}

public enum LoginTitle {
    LOGIN_TITLE("Log in");

    private final String value;

    // Constructor
    private LoginTitle(String value) {
        this.value = value;
    }

    // Getter
    public String getValue() {
        return value;
    }
}

/* the same without lombok
public enum LoginTitle {
    LOGIN_TITLE("Log in");

    private final String value;

    // Constructor
    private LoginTitle(String value) {
        this.value = value;
    }

    // Getter
    public String getValue() {
        return value;
    }
}
 */