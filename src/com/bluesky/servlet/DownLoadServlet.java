package com.bluesky.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bluesky.dao.CharityDao;

@WebServlet("/DownLoadServlet")
public class DownLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DownLoadServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fileName = new String(request.getParameter("filename").getBytes("UTF-8"), "UTF-8");
		// System.out.println(fileName);
		// �ϴ����ļ����Ǳ�����/WEB-INF/uploadĿ¼�µ���Ŀ¼����
		// String fileSaveRootPath =
		// this.getServletContext().getRealPath("/WEB-INF/upload");
		// ͨ���ļ����ҳ��ļ�������Ŀ¼
		// String path = findFileSavePathByFileName(fileName, fileSaveRootPath);
		// �õ�Ҫ���ص��ļ�
		String fileSaveRootPath = new CharityDao().getUploadPathByName(fileName);
		// System.out.println(fileSaveRootPath);
		File file = new File(fileSaveRootPath);
		// ����ļ�������
		if (!file.exists()) {
			request.setAttribute("message", "��Ҫ���ص���Դ�ѱ�ɾ������");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		// �����ļ���
		String realname = fileName.substring(fileName.indexOf("_") + 1);
		// ������Ӧͷ��������������ظ��ļ�
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
		// ��ȡҪ���ص��ļ������浽�ļ�������
		FileInputStream in = new FileInputStream(fileSaveRootPath);
		// ���������
		OutputStream out = response.getOutputStream();
		// ����������
		byte buffer[] = new byte[1024];
		int len = 0;
		// ѭ�����������е����ݶ�ȡ������������
		while ((len = in.read(buffer)) > 0) {
			// ��������������ݵ��������ʵ���ļ�����
			out.write(buffer, 0, len);
		}
		// �ر��ļ�������
		in.close();
		// �ر������
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
