package it.unipv.ingsfw.treninordovest;

import it.unipv.ingsfw.treninordovest.model.utils.PasswordUtils;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    void name() {
        System.out.println(PasswordUtils.hashPassword("PassTreno2025"));

    }
}
