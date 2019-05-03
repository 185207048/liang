package com.bluesky.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.bluesky.dao.ActivityDao;
import com.bluesky.dao.CharityDao;

@WebServlet("/UploadCActivityServlet")
public class UploadCActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadCActivityServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("cmd:"+new String(request.getParameter("cmd").getBytes("GBK"), "UTF-8"));
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=UTF-8");
//		HttpSession session = request.getSession();
//		int cmd=Integer.parseInt(session.getAttribute("cmd").toString());
	try {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> list = upload.parseRequest(request);
		FileItem cmd_F = list.get(0);
		String cmd_S = cmd_F.getFieldName();
		//System.out.println("cmd_S:"+cmd_S);
		if (cmd_S .equals("cmd1")) {
			String title = null, info = null;
			int aid = -1, id = -1;

			// 得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
			String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");

			// 上传时生成的临时文件保存目录
			String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
			File tmpFile = new File(tempPath);

			if (!tmpFile.exists()) {
				// 创建临时目录
				tmpFile.mkdir();
			}

			// 消息提示
			String message = "";
			
				//System.out.println('1');
				// 使用Apache文件上传组件处理文件上传步骤：
				// 1、创建一个DiskFileItemFactory工厂
				//DiskFileItemFactory factory = new DiskFileItemFactory();
				// 设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
				//factory.setSizeThreshold(1024 * 1024);// 设置缓冲区的大小为100KB，如果不指定，那么缓冲区的大小默认是10KB
				// 设置上传时生成的临时文件的保存目录
				factory.setRepository(tmpFile);
				// 2、创建一个文件上传解析器
				//ServletFileUpload upload = new ServletFileUpload(factory);

				// 监听文件上传进度
				upload.setProgressListener(new ProgressListener() {
					public void update(long pBytesRead, long pContentLength, int arg2) {
						// System.out.println("文件大小为：" + pContentLength +
						// ",当前已处理："
						// + pBytesRead);
						/**
						 * 文件大小为：14608,当前已处理：4096 文件大小为：14608,当前已处理：7367
						 * 文件大小为：14608,当前已处理：11419 文件大小为：14608,当前已处理：14608
						 */
					}
				});
				// 解决上传文件名的中文乱码
				upload.setHeaderEncoding("UTF-8");
				// 3、判断提交上来的数据是否是上传表单的数据
				if (!ServletFileUpload.isMultipartContent(request)) {
					// 按照传统方式获取数据
					return;
				}

				// 设置上传单个文件的大小的最大值，目前是设置为1024*1024字节，也就是1MB
				upload.setFileSizeMax(1024 * 1024 * 4);
				// 设置上传文件总量的最大值，最大值=同时上传的多个文件的大小的最大值的和，目前设置为10MB
				upload.setSizeMax(1024 * 1024 * 10);
				// 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
				//List<FileItem> list = upload.parseRequest(request);

				int i = 0;
				for (FileItem item : list) {
					// 如果fileitem中封装的是普通输入项的数据
					if (item.isFormField()) {

						String name = item.getFieldName();
						// 解决普通输入项的数据的中文乱码问题
						String value = item.getString("UTF-8");
						// value = new String(value.getBytes("UTF-8"),"UTF-8");
						//System.out.println(name + "=" + value);
						switch (i) {
						case 1:
							id = Integer.parseInt(value);
							System.out.println("id_1:"+id);
							break;
						case 2:
							aid = Integer.parseInt(value);
							System.out.println("aid_1:"+aid);
							break;
						case 3:
							title = value;
							//System.out.println(name + "=" + value);
							System.out.println("title_1:"+title);
							break;
						case 4:
							info = value;
							System.out.println("info_1:"+info);
							break;
						// case 3:
						// type = Integer.parseInt(value);
						// break;
						// case 2:
						// video = value;
						// break;
						}
						i++;
					} else {// 如果fileitem中封装的是上传文件
							// 得到上传的文件名称，
						System.out.println("filename");
						String filename = item.getName();
						System.out.println(filename);
						if (filename == null || filename.trim().equals("")) {
							continue;
						}
						// 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：
						// c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
						// 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
						filename = filename.substring(filename.lastIndexOf("\\") + 1);
						// 得到上传文件的扩展名
						String fileExtName = filename.substring(filename.lastIndexOf(".") + 1);
						// 如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
						System.out.println("上传的文件的扩展名是：" + fileExtName);
						// 获取item中的上传文件的输入流
						InputStream in = item.getInputStream();
						// 得到文件保存的名称
						String saveFilename = makeFileName(filename);
						// 得到文件的保存目录
						String realSavePath = makePath(saveFilename, savePath);

						String path = realSavePath + "\\" + saveFilename;
						// 数据库保存文件路径
						System.out.println(new CharityDao().getUploadByName(title) + "  jy1");
						if (!new ActivityDao().getUploadByName(title)) {
							System.out.println("add");
							new ActivityDao().insertActivity(aid, title, info, saveFilename, 4, "0");
						} else {
							System.out.println("insert");
							new ActivityDao().changeActivitys(id, title, info, "http://39.105.34.171/img/"+saveFilename, 4);
						}

						//System.out.println(realSavePath);
						// 创建一个文件输出流
						FileOutputStream out = new FileOutputStream(realSavePath + "\\" + saveFilename);
						// 创建一个缓冲区
						byte buffer[] = new byte[1024];
						// 判断输入流中的数据是否已经读完的标识
						int len = 0;
						// 循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
						while ((len = in.read(buffer)) > 0) {
							// 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath +
							// "\\"
							// + filename)当中
							out.write(buffer, 0, len);
						}
						// 关闭输入流
						in.close();
						// 关闭输出流
						out.close();
						// 删除处理文件上传时生成的临时文件
						// item.delete();
						message = "文件上传成功！";

					}
				}
		}else{
//			int id = Integer.parseInt(new String(request.getParameter("id").getBytes("UTF-8"), "UTF-8"));
//			String title1 = new String(request.getParameter("title").getBytes("ISO-8859-1"), "UTF-8");
//			String info1 = new String(request.getParameter("info").getBytes("ISO-8859-1"), "UTF-8");
//			DiskFileItemFactory factory2 = new DiskFileItemFactory();
//			ServletFileUpload upload2 = new ServletFileUpload(factory2);
//			List<FileItem> list2 = upload2.parseRequest(request);
			System.out.println(list.size());
			for(FileItem item2:list) {
				String name = item2.getFieldName();
				String value = item2.getString("UTF-8");
				System.out.println(name + "2=" + value);
			}
			//System.out.println("cmd_S2:"+cmd_S);
			int i = 0;
			int id = 0,aid=0;
			String title = null,info = null;
			for (FileItem item2 : list) {
				// 如果fileitem中封装的是普通输入项的数据
				if (item2.isFormField()) {

					String name = item2.getFieldName();
					String value = item2.getString("UTF-8");
					//System.out.println(name + "=" + value);
					switch (i) {
					case 1:
						id = Integer.parseInt(value);
						System.out.println("id_0:"+id);
						break;
					case 2:
						aid = Integer.parseInt(value);
						System.out.println("aid_0:"+aid);
						break;
					case 3:
						title = value;
						System.out.println("title_0:"+title);
						break;
					case 4:
						info = value;
						System.out.println("info_0:"+info);
						break;
					}
					i++;
				}
				//System.out.println(id+title+info);
			
			}
			new ActivityDao().changeActivitys(id,title,info);
		}
	} catch (FileUploadBase.FileSizeLimitExceededException e) {
		e.printStackTrace();
		return;
	} catch (FileUploadBase.SizeLimitExceededException e) {
		e.printStackTrace();
		return;
	} catch (Exception e) {
		//message = "文件上传失败！";
		e.printStackTrace();
	}
	//System.out.println(message);
	HttpSession session = request.getSession();
	int type=Integer.parseInt(session.getAttribute("type").toString());
	if(type==0) {
		response.sendRedirect("User.jsp");
	}
	else if(type==1) {
		response.sendRedirect("Teacher.jsp");
	}
}
	private String makeFileName(String filename) { // 2.jpg
		// 为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件
		return filename;

	}

	/**
	 * 为防止一个目录下面出现太多文件，要使用hash算法打散存储
	 * 
	 * @Method: makePath
	 * @Description:
	 * @Anthor:孤傲苍狼
	 *
	 * @param filename
	 *            文件名，要根据文件名生成存储目录
	 * @param savePath
	 *            文件存储路径
	 * @return 新的存储目录
	 */
	private String makePath(String filename, String savePath) {
		System.out.println("2");
		// 得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
		// int hashcode = filename.hashCode();
		// int dir1 = hashcode&0xf; //0--15
		// int dir2 = (hashcode&0xf0)>>4; //0-15
		// 构造新的保存目录
		// String dir = savePath + "\\" + title; // upload\2\3 upload\3\5
		String dir = savePath;
		// File既可以代表文件也可以代表目录
		File file = new File(dir);
		// 如果目录不存在
		if (!file.exists()) {
			// 创建目录
			file.mkdirs();
		}
		return dir;
	}
}
