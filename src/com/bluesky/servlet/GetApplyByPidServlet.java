package com.bluesky.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bluesky.dao.ApplyDao;
import net.sf.json.JSONArray;

@WebServlet("/GetApplyByPidServlet")
public class GetApplyByPidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetApplyByPidServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int pid = Integer.parseInt(new String(request.getParameter("pid").getBytes("UTF-8"), "UTF-8"));
		JSONArray ja = JSONArray.fromObject(new ApplyDao().getApplyByPid(pid));
		out.print(ja);
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
