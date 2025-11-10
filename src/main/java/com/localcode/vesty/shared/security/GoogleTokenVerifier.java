package com.localcode.vesty.shared.security;

import com.google.api.client.json.webtoken.JsonWebToken;
import com.google.auth.oauth2.TokenVerifier;
import com.localcode.vesty.shared.exception.BusinessException;

public class GoogleTokenVerifier {
    private static final String CLIENT_ID = "309451493449-57t261jfh58m72soqgkfn4r7888ttu5n.apps.googleusercontent.com";

    private GoogleTokenVerifier() {
    }

    public static JsonWebToken.Payload verify(String idTokenString) {
        try {
            TokenVerifier verifier = TokenVerifier.newBuilder()
                    .setAudience(CLIENT_ID)
                    .build();

            JsonWebToken jsonWebToken = verifier.verify(idTokenString);
            return jsonWebToken.getPayload();
        } catch (Exception e) {
            throw new BusinessException("Invalid Google ID token", e);
        }
    }
}
