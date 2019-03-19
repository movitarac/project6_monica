package com.racic.lib.model;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity(name="Session")
public class Session {
    //session est context

    @Id
    @GeneratedValue
    @Column
    private Integer idSession;

    @Column
    private Timestamp sessionStart; // have to reformat with timestamp DELETE

    @Column
    private Timestamp sessionTimeOut; // inactif timeoutnow + 30 minutes have to reformat with timestamp

   @OneToOne
    private Member member;

    //TODO list all attributes for Session and add getters setters

    public Session() {
    }

    public Session(Timestamp sessionStart, Timestamp sessionTimeOut) {
        this.sessionStart = sessionStart;
        this.sessionTimeOut = sessionTimeOut;
    }

    public Session(Timestamp sessionStart, Timestamp sessionTimeOut, Member member) {
        this.sessionStart = sessionStart;
        this.sessionTimeOut = sessionTimeOut;
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

    public Timestamp getSessionStart() {
        return sessionStart;
    }

    public void setSessionStart(Timestamp sessionStart) {
        this.sessionStart = sessionStart;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}

