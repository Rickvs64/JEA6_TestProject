<%@ page import="Domains.Movie" %>
<%@ page import="java.util.List" %>
<html>
    <body>
        <h2>Hello World!</h2>

        <%
            List<Movie> movies = (List<Movie>) request.getAttribute("movies");
            for (Movie s : movies) {
                out.print("<br/>" + s.getId() + " " + s.getName());
            }
        %>
    </body>
</html>