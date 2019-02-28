<%@ page import="Domains.Movie" %>
<html>
<body>
<h2>Form - page 2</h2>
<p>The following movie has been found:
<%
    Movie movie = (Movie) request.getAttribute("movie");
    out.print(movie.getName());
    out.print(movie);
%>
</p>
</body>
</html>