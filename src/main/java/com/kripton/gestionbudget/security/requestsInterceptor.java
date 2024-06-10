package com.kripton.gestionbudget.security;

import com.kripton.gestionbudget.Interface.HistoriqueInterface;
import com.kripton.gestionbudget.Repository.HistoriqueRepository;
import com.kripton.gestionbudget.entities.Historique;
import com.kripton.gestionbudget.services.HistoriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Date;

@Component
public class requestsInterceptor implements HandlerInterceptor {


    private StaticHistoricHolder historicHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        long startTime = System.currentTimeMillis();
        System.out.println("\n-------- LogInterception.preHandle --- ");
        System.out.println("Request URL : " + request.getRequestURL());
        System.out.println("Start Time : " + System.currentTimeMillis());
       // String name = request.getUserPrincipal().getName();
        System.out.println("User :" +request.getUserPrincipal().getName());
        request.setAttribute("startTime", startTime);
        System.out.println("\n-Inside the Pre Handle method");
        //persist data into database

        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,Object handler, ModelAndView modelAndView)
            throws Exception {

        System.out.println("\n-------- LogInterception.postHandle --- ");
        System.out.println("Request URL: " + request.getRequestURL());
        System.out.println("date :" + request.getHeaders("Date"));

        // You can add attributes in the modelAndView

        //String userPrincipal = request.getUserPrincipal().getName();
        Date date = new Date();
        Historique historique = new Historique(date,request.getRequestURL().toString(),request.getUserPrincipal().getName());
        //System.out.println("testtt" +userPrincipal);
        historicHolder.historiqueRepository.save(historique);
        //historique1.setAction(request.getRequestURL());
        //historiqueService.Add(new Historique("hamza"));
        // and use that in the view page
    }


}




