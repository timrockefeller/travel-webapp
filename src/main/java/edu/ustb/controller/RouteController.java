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
import edu.ustb.vo.PageBean;

import edu.ustb.vo.PageBean;

/**
 * RouteController
 */

@WebServlet(name = "RouteServlet", urlPatterns = "/route/*")
public class RouteController extends BaseServlet {

    private RouteService routeService = new RouteServiceImpl();
    private FavoriteService favoriteService = new FavoriteServiceImpl();



    public void findOne(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rid = request.getParameter("rid");
        int r = Integer.parseInt(rid);
        Route route = routeService.getRouteByRid(r);
        writeValue(route,response );
    }

    public void isFavorite(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rid = request.getParameter("rid");
        int r = Integer.parseInt(rid);
        User user = (User) request.getSession().getAttribute("user");
        int uid;
        if (user == null) {
            uid = 0;
        } else {
            uid = user.getUid();
        }

        boolean flag = favoriteService.isFavorite(r, uid);

        writeValue(flag,response);
    }

    public void addFavorite(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rid = request.getParameter("rid");
        int r = Integer.parseInt(rid);
        User user = (User) request.getSession().getAttribute("user");
        int uid;
        if (user == null) {
            return;
        } else {
            uid = user.getUid();
        }
        favoriteService.addFavorite(r, uid);
        // TODO whether responce in none-param callback
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write("{}");
    }

    /**
     * 分页查询
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void pageQuery(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");

        //接收rname线路名称
        String rname = request.getParameter("rname");
        rname = new String(rname.getBytes("utf-8"), "utf-8");

        int cid = 0;
        if (cidStr != null && cidStr.length() > 0 && !"null".equals(cidStr)) {
            cid = Integer.parseInt(cidStr);
        }

        int currentPage = 0;
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }

        int pageSize = 0;
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        } else {
            pageSize = 5;
        }

        PageBean<Route> routePageBean = routeService.pageQuery(cid, currentPage, pageSize, rname);

        writeValue(routePageBean,response);
    }
}

