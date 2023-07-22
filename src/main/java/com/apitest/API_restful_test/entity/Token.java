package com.apitest.API_restful_test.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "token")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateCreated;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateExpire;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date modified;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date lastLogin;

    @Column(nullable = false)
    private UUID token;

    @Column(nullable = false)
    private boolean isActive;

    @OneToOne
    @JoinColumn(name = "user")
    private User user;

    public Token() {}

    public Token(Date dateCreated, Date dateExpire, Date modified, Date lastLogin, UUID token, boolean isActive) {
        this.dateCreated = dateCreated;
        this.dateExpire = dateExpire;
        this.modified = modified;
        this.lastLogin = lastLogin;
        this.token = token;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateExpire() {
        return dateExpire;
    }

    public void setDateExpire(Date dateExpire) {
        this.dateExpire = dateExpire;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
