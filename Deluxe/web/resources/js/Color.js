/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function ocultarB1() {
    $('#Ccolores').hide();
    $('#FormularioColor')[0].reset();
    $('button[name=btnEliminarColores]').hide();
    $('button[name=btnEditarColores]').hide();
    $('button[name=btnAgregarColores]').show();
}
function mostrar1(){
    $('#Ccolores').show();
}

function agregarColor() {
    var formulario = $("#FormularioColor")
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
                        url: "ColorServlet?accion=Guardar",
                        data: data,
                        success: function (response) {
                            formulario[0].reset()
                            $("#Color").modal("hide");
                            Swal.fire({
                                icon: 'success',
                                title: 'Registrado Exitosamente'
                            })
                            setTimeout(function () {
                                parent.location.href = "DatosGenerales.jsp"
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
agregar();
    $('body').on('click', '#btnEliminarColor', function () {
        let fila = $(this).closest('tr');
        var codigo = fila.find('.detalle').text();

        $('button[name=btnEliminarColores]').show();
        $('button[name=btnEditarColores]').hide();
        $('button[name=btnAgregarColores]').hide();

        var formulario = $("#FormularioColor")
        formulario.validetta({
            realTime: true,
            onValid: function (event) {
                event.preventDefault();
                var method = formulario.attr("method")
                var data = formulario.serialize()
                Swal.fire({
                    icon: "question",
                    title: "Desea Eliminar este Registro?",
                    showDenyButton: true,
                    confirmButtonText: 'Aceptar',
                    dennyButtonText: 'Cancelar'
                }).then((result) => {
                    if (result.isConfirmed) {
                        $.ajax({
                            type: method,
                            url: "ColorServlet?accion=Eliminar",
                            data: data,
                            success: function (response) {
                                formulario[0].reset()
                                $("#Color").modal("hide");
                                Swal.fire({
                                    icon: 'success',
                                    title: 'Eliminado Exitosamente'
                                })
                                setTimeout(function () {
                                    parent.location.href = "DatosGenerales.jsp"
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
    });




    $('body').on('click', '#btnEditarColor', function () {
        let fila = $(this).closest('tr');


        var formulario = $("#FormularioColor")
        formulario.validetta({
            realTime: true,
            onValid: function (event) {
                event.preventDefault();
                var method = formulario.attr("method")
                var data = formulario.serialize()
                Swal.fire({
                    icon: "question",
                    title: "Desea Modificar este Registro?",
                    showDenyButton: true,
                    confirmButtonText: 'Aceptar',
                    dennyButtonText: 'Cancelar'
                }).then((result) => {
                    if (result.isConfirmed) {
                        $.ajax({
                            type: method,
                            url: "ColorServlet?accion=Modificar",
                            data: data,
                            success: function (response) {
                                formulario[0].reset()
                                $("#Color").modal("hide");
                                Swal.fire({
                                    icon: 'success',
                                    title: 'Modificada exitosamente'
                                })
                                setTimeout(function () {
                                    parent.location.href = "DatosGenerales.jsp"
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
    });




    function llenarFormulario(fila) {
        var codigo = fila.find('.registroX').text();
        var nombre = fila.find('.colorX').text();


        $('input[name=TxtRegistro]').val(codigo);
        $('input[name=TxtColor]').val(nombre);

    }
}); 