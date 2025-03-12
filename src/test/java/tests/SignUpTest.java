package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SignUpTest extends BaseTest {
    @Test
    public void checkNegativeSignUpWithAlreadyExistUser() {
        mainPage.open()
                .openSignUpModal()
                .signUp("test", "12345");

        assertEquals(mainPage.getConfirmMessage(), "This user already exist.", "Алерт не отобразился");
    }
}
