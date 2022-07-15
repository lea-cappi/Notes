<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!--libreria que nos brinda herramientas-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notas - Listado</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/6f8946e33d.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <%
            System.out.println("------------------cargando body de notes.jsp---------------------------");
        
        %>
        
        <jsp:include page="/WEB-INF/pages/commons/header.jsp"/>
        
        <jsp:include page="/WEB-INF/pages/commons/navigation.jsp"/>
        
        <jsp:include page="/WEB-INF/pages/operations/notesList.jsp"/>
        
        <jsp:include page="/WEB-INF/pages/commons/footer.jsp"/>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </body>
</html>
