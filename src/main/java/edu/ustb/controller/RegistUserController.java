package edu.ustb.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.ustb.domain.User;
import edu.ustb.service.UserService;
import edu.ustb.service.impl.UserServiceImpl;
import edu.ustb.vo.ResultInfo;

@WebServlet("/regist.do")
public class RegistUserController extends HttpServlet {
	private UserService service = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取所有请求参数
		Map<String, String[]> map = request.getParameterMap();
		User user = new User();
		try {
			// 封装对象
			BeanUtils.populate(user, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		// 调用service 保存用户
		boolean flag = service.regist(user);

		ResultInfo info = new ResultInfo();
		// 4.响应结果
		if (flag) {
			// 注册成功
			info.setFlag(true);
		} else {
			// 注册失败
			info.setFlag(false);
			info.setErrorMsg("注册失败!用户已存在");
		}

		// 将info对象序列化为json
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(info);

		// 将json数据写回客户端
		// 设置content-type
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
		
		//mapper.writeValue(response.getOutputStream(), info);

	}

}
