package com.racic.lib.business.service.contract;

import com.racic.lib.model.Member;
import com.racic.lib.model.Session;

import java.util.List;

public interface SessionService {
    List<Session> getAll();

    Session findSessionById(Integer sessionId);


    //methode security
    //private -- not exposed as webmethod
    boolean checkSession(Integer idSession);

    //methode creation of session
    boolean createSession(Member member);

    boolean determineSession(Member member);
}
