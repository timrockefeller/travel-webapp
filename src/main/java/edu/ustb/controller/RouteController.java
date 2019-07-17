package edu.ustb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.ustb.domain.Route;
import edu.ustb.service.RouteService;
import edu.ustb.service.impl.RouteServiceImpl;

/**
 * RouteController
 */
@WebServlet("/route/*") //
public class RouteController extends BaseServlet {

    private RouteService routeService = new RouteServiceImpl();

    /**
     * 根据rid，返回一个Route类型对象
     * 
     * @param rid
     * @return (1)Route Obj (2) Empty Obj "{}“
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int rid = Integer.parseInt(request.getParameter("rid"));

        Route route = routeService.getRouteByRid(rid);

        String json = null;
        if (route == null) {
            json = "{}";
        } else {
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(route);
        }
        
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    public void isFavorite(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    public void addFavorite(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
