<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<section id="notes">
    <div class="container">
        <div class="row">
            <div class="col">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de notas</h4>
                    </div>
                    <table class="table table-striped table-dark">
                        <thead class="thead-dark">
                            <tr>
                                <th style="width: 5%">#</th>
                                <th style="width: 50%">Titulo</th>
                                <th style="width: 30%">Tags</th>
                                <th style="width: 15%">Accion</th> <!--COMPLETAR HREF CUANDO ESTE TERMINADO JSP EDITAR-->
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="note" items="${notes}" varStatus="status"> <!--Para no mostrar los id y mostrar un conteo-->
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${note.title}</td>
                                    <td>${note.tagsString()}</td>
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
        </div>
    </div>
</section>
                        
                        <jsp:include page="/WEB-INF/pages/operations/notesAdd.jsp"/>
