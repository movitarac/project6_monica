package com.racic.lib.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity(name="Session")
public class Session {

    @Id
    @GeneratedValue
    @Column
    private Integer idSession;
    @OneToOne
    private Member member;

    @Column
    private Timestamp sessionTimeOut; //now + 30 minutes

    @Column
    private String statusSession;

    //TODO list all attributes for Session and add getters setters

    public Session() {
    }

    public Session(Member member, Timestamp sessionTimeOut, String statusSession) {
        this.member = member;
        this.sessionTimeOut = sessionTimeOut;
        this.statusSession=statusSession;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Timestamp getSessionTimeOut() {
        return sessionTimeOut;
    }

    public void setSessionTimeOut(Timestamp sessionTimeOut) {
        this.sessionTimeOut = sessionTimeOut;
    }

    public Integer getIdSession() {
        return idSession;
    }

    public void setIdSession(Integer idSession) {
        this.idSession = idSession;
    }

    public String getStatusSession() {
        return statusSession;
    }

    public void setStatusSession(String statusSession) {
        this.statusSession = statusSession;
    }
}
