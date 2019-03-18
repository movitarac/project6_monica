package com.racic.lib.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity(name="Session")
public class Session {
    //session est context

    @Id
    @GeneratedValue
    @Column
    private Integer idSession;


    private Member member; //?

    @Column
    private Date sessionTimeIN; // have to reformat with timestamp DELETE

    @Column
    private Timestamp sessionTimeOut; // inactif timeoutnow + 30 minutes have to reformat with timestamp


    //TODO list all attributes for Session and add getters setters

    public Session() {
    }

    public Session(Member member, Timestamp sessionTimeOut,Date sessionTimeIN) {
        this.member = member;
        this.sessionTimeOut = sessionTimeOut;

        this.sessionTimeIN = sessionTimeIN;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getSessionTimeOut() {
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

    public Date getSessionTimeIN() {
        return sessionTimeIN;
    }

    public void setSessionTimeIN(Date sessionTimeIN) {
        this.sessionTimeIN = sessionTimeIN;
    }
}
