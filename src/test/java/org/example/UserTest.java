package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    //Маленький, прозрачный комментарий. Мечтайте!
    //

public static Stream<Arguments> provideParamsForTests() {
    return Stream.of(
            Arguments.of(UserTestConstants.DEFAULT_LOGIN, UserTestConstants.DEFAULT_EMAIL),
            Arguments.of(UserTestConstants.DEFAULT_LOGIN_AS_MAIL, UserTestConstants.DEFAULT_EMAIL),
            Arguments.of(UserTestConstants.DEFAULT_LOGIN, UserTestConstants.INCORRECT_EMAIL)
        );
    }
    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void objectParametersCheckAfterConstruction (String login, String email) {
    User testUser = new User(login, email);
        Assertions.assertEquals(testUser.getLogin(), login);
        Assertions.assertEquals(testUser.getEmail(), email);
        Assertions.assertNotEquals(testUser.getLogin(), testUser.getEmail());
        Assertions.assertTrue(testUser.getEmail().contains("@") && testUser.getEmail().contains(".") );
    }
    @Test
    public void nullParamConstructorTest() {
    User testUser = new User();
    Assertions.assertEquals(testUser.getLogin(), null);
    Assertions.assertEquals(testUser.getEmail(), null);
    }
}