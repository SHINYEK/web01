package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PostDAO;
import model.PostVO;


@WebServlet(value = {"/posts", "/posts/insert", "/posts/read","/posts/delete","/posts/update"})
public class PostsController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   PostDAO dao = new PostDAO();
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      RequestDispatcher dis = request.getRequestDispatcher("/home.jsp");
      
      switch(request.getServletPath()) {
      case "/posts/read":
    	  int id = Integer.parseInt(request.getParameter("id"));
    	  request.setAttribute("vo", dao.read(id));
    	  request.setAttribute("pageName", "read.jsp");
    	  dis.forward(request, response);
    	  break;
      case "/posts":
         request.setAttribute("list", dao.list());
         request.setAttribute("pageName", "posts.jsp");
          dis.forward(request, response);
         break;
      case "/posts/insert" :
         request.setAttribute("pageName", "insert.jsp");
         dis.forward(request, response);//이게있어야 이동가능.( 이동명령 )
         break;
      case "/posts/update":
    	  id = Integer.parseInt(request.getParameter("id"));
		  request.setAttribute("vo", dao.read(id));
		  request.setAttribute("pageName", "update.jsp");
		  dis.forward(request, response);
		  break;
      }
   }
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   request.setCharacterEncoding("UTF-8");
	   switch(request.getServletPath()) {
	   case "/posts/insert":
		   PostVO vo = new PostVO();
		   vo.setTitle(request.getParameter("title"));
		   vo.setBody(request.getParameter("body"));
		   vo.setWriter(request.getParameter("writer"));
		   dao.insert(vo);
		   response.sendRedirect("/posts");
		   break;
	   case "/posts/delete": 
		   int id = Integer.parseInt(request.getParameter("id"));
		   dao.delete(id);
		   System.out.println(id+"id........");
		   break;
	   case "/posts/update":
		   vo = new PostVO();
		   vo.setId(Integer.parseInt(request.getParameter("id")));
		   vo.setTitle(request.getParameter("title"));
		   vo.setBody(request.getParameter("body"));
		   vo.setWriter(request.getParameter("writer"));
		   dao.update(vo);
//		   System.out.println(vo.toString());
		   response.sendRedirect("/posts");
	   }
     
   }

}