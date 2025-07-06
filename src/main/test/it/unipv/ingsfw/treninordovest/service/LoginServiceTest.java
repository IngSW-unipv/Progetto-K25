package it.unipv.ingsfw.treninordovest.service;

import it.unipv.ingsfw.treninordovest.model.utils.PasswordUtils;
import org.junit.jupiter.api.Test;

public class LoginServiceTest {

    @Test
    void testLogin() {

        char [] password ={'1','2','3','4'};
        String passString = new String(password);

        String hashing = PasswordUtils.hashPassword(passString);

        System.out.println(PasswordUtils.verifyPassword(passString, hashing));


    }
}
