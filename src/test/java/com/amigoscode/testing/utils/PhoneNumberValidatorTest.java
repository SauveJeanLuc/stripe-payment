package com.amigoscode.testing.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


public class PhoneNumberValidatorTest {

    private PhoneNumberValidator underTest;

    @BeforeEach
    void setUp() {
        underTest = new PhoneNumberValidator();
    }

    @ParameterizedTest
    //Pass Actual input and Expected Value
    @CsvSource({
            "+250798000000 , true",
            "+25079800000078913, false",
            "250798000000789, false"
    })
    void itShouldValidatePhoneNumberSuccess(String phoneNumber, boolean expected) {
        boolean isValid = underTest.test(phoneNumber);
        assertThat(isValid).isEqualTo(expected);
    }

    @Test
    void itShouldValidatePhoneNumber(){
        //Given
        String phoneNumber = "+250798000000";

        //When
        boolean isValid = underTest.test(phoneNumber);

        //Then
        assertThat(isValid).isTrue();
    }

    @Test
    @DisplayName("Should fail when length is Bigger Than 13")
    void itShouldValidatePhoneNumberWhenIncorrectAndHasLengthBiggerThan13(){
        //Given
        String phoneNumber = "+25079800000078913";

        //When
        boolean isValid = underTest.test(phoneNumber);

        //Then
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Should fail when does not start with plus sign")
    void itShouldValidatePhoneNumberWhenDoesNotStartWithPlusSign(){
        //Given
        String phoneNumber = "250798000000789";

        //When
        boolean isValid = underTest.test(phoneNumber);

        //Then
        assertThat(isValid).isFalse();
    }

}
