<div class="modal fade" id="addNoteModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-danger text-white">
                <h5 class="modal-title">Agregar nota</h5>
            </div>
            <form action="${pageContext.request.contextPath}/servletController?action=insert" method="POST" class="was-validated"><!--modificar-->
                <div class="modal-body">
                    <div class="form-group">
                        <label for="title">Titulo</label>
                        <input type="text" class="form-control" name="title" required="">
                    </div>
                    <div class="form-group">
                        <label for="body">Cuerpo</label>
                        <textarea class="form-control" rows="6" name="body"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="description">Descripcion</label>
                        <input type="text" class="form-control" name="description" required="">
                    </div>                    
<!--                    <div class="form-group">
                        <label for="copias">Stock</label>
                        <input type="number" class="form-control" name="copias" required="">
                    </div>-->
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">
                        Guardar
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>