package com.amigoscode.testing.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class PhoneNumberValidatorTest {

    private PhoneNumberValidator underTest;

    @BeforeEach
    void setUp() {
        underTest = new PhoneNumberValidator();
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
        String phoneNumber = "+250798000000789";

        //When
        boolean isValid = underTest.test(phoneNumber);

        //Then
        assertThat(isValid).isTrue();
    }

}
