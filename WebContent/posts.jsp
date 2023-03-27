<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h1>게시글</h1>
<a href="/posts/insert">글쓰기</a>
<table>
   <c:forEach items="${list}" var="vo">
      <tr>
         <td>${vo.id}</td>
         <td><a href="/posts/read?id=${vo.id}">${vo.title}</a></td>
         <td>${vo.writer}</td>
         <td><fmt:formatDate type ="date" 
               value="${vo.date}" pattern ="yyyy-MM-dd HH:mm:ss"/><td>
      </tr>
   </c:forEach>
</table>
   