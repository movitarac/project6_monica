package com.racic.lib.business.service.contract;

import com.racic.lib.model.Work;

import java.util.List;

public interface WorkService {

    List<Work> getAll();
    Work findWorksById(Integer worksid);

    List<Work> findWorksByAuthorContain(String author);

    List<Work> findWorksByTitleContain(String title);

    boolean isValidWorkByTitle(String title);

    boolean isValidWorkByAuthor(String author);


    List<Work> findWork(String author, String title);

    boolean isValidWork(String author, String title);
}
