package com.bluesky.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bluesky.dao.PlatformDao;
import net.sf.json.JSONArray;

@WebServlet("/ChangePlatformFlagServlet")
public class ChangePlatformFlagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChangePlatformFlagServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset= UTF-8");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(new String(request.getParameter("id").getBytes("UTF-8"), "UTF-8"));
		int flag = Integer.parseInt(new String(request.getParameter("flag").getBytes("UTF-8"), "UTF-8"));

		JSONArray ja = JSONArray.fromObject(new PlatformDao().changePlatform(id, flag));
		out.print(ja);
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
