package com.racic.lib.business.service.impl;

import com.racic.lib.business.service.contract.BookService;
import com.racic.lib.business.service.contract.WorkService;
import com.racic.lib.consumer.repository.WorkRepository;
import com.racic.lib.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("workService")
public class WorkServiceImpl implements WorkService {

    @Autowired
    WorkRepository workRepository;

    @Autowired
    BookService bookService;

    @Override
    public List<Work> getAll() {

        return workRepository.findAll();
    }

    @Override
    public Work findWorksById(Integer worksid) { return workRepository.findById(worksid).get();
    }

    @Override
    public List<Work> findWorksByAuthorContain(String author) {
        return workRepository.findWorksByAuthorIsContainingIgnoreCase(author);
    }

    @Override
    public List<Work> findWorksByTitleContain(String title) {
        //return workRepository.findWorksByTitleIsContainingIgnoreCase(title);
        return workRepository.findWorksByTitleIsContainingIgnoreCase(title);
    }

    @Override
    public boolean isValidWorkByTitle(String title) {
        boolean beReturned;
        //List<Work> workListByTitle = workRepository.findWorksByTitleIsContainingIgnoreCase(title);
        List<Work> workListByTitle = workRepository.findWorksByTitleIsContainingIgnoreCase(title);
        if (workListByTitle.size()>=1) {
            beReturned = true;
        } else {
            beReturned = false;
        }
        return beReturned;
    }


    public boolean isValidWorkByAuthor(String author) {
        boolean toReturn;
        List<Work> worksListFoundByAuthor = workRepository.findWorksByAuthorIsContainingIgnoreCase(author);

        if (worksListFoundByAuthor.size() >= 1) {
            toReturn = true;
        } else {
            toReturn = false;
        }
        return toReturn;
    }

    @Override
    public List<Work> findWork(String author, String title) {

        return workRepository.findByAuthorIsContainingAndTitleIsContaining(author,title);
    }

    @Override
    public boolean isValidWork(String author, String title) {
        boolean beReturned;
        List<Work> workFound = workRepository.findByAuthorIsContainingAndTitleIsContaining(author,title);
        if (workFound.size()>=1) {
            beReturned = true;
        } else {
            beReturned = false;
        }
        return beReturned;
    }

}