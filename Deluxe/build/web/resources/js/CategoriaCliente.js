/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Swal */

function ocultarOpcionesCat() {
    $('button[name=btnEditarCatCli]').hide();
    $('button[name=btnEliminarCatCli]').hide();
    $('button[name=btnAgregarCatCli]').show();
    $('#txtIDCategoria').hide();
}

function llenarFormulario(fila) {
    $('#txtIDCategoria').show();
    var codigo = fila.find('.IDCatCli').text();
    var nombre = fila.find('.CatCli').text();
    $('input[name=txtIDCatCli]').val(codigo);
    $('input[name=txtCategoriaCliente]').val(nombre);
}

function agregarCategoriaCliente() {
    var formulario = $("#FormularioCatCli");
    formulario.validetta({
        realTime: true,
        onValid: function (event) {
            event.preventDefault();
            var method = formulario.attr("method");
            var action = formulario.attr("action");
            var data = formulario.serialize();
            Swal.fire({
                icon: "question",
                title: "¿Desea ingresar un nuevo registro?",
                showDenyButton: true,
                confirmButtonText: 'Aceptar',
                dennyButtonText: 'Cancelar'
            }).then((result) => {
                if (result.isConfirmed) {
                    $.ajax({
                        type: method,
                        url: "CategoriaClienteServlet?accion=GuardarCategoriaCliente",
                        data: data,
                        success: function (response) {
                            Swal.fire({
                                icon: 'success',
                                title: 'Registrado Exitosamente'
                            });
                            setTimeout(function () {
                                parent.location.href = "Usuarios_Clientes.jsp";
                            }, 800);
                        }, error: function () {
                            Swal.fire({
                                icon: 'Error',
                                title: 'Ah ocurrido un Error',
                                text: 'Error al procesar el Registro'
                            });
                        }
                    });
                } else if (result.isDenied) {
                    Swal.fire('Operacion Cancelada');
                }
            });
        }
    });
}

$('body').on('click', '#btnEditarCatCli', function () {
    $('button[name=btnEditarCatCli]').show();
    $('button[name=btnEliminarCatCli]').hide();
    $('button[name=btnAgregarCatCli]').hide();
    let fila = $(this).closest('tr');
    llenarFormulario(fila);
    var formulario = $("#FormularioCatCli");
    formulario.validetta({
        realTime: true,
        onValid: function (event) {
            event.preventDefault();
            var method = formulario.attr("method");
            var data = formulario.serialize();
            Swal.fire({
                icon: "question",
                title: "¿Desea modificar este Registro?",
                showDenyButton: true,
                confirmButtonText: 'Aceptar',
                dennyButtonText: 'Cancelar'
            }).then((result) => {
                if (result.isConfirmed) {
                    $.ajax({
                        type: method,
                        url: "CategoriaClienteServlet?accion=ModificarCategoriaCliente",
                        data: data,
                        success: function (response) {
                            formulario[0].reset();
                            Swal.fire({
                                icon: 'success',
                                title: 'Modificada exitosamente'
                            });
                            setTimeout(function () {
                                parent.location.href = "Usuarios_Clientes.jsp";
                            },
                                    800);
                            console.log(response);
                        }, error: function () {
                            Swal.fire({
                                icon: 'Error',
                                title: 'Ah ocurrido un Error',
                                text: 'Error al procesar el Registro'
                            });
                        }
                    });
                } else if (result.isDenied) {
                    Swal.fire('Operacion Cancelada');
                }
            });
        }
    });
});

$('body').on('click', '#btnEliminarCatCli', function () {
    $('button[name=btnEditarCatCli]').hide();
    $('button[name=btnEliminarCatCli]').show();
    $('button[name=btnAgregarCatCli]').hide();
    let fila = $(this).closest('tr');
    llenarFormulario(fila);
    var formulario = $("#FormularioCatCli");
    formulario.validetta({
        realTime: true,
        onValid: function (event) {
            event.preventDefault();
            var method = formulario.attr("method");
            var data = formulario.serialize();
            Swal.fire({
                icon: "question",
                title: "¿Desea eliminar este Registro?",
                showDenyButton: true,
                confirmButtonText: 'Aceptar',
                dennyButtonText: 'Cancelar'
            }).then((result) => {
                if (result.isConfirmed) {
                    $.ajax({
                        type: method,
                        url: "CategoriaClienteServlet?accion=EliminarCategoriaCliente",
                        data: data,
                        success: function (response) {
                            formulario[0].reset();
                            Swal.fire({
                                icon: 'success',
                                title: 'Eliminado exitosamente'
                            });
                            setTimeout(function () {
                                parent.location.href = "Usuarios_Clientes.jsp";
                            },
                                    800);
                            console.log(response);
                        }, error: function () {
                            Swal.fire({
                                icon: 'Error',
                                title: 'Ah ocurrido un Error',
                                text: 'Error al procesar el Registro'
                            });
                        }
                    });
                } else if (result.isDenied) {
                    Swal.fire('Operacion Cancelada');
                }
            });
        }
    });
});