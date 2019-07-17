package edu.ustb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.ustb.domain.Favorite;
import edu.ustb.domain.User;
import edu.ustb.service.FavoriteService;
import edu.ustb.service.impl.FavoriteServiceImpl;
/**
 * FavoriteController
 */
@WebServlet("/favorite/*")
public class FavoriteController extends BaseServlet {
    private static final long serialVersionUID = 5742419665921471276L;
    private FavoriteService favoriteService = new FavoriteServiceImpl();

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // TODO
        // User user = (User) request.getSession().getAttribute("user");
        User user = new User() {
            {
                setUid(12);
            }
        };

        List<Favorite> favlist = favoriteService.getFavoritesByUser(user);

        System.out.println(favlist);

        // 将info对象序列化为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(favlist);
        System.out.println(json);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

}
