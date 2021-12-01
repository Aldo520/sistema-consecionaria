/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function ocultarC() {
    $('#Ccategoria').hide();
    $('#FormularioCategoria')[0].reset();
    $('button[name=btnEliminarC]').hide();
    $('button[name=btnEditarC]').hide();
    $('button[name=btnAgregarC]').show();
}
function mostrarC(){
    $('#Ccategoria').show();
}

function agregarCategoria() {
    var formulario = $("#FormularioCategoria")
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
                        url: "CategoriaServlet?accion=Guardar",
                        data: data,
                        success: function (response) {
                            formulario[0].reset()
                            $("#categoria").modal("hide");
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
    $('body').on('click', '#btnEliminarC', function () {
        let fila = $(this).closest('tr');
        llenarFormulario(fila);
        $('button[name=btnEliminarC]').show();
        $('button[name=btnEditarC]').hide();
        $('button[name=btnAgregarC]').hide();

        var formulario = $("#FormularioCategoria")
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
                            url: "CategoriaServlet?accion=Eliminar",
                            data: data,
                            success: function (response) {
                                formulario[0].reset()
                                $("#categoria").modal("hide");
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




    $('body').on('click', '#btnEditarC', function () {
        let fila = $(this).closest('tr');
        llenarFormulario(fila);
        $('button[name=btnEliminarC]').hide();
        $('button[name=btnEditarC]').show();
        $('button[name=btnAgregarC]').hide();

        var formulario = $("#FormularioCategoria")
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
                            url: "CategoriaServlet?accion=Modificar",
                            data: data,
                            success: function (response) {
                                formulario[0].reset()
                                $("#categoria").modal("hide");
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
        var nombre = fila.find('.categorias').text();
        $('input[name=TxtRegistro]').val(codigo);
        $('input[name=TxtCategoria]').val(nombre);

    }
}); 

