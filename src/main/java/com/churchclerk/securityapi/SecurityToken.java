/*
 */
package com.churchclerk.securityapi;

import lombok.Data;

import java.util.Date;

/**
 *
 */
@Data
public class SecurityToken {
    private String      id;
    private String      roles;
    private String      location;
    private String      secret;
    private String      jwt;
    private long        validFor    = 3600000;  // 1 hour in milliseconds
    private Date        expiresAt;
    private Throwable   error;


    public void setValidFor(long validFor) {
        this.validFor = validFor;
        expiresAt = null;
    }

    /**
     *
     * @return
     */
    public Date getExpiresAt() {
        if (expiresAt == null) {
            expiresAt = new Date(System.currentTimeMillis() + validFor);
        }

        return expiresAt;
    }

    /**
     *
     * @return
     */
    public boolean expired() {
        return (System.currentTimeMillis() > expiresAt.getTime());
    }

}


