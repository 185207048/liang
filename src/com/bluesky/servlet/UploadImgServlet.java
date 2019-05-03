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
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.bluesky.dao.ImgDao;

@WebServlet("/UploadImgServlet")
public class UploadImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadImgServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=UTF-8");
		int type = -1;

		// �õ��ϴ��ļ��ı���Ŀ¼�����ϴ����ļ������WEB-INFĿ¼�£����������ֱ�ӷ��ʣ���֤�ϴ��ļ��İ�ȫ
		String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");

		// �ϴ�ʱ���ɵ���ʱ�ļ�����Ŀ¼
		String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
		File tmpFile = new File(tempPath);

		if (!tmpFile.exists()) {
			// ������ʱĿ¼
			tmpFile.mkdir();
		}

		// ��Ϣ��ʾ
		String message = "";
		try {
			System.out.println('1');
			// ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
			// 1������һ��DiskFileItemFactory����
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// ���ù����Ļ������Ĵ�С�����ϴ����ļ���С�����������Ĵ�Сʱ���ͻ�����һ����ʱ�ļ���ŵ�ָ������ʱĿ¼���С�
			factory.setSizeThreshold(1024 * 1024);// ���û������Ĵ�СΪ100KB�������ָ������ô�������Ĵ�СĬ����10KB
			// �����ϴ�ʱ���ɵ���ʱ�ļ��ı���Ŀ¼
			factory.setRepository(tmpFile);
			// 2������һ���ļ��ϴ�������
			ServletFileUpload upload = new ServletFileUpload(factory);

			// �����ļ��ϴ�����
			upload.setProgressListener(new ProgressListener() {
				public void update(long pBytesRead, long pContentLength, int arg2) {
					// System.out.println("�ļ���СΪ��" + pContentLength + ",��ǰ�Ѵ���"
					// + pBytesRead);
					/**
					 * �ļ���СΪ��14608,��ǰ�Ѵ���4096 �ļ���СΪ��14608,��ǰ�Ѵ���7367
					 * �ļ���СΪ��14608,��ǰ�Ѵ���11419 �ļ���СΪ��14608,��ǰ�Ѵ���14608
					 */
				}
			});
			// ����ϴ��ļ�������������
			upload.setHeaderEncoding("UTF-8");
			// 3���ж��ύ�����������Ƿ����ϴ���������
			if (!ServletFileUpload.isMultipartContent(request)) {
				// ���մ�ͳ��ʽ��ȡ����
				return;
			}

			// �����ϴ������ļ��Ĵ�С�����ֵ��Ŀǰ������Ϊ1024*1024�ֽڣ�Ҳ����1MB
			upload.setFileSizeMax(1024 * 1024 * 4);
			// �����ϴ��ļ����������ֵ�����ֵ=ͬʱ�ϴ��Ķ���ļ��Ĵ�С�����ֵ�ĺͣ�Ŀǰ����Ϊ10MB
			upload.setSizeMax(1024 * 1024 * 10);
			// 4��ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���һ��List<FileItem>���ϣ�ÿһ��FileItem��Ӧһ��Form����������
			List<FileItem> list = upload.parseRequest(request);

			int i = 0;
			for (FileItem item : list) {
				// ���fileitem�з�װ������ͨ�����������
				if (item.isFormField()) {

					String name = item.getFieldName();
					// �����ͨ����������ݵ�������������
					String value = item.getString("UTF-8");
					// value = new String(value.getBytes("UTF-8"),"UTF-8");
					System.out.println(name + "=" + value);
					switch (i) {
					case 0:
						type = Integer.parseInt(value);
						break;
					// case 2:
					// video = value;
					// break;
					}
					i++;
				} else {// ���fileitem�з�װ�����ϴ��ļ�
						// �õ��ϴ����ļ����ƣ�
					String filename = item.getName();
					System.out.println(filename);
					if (filename == null || filename.trim().equals("")) {
						continue;
					}
					// ע�⣺��ͬ��������ύ���ļ����ǲ�һ���ģ���Щ������ύ�������ļ����Ǵ���·���ģ��磺
					// c:\a\b\1.txt������Щֻ�ǵ������ļ������磺1.txt
					// �����ȡ�����ϴ��ļ����ļ�����·�����֣�ֻ�����ļ�������
					filename = filename.substring(filename.lastIndexOf("\\") + 1);
					// �õ��ϴ��ļ�����չ��
					String fileExtName = filename.substring(filename.lastIndexOf(".") + 1);
					// �����Ҫ�����ϴ����ļ����ͣ���ô����ͨ���ļ�����չ�����ж��ϴ����ļ������Ƿ�Ϸ�
					System.out.println("�ϴ����ļ�����չ���ǣ�" + fileExtName);
					// ��ȡitem�е��ϴ��ļ���������
					InputStream in = item.getInputStream();
					// �õ��ļ����������
					String saveFilename = makeFileName(filename);
					// �õ��ļ��ı���Ŀ¼
					String realSavePath = makePath(saveFilename, savePath);

					String path = realSavePath + "\\" + saveFilename;
					// ���ݿⱣ���ļ�·��
					// System.out.println(new
					// CharityDao().getUploadByName(title) + " jy1");
					// if (new InfoDao().getUploadByName(title)) {
					// new InfoDao().insertInfo(title, path,info,type);
					// } else {
					// new InfoDao().changeInfo(new
					// InfoDao().getid(title),title,path, info,type);
					// }
					new ImgDao().insertImg(saveFilename, type);
					System.out.println(realSavePath);
					// ����һ���ļ������
					FileOutputStream out = new FileOutputStream(realSavePath + "\\" + saveFilename);
					// ����һ��������
					byte buffer[] = new byte[1024];
					// �ж��������е������Ƿ��Ѿ�����ı�ʶ
					int len = 0;
					// ѭ�������������뵽���������У�(len=in.read(buffer))>0�ͱ�ʾin���滹������
					while ((len = in.read(buffer)) > 0) {
						// ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼(savePath + "\\"
						// + filename)����
						out.write(buffer, 0, len);
					}
					// �ر�������
					in.close();
					// �ر������
					out.close();
					// ɾ�������ļ��ϴ�ʱ���ɵ���ʱ�ļ�
					// item.delete();
					message = "�ļ��ϴ��ɹ���";

				}
			}
		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			e.printStackTrace();
			return;
		} catch (FileUploadBase.SizeLimitExceededException e) {
			e.printStackTrace();
			return;
		} catch (Exception e) {
			message = "�ļ��ϴ�ʧ�ܣ�";
			e.printStackTrace();
		}
		System.out.println(message);
	}

	/**
	 * makeFileName �����ϴ��ļ����ļ������ļ����ԣ�uuid+"_"+�ļ���ԭʼ����
	 *
	 * filename �ļ���ԭʼ���� uuid+"_"+�ļ���ԭʼ����
	 */
	private String makeFileName(String filename) { // 2.jpg
		// Ϊ��ֹ�ļ����ǵ���������ҪΪ�ϴ��ļ�����һ��Ψһ���ļ�
		return filename;

	}

	/**
	 * Ϊ��ֹһ��Ŀ¼�������̫���ļ���Ҫʹ��hash�㷨��ɢ�洢
	 * 
	 * @Method: makePath
	 * @Description:
	 * @Anthor:�°�����
	 *
	 * @param filename
	 *            �ļ�����Ҫ�����ļ������ɴ洢Ŀ¼
	 * @param savePath
	 *            �ļ��洢·��
	 * @return �µĴ洢Ŀ¼
	 */
	private String makePath(String filename, String savePath) {
		System.out.println("2");
		// �õ��ļ�����hashCode��ֵ���õ��ľ���filename����ַ����������ڴ��еĵ�ַ
		// int hashcode = filename.hashCode();
		// int dir1 = hashcode&0xf; //0--15
		// int dir2 = (hashcode&0xf0)>>4; //0-15
		// �����µı���Ŀ¼
		// String dir = savePath + "\\" + title; // upload\2\3 upload\3\5
		String dir = savePath;
		// File�ȿ��Դ����ļ�Ҳ���Դ���Ŀ¼
		File file = new File(dir);
		// ���Ŀ¼������
		if (!file.exists()) {
			// ����Ŀ¼
			file.mkdirs();
		}
		return dir;
	}
}
