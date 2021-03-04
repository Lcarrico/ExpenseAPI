package dev.carrico.utiltests;

import carrico.dev.utils.ConnectionUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class ConnectionUtilTest {
    @Test
    void generate_connection(){
        Connection conn = ConnectionUtil.createConnection();
        System.out.println(conn);
        Assertions.assertNotNull(conn);
    }

    @Test
    void get_env_variable(){
        String env = System.getenv("ExpenseURL");
        System.out.println(env);
        Assertions.assertNotNull(env);
    }
}
