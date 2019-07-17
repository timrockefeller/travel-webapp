package edu.ustb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.ustb.domain.Route;
import edu.ustb.domain.User;
import edu.ustb.service.FavoriteService;
import edu.ustb.service.RouteService;
import edu.ustb.service.impl.FavoriteServiceImpl;
import edu.ustb.service.impl.RouteServiceImpl;

/**
 * RouteController
 */
@WebServlet("/route/*") //
public class RouteController extends BaseServlet {

    private RouteService routeService = new RouteServiceImpl();
    private FavoriteService favoriteService = new FavoriteServiceImpl();

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

    /**
     * 用户查询是否已标记收藏
     *  需要session已保存user字段
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void isFavorite(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        int rid = Integer.parseInt(request.getParameter("rid"));

        Boolean favFlag = favoriteService.isFavorite(user, rid);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(favFlag);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    public void addFavorite(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
