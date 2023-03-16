package edu.pnu.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/filedownload")
public class FileDownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	// get방식으로 받겠다.

		String realPath = req.getServletContext().getRealPath(File.separator + "upload");	// 다운받을 경로 설정
		String fname = req.getParameter("name");	// doGet으로 전달 받은 parameter
		
		System.out.println("filename: " + realPath + File.separator + fname);

		File file = new File(realPath, fname);	// File 객체 생성.
		if (file != null) {
			try(FileInputStream is = new FileInputStream(file))	// InputStream 생성.
			{	
				// 파일 다운로드용 응답 헤더 설정.
				resp.reset();
				resp.setContentType("appliction/octet-stream");
				resp.setHeader("content-Disposition",  "attachment; filename=\"" + fname + "\"");
				resp.setHeader("Content-Length",  String.valueOf(file.length()));
				// OutputStream 생성.
				OutputStream outStream = resp.getOutputStream();
				
				int rsize;
				byte[] buffer = new byte[1024];
				while((rsize = is.read(buffer)) != -1) {	// InputStream의 메서드 read로 읽어서 더 이상 읽을 것이 없을때 -1 반환
					outStream.write(buffer, 0, rsize);		// outstream의 메서드 write로 데이터를 읽음.
				}
				outStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("End");
		}
	}
}
