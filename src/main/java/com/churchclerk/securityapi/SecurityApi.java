/*
 *
 */
package com.churchclerk.securityapi;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;


/**
 *
 */
public class SecurityApi {

    private static Logger logger	= LoggerFactory.getLogger(SecurityApi.class);

    /**
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static boolean process(SecurityToken token) {

        if (token == null) {
            logger.warn("SecurityToken is required");
            return false;
        }

        try {
            if (token.getJwt() == null) {

                String jwt = JWT.create()
                        .withIssuer("auth0")
                        .withExpiresAt(token.getExpiresAt())
                        .withClaim("id", token.getId())
                        .withClaim("location", token.getLocation())
                        .sign(Algorithm.HMAC256(token.getSecret()));

                token.setJwt(jwt);
                return true;
            }

            DecodedJWT jwt = JWT.require(Algorithm.HMAC256(token.getSecret()))
                    .withIssuer("auth0")
                    .build().verify(token.getJwt());

            token.setExpiresAt(jwt.getExpiresAt());
            token.setId(jwt.getClaim("id").asString());
            token.setLocation(jwt.getClaim("location").asString());

            return token.expired() == false;
        }
        catch (Throwable t) {
            token.setError(t);
            return false;
        }
    }
}
