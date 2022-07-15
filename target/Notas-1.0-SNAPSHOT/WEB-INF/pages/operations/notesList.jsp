<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<section id="notes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de notas</h4>
                    </div>
                    <table class="table table-striped table-dark">
                        <thead class="thead-dark">
                            <tr>
                                <!--<th>#</th>-->
                                <th>Titulo</th>
                                <th>Cuerpo</th>
                                <th>Descripcion</th>
                                <th>Tags</th>
                                <th>Accion</th> <!--COMPLETAR HREF CUANDO ESTE TERMINADO JSP EDITAR-->
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="note" items="${notes}" varStatus="status"> <!--Para no mostrar los id y mostrar un conteo-->
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${note.title}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/servletController?action=edit&idNote=${note.idNote}" 
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-rihgt"></i>
                                            Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class ="col-md-3">
                <div class="card text-center bg-danger test-white mb-3">
                    <div class="card-body">
                        <h3>Cuerpo</h3>
                        <h4 class="display-4">
                            ${body}
                        </h4>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
</section>
                        
                        <jsp:include page="/WEB-INF/pages/operations/notesAdd.jsp"/>
