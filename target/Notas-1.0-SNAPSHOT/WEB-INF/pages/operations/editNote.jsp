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
        
        <jsp:include page="WEB-INF/pages/commons/header.jsp"/> 
        
        <form action="${pageContext.request.contextPath}/servletController?action=modify&idNote=${note.idNote}" 
              method="POST" class="was-validated">
            <jsp:include page="WEB-INF/pages/commons/editNav.jsp"/>
            
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Nota</h4>
                                </div>
                                <div class="card-body">
                                    
                                    <div class="form-group">
                                        <label for="title">Titulo</label>
                                        <input type="text" class="form-control" name="titulo" required="" value="${note.title}">
                                    </div>
                                    <div class="form-group">
                                        <label for="body">Cuerpo</label>
                                        <input type="text" class="form-control" name="body" value="${note.body}">
                                    </div>
                                    <div class="form-group">
                                        <label for="description">Descripcion</label>
                                        <input type="text" class="form-control" name="description" required="" value="${note.description}">
                                    </div> 
                                </div>
                                <div class="modal-footer">
                                    <button class="btn btn-primary" type="submit">
                                        Guardar
                                    </button>
                                </div>
                                
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            
        </form>        
        
        <jsp:include page="WEB-INF/pages/commons/footer.jsp"/>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </body>
</html>