package com.racic.lib.webapp.controller;

import com.racic.lib.client.Work;
import com.racic.lib.client.WorkWeb;
import com.racic.lib.client.WorkWs;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class WorkController {



    @RequestMapping(value = "/workinfo/{worksId}")
    public ModelAndView getWorkInfo(@PathVariable Integer worksId) {
        ModelAndView mv = new ModelAndView("work/works-detail");
        WorkWeb workWsService = new WorkWeb();
        WorkWs workWs = workWsService.getWorkWsPort();

        Work work = workWs.findWorksById(worksId);
        mv.addObject("work", work);
        return mv;
    }

    @RequestMapping(value = "/searchbyauthor", method = RequestMethod.GET)
    public ModelAndView workssearchbyauthor(@RequestParam("author") String author) {

        boolean result;
        ModelAndView modelAndView = null;

       WorkWeb workWsService = new WorkWeb();
       WorkWs workWs = workWsService.getWorkWsPort();
        List<com.racic.lib.client.Work> worksListFoundByAuthor = workWs.findWorksByAuthorContain(author);
        result = workWs.isValidWorkByAuthor(author);

        if (result == true) {
            if (author != null) {
                modelAndView = new ModelAndView("work/worksfound");
                modelAndView.addObject("worksListFound", worksListFoundByAuthor);
            } else {
                modelAndView = new ModelAndView("library/error");
                modelAndView.addObject("msg", "Error occured while processing");
            }
        } else {
            modelAndView = new ModelAndView("library/error");
            modelAndView.addObject("msg", "Error occured while processing");
        }

        return modelAndView;
    }
    @RequestMapping(value = "/searchbytitle", method = RequestMethod.GET)
    public ModelAndView workssearchbytitle(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        boolean valid;

        String title = request.getParameter("title");

        WorkWeb workWebService = new WorkWeb();
        WorkWs wsWork = workWebService.getWorkWsPort();

       List<com.racic.lib.client.Work> worksListFoundByTitle = wsWork.findWorksByTitleContain(title);
        valid = wsWork.isValidWorkByTitle(title);

        if (valid == true) {
            if (title != null) {
                mv.setViewName("work/worksfound");
                mv.addObject("worksListFound", worksListFoundByTitle);

            } else {
                mv.setViewName("library/error");
                mv.addObject("msg", "Error occured while processing");
            }
        } else {
            mv.setViewName("library/error");
            mv.addObject("msg", "Error occured while processing");
        }

        return mv;
    }


    @RequestMapping(value = "/searchwork", method = RequestMethod.GET)
    public ModelAndView searchwork(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();


        String title = request.getParameter("title");
        String author = request.getParameter("author");


        WorkWeb workWebService = new WorkWeb();
        WorkWs wsWork = workWebService.getWorkWsPort();
        boolean isWorkValid;
        List<com.racic.lib.client.Work> worksListFound = wsWork.findWorksByTitleAndAuthor(author,title);
        isWorkValid = wsWork.isValidWork(author,title);


        if (isWorkValid == true) {
            if (title != null || author !=null) {
                mv.setViewName("work/worksfound");
                mv.addObject("worksListFound", worksListFound);
            } else {
                mv.setViewName("work/worksearch");
                mv.addObject("msg", "No work with the chosen title can be found!");
            }
        } else {
            mv.setViewName("library/error");
            mv.addObject("msg", "Error occured while processing");
        }

        return mv;
    }
}