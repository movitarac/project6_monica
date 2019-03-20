package com.racic.lib.consumer.repository;

import com.racic.lib.model.Member;
import com.racic.lib.model.Session;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SessionRepository extends CrudRepository<Session,Integer> {


    List<Session> findAll();
    List<Session> findSessionsByMember (Member member);


}
