package com.racic.lib.business.service.contract;

import com.racic.lib.model.Member;
import com.racic.lib.model.Session;

import java.util.List;

public interface SessionService {
    List<Session> getAll();

    Session findSessionById(Integer sessionId);



    //methode creation of session
    Integer createSession(Member member);

    boolean checkSession(Member member);

    boolean checkSession(Integer idSession);





}
