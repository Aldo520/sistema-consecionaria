/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function agregarpedido() {
    var formulario = $("#FormularioPedido")
    formulario.validetta({
        realTime: true,
        onValid: function (event) {
            event.preventDefault();
            var method = formulario.attr("method")
            var data = formulario.serialize()
            Swal.fire({
                icon: "question",
                title: "Desea Ingresar un Nuevo Registro?",
                showDenyButton: true,
                confirmButtonText: 'Aceptar',
                dennyButtonText: 'Cancelar'
            }).then((result) => {
                if (result.isConfirmed) {
                    $.ajax({
                        type: method,
                        url: "PedidosServlet?accion=Guardar",
                        data: data,
                        success: function (response) {
                            formulario[0].reset()
                            Swal.fire({
                                icon: 'success',
                                title: 'Registrado Exitosamente'
                            })
                            setTimeout(function () {
                                parent.location.href = "Prueba.jsp"
                            },
                                    800);
                            console.log(response);
                        }, error: function () {
                            Swal.fire({
                                icon: 'Error',
                                title: 'Ah ocurrido un Error',
                                text: 'Error al procesar el Registro'
                            })
                        }
                    })
                } else if (result.isDenied) {
                    Swal.fire('Operacion Cancelada')
                }
            })
        }
    })

}


$(document).ready(function(){
    // Agregar más personal
    $("#btnNuevo").click(function(){
        var i = $("#example").length
        // console.log(i)
        var html = '<tr>'+
            '<td>'+
                '<input type="text" name="txtNombre[]" class="form-control">'+
            '</td>'+
            '<td>'+
                '<select name="sCargo[]" class="form-control">'+
                    '<option value="Scrum Master">Scrum Master</option>'+
                    '<option value="Desarrollador Frontend">Desarrollador Frontend</option>'+
                    '<option value="Desarrollador Backend">Desarrollador Backend</option>'+
                '</select>'+
            '</td> '+                                   
            '<td>'+
                '<div class="form-check">'+
                    '<input type="checkbox" name="cIdiomas'+i+'[]" class="form-check-inline" value="Inglés">Inglés '+
                    '<input type="checkbox" name="cIdiomas'+i+'[]" class="form-check-inline" value="Español">Español '+
                '</div>'+
            '</td>'+
            '<td>'+
                '<input type="number" class="form-control" name="txtSalario[]">'+
            '</td>'+
            '<td>'+
                '<button type="button" class="btn btn-outline-danger btn-sm" id="btnEliminar">Eliminar</button>'+
            '</td>'+
        '</tr>';
        $("#tblInfo").append(html)
    });
});
