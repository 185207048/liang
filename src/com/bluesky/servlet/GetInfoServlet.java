package com.bluesky.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bluesky.dao.InfoDao;
import com.bluesky.entity.Info;
import net.sf.json.JSONArray;

@WebServlet("/GetInfoServlet")
public class GetInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetInfoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset= UTF-8");
		PrintWriter out = response.getWriter();
		int type = Integer.parseInt(new String(request.getParameter("type").getBytes("UTF-8"), "UTF-8"));
		int start = Integer.parseInt(new String(request.getParameter("start").getBytes("UTF-8"), "UTF-8"));
		int end = Integer.parseInt(new String(request.getParameter("end").getBytes("UTF-8"), "UTF-8"));
		list = new InfoDao().getAllInfo(type, start, end);
		JSONArray ja = JSONArray.fromObject(list);
		out.print(ja);
		out.flush();
		out.close();
	}

	private List<Info> list = new ArrayList<Info>();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
