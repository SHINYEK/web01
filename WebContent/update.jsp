<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>글수정</h1>
<form name="frm">
	<input type="text" value="user02" name="writer"/>
	<input type="text" name="id" value="${vo.id}"/>
	<input type="text" name="title" value="${vo.title}"/>
	<br>
	<textarea rows="10" cols="80" name="body">${vo.body}</textarea>
	<br>
	<button type="submit">글수정</button>
</form>
<script>
	$(frm).on("submit",function(e){
		e.preventDefault();
		if(!confirm(`${vo.id}번 게시글을 수정하실래요?`))return;
		frm.action ="/posts/update";
		frm.method ="post";
		frm.submit();
	})
</script>