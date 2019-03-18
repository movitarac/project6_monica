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
    private Date sessionTimeIN; // have to reformat with timestamp

    @Column
    private Date sessionTimeOut; //timeoutnow + 30 minutes have to reformat with timestamp
    @Column
    private String statusSession;

    //TODO list all attributes for Session and add getters setters

    public Session() {
    }

    public Session(Member member, Date sessionTimeOut,Date sessionTimeIN, String statusSession) {
        this.member = member;
        this.sessionTimeOut = sessionTimeOut;
        this.statusSession=statusSession;
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

    public void setSessionTimeOut(Date sessionTimeOut) {
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

    public Date getSessionTimeIN() {
        return sessionTimeIN;
    }

    public void setSessionTimeIN(Date sessionTimeIN) {
        this.sessionTimeIN = sessionTimeIN;
    }
}
