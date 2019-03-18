package com.racic.lib.business.service.contract;

import com.racic.lib.model.Member;
import com.racic.lib.model.Session;

import java.util.List;

public interface SessionService {
    List<Session> getAll();

    Session findSessionById(Integer sessionId);

    Session findSessionByMember(Member member);

    boolean determineSession(Member member);
}
