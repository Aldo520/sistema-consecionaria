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


$(document).ready(function () {
    agregarpedido()
    $('#Empleado').hide();
    $('#Cliente').hide();
    var Iva = 0, Tfinal, Total = 0;
    $('#btnAdd').click(function () {
        var Motor = document.getElementById("TxtMotor").value;
        var Precio = document.getElementById("TxtPrecio").value;
        var Cliente = $("#TxtCliente").val();
        if (Motor != "" && Precio != "" && Cliente != "") {
            var id = 0;
            $.ajax({
                type: 'POST',
                data: {
                    Codigo: Motor
                },
                datatype: "json",
                url: 'AjaxController',
                success: function (result) {
                    id = result[0].Especificacion;
                    var i = $("#tblInfo ").length
                    // console.log(i)
                    var html = '<tr>' +
                            '<td>' +
                            result[0].modelo +
                            '</td>' +
                            '<td>' +
                            '<Input name="TxtMotor[]" class="text-center border-0" value="' + Motor + '" data-validetta="required">' +
                            '</td>' +
                            '<td>' +
                            result[0].Transmision +
                            '</td>' +
                            '<td>' +
                            result[0].Version +
                            '</td>' +
                            '<td class="categorias">' +
                            '<Input name="TxtPrecio[]" class="text-center border-0 precio" value="' + Precio + '" data-validetta="required" id="cantidad">' +
                            '</td>' +
                            '<td>' +
                            ' <a href="imagen?id=' + result[0].Especificacion + '" target="_blank"><img src="Imagenes/coche.png" title="imagen" width="40%" />' +
                            '</td>' +
                            '<td>' +
                            '<button type="button" class="btn btn-outline-danger btn-sm" id="btnEliminar">Eliminar</button>' +
                            '</td>' +
                            '</tr>';
                    $("#tblInfo").append(html)
                    if (result[0].modelo != null) {
                        Iva = parseFloat(Precio) * (0.13) + parseFloat(Iva);
                        Total = parseFloat(Precio) + parseFloat(Total);
                        Tfinal = parseFloat(Total) + parseFloat(Iva);

                        document.getElementById("Total").value = '$' + Total + ' Dolares';
                        document.getElementById("Iva").value = '$' + Iva + ' Dolares';
                        document.getElementById("TotalFinal").value = '$' + Tfinal + ' Dolares';
                        document.getElementById("Cliente").value = Cliente;
                        document.getElementById("TxtMotor").value = "";
                        document.getElementById("TxtPrecio").value = "";
                    }
                }
            });


        } else {
            Swal.fire({
                icon: 'warning',
                title: 'Existen Campos Vacios'
            })
        }
    });
    $('body').on('click', "#btnEliminar", function () {
        var cantidad = $(this).parents("tr").find('#cantidad').val();
        let fila = $(this).closest('tr').remove()

        var restarimpuesto = 0;
        var restarTotal = 0;
        restarimpuesto = parseFloat(cantidad) * 0.13;
        restarTotal = parseFloat(cantidad) + parseFloat(restarimpuesto);
        Iva = Iva - restarimpuesto;
        Total = Total - parseFloat(cantidad);
        Tfinal = Tfinal - restarTotal;
        document.getElementById("Total").value = '$' + Total + 'Dolares';
        document.getElementById("Iva").value = '$' + Iva + ' Dolares';
        document.getElementById("TotalFinal").value = '$' + Tfinal + ' Dolares';
    });








});

