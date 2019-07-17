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
     * 查询当前是否已标记收藏 需要session已保存user字段
     * 
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

    /**
     * 为当前用户收藏指定Route
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addFavorite(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        int rid = Integer.parseInt(request.getParameter("rid"));
        favoriteService.addFavorite(user, rid);

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
        // 接受参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");
        String rname = request.getParameter("rname");

        // 处理参数
        int cid = 0;
        if (cidStr != null && cidStr.length() > 0) {
            cid = Integer.parseInt(cidStr);
        }

        int currentPage = 0;// 当前页码,默认为第一页
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }

        int pageSize = 0;// 默认为5
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        } else {
            pageSize = 5;
        }

        // 调用service查询PageBean
        PageBean<Route> routePageBean = routeService.pageQuery(cid, currentPage, pageSize, rname);
        // 讲pageBean序列化为json
        writeValue(routePageBean, response);
    }
}
