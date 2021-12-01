/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function ocultarB() {
    $('#delta').hide();
    $('#Formulario')[0].reset();
    $('button[name=btnEliminar]').hide();
    $('button[name=btnEditar]').hide();
    $('button[name=btnAgregar]').show();
}
function mostrar(){
    $('#delta').show();
}

function agregar() {
    var formulario = $("#Formulario")
    formulario.validetta({
        realTime: true,
        onValid: function (event) {
            event.preventDefault();
            var method = formulario.attr("method")
            var action = formulario.attr("action")
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
                        url: "MarcaServlet?accion=Guardar",
                        data: data,
                        success: function (response) {
                            formulario[0].reset()
                            $("#marca").modal("hide");
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
    $('body').on('click', '#btnEliminar', function () {
        let fila = $(this).closest('tr');
        llenarFormulario(fila);
        $('button[name=btnEliminar]').show();
        $('button[name=btnEditar]').hide();
        $('button[name=btnAgregar]').hide();

        var formulario = $("#Formulario")
        formulario.validetta({
            realTime: true,
            onValid: function (event) {
                event.preventDefault();
                var method = formulario.attr("method")
                var action = formulario.attr("action")
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
                            url: "MarcaServlet?accion=Eliminar",
                            data: data,
                            success: function (response) {
                                formulario[0].reset()
                                $("#marca").modal("hide");
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




    $('body').on('click', '#btnEditar', function () {
        let fila = $(this).closest('tr');
        llenarFormulario(fila);
        $('button[name=btnEliminar]').hide();
        $('button[name=btnEditar]').show();
        $('button[name=btnAgregar]').hide();

        var formulario = $("#Formulario")
        formulario.validetta({
            realTime: true,
            onValid: function (event) {
                event.preventDefault();
                var method = formulario.attr("method")
                var action = formulario.attr("action")
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
                            url: "MarcaServlet?accion=Modificar",
                            data: data,
                            success: function (response) {
                                formulario[0].reset()
                                $("#marca").modal("hide");
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
        var codigo = fila.find('.registro').text();
        var nombre = fila.find('.marca').text();


        $('input[name=TxtRegistro]').val(codigo);
        $('input[name=TxtMarca]').val(nombre);

    }
}); 