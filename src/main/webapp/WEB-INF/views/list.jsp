<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<body>
<form:form>
  <table>
    <thead>
      <tr>
      <td>ID</td>
      <td>NOTE</td>
      <td align="center">ACTIONS</td>
      </tr>	
    </thead>
    <c:forEach items="${notes}" var="note">
      <tr>
        <td>${note.id}</td>
        <td>${note.note}</td>
        <td><input type="button" value="Update" onClick='location.href="/simpleMVC/update/${note.id}"'><input type="button" value="Delete" onClick='location.href="/simpleMVC/delete/${note.id}"'></td>
      </tr>
    </c:forEach>
  </table>
  <input type="button" value="Create new note" onClick='location.href="/simpleMVC/create"'>
  <br/>
</form:form>
</body>
</html>
