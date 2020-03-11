/*
 */
package com.churchclerk.securityapi;

import java.util.Date;

/**
 *
 */
public class SecurityToken {
    private String      id;
    private String      roles;
    private String      location;
    private String      secret;
    private String      jwt;
    private long        validFor    = 3600000;  // 1 hour in milliseconds
    private Date        expiresAt;
    private Throwable   error;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

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

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Throwable getError() {
        return error;
    }

    public void setError(Throwable error) {
        this.error = error;
    }
}


