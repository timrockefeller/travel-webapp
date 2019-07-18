package edu.ustb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.ustb.domain.Category;
import edu.ustb.service.CategoryService;
import edu.ustb.service.impl.CategoryServiceImpl;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/category/*")
public class CategoryController extends BaseServlet {
	private CategoryService service=new CategoryServiceImpl();
    
	public void findAll(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		List<Category> list = null;
		list=service.getAllCategory();
		// ObjectMapper mapper = new ObjectMapper();
        // String json = writeValueAsString(list);
        // response.setContentType("application/json;charset=utf-8");
		// response.getWriter().write(json);
		writeValue(list, response);
	}

}
