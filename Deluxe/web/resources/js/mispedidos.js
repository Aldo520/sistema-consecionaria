/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    $('body').on('click', '#btnEliminar', function () {
        let fila = $(this).closest('tr');
         var codigo = fila.find('.detalle').text();
         
        Swal.fire({
            icon: "question",
            title: "Desea Eliminar este Registro?",
            showDenyButton: true,
            confirmButtonText: 'Aceptar',
            dennyButtonText: 'Cancelar'
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    type: 'POST',
                    url: "MispedidosServlet?accion=Eliminar",
                    data: {
                        detalle: codigo
                    },
                    success: function (response) {
                 
                        Swal.fire({
                            icon: 'success',
                            title: 'Eliminado Exitosamente'
                        })
                        setTimeout(function () {
                            parent.location.href = "Misventas.jsp"
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

    })

})

