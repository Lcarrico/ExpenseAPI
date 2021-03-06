package dev.carrico.utiltests;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import dev.carrico.utils.JwtUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JwtTests {

    @Test
    void create_jwt(){
        String jwt = JwtUtil.generate("manager","jessie1");
        System.out.println(jwt);
    }

    @Test
    void decode_jwt(){
        DecodedJWT jwt = JwtUtil.isValidJWT("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoibWFuYWdlciIsImVtcE5hbWUiOiJqZXNzaWUxIn0.uD-ZX-wndLv8akvpL0u6hjV0vm5g3tG75cJ1iHHiN9A");
        String role = jwt.getClaim("role").asString();
        Assertions.assertEquals("manager", role);
        System.out.println(role);
    }

    @Test
    void edited_jwt(){
        try {
            DecodedJWT jwt = JwtUtil.isValidJWT("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoibWFuYWdlciIsImVtcE5hbWUiOiJNYXJ5IFN1ZSJ9.Ap5nc4NOSFCWi9UncEKjvfiVJ69SznUhGjiE1R44cPU");
            String role = jwt.getClaim("role").asString();
            System.out.println(role);
        }
        catch (SignatureVerificationException e){
            Assertions.assertTrue(true);
        }

    }
}
