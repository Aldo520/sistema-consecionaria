
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Swal */

function ocultarOpcion() {
    $('button[name=btnEditarCliente]').hide();
    $('button[name=btnEliminarCliente]').hide();
    $('button[name=btnAgregarCliente]').show();
    $('#ID_Cliente').hide();
    $('select[name=Usuario]').find('[value="nombre"]').remove();
    $('#FormularioCliente')[0].reset();

}

function agregarcCliente() {
    var formulario = $("#FormularioCliente");
    formulario.validetta({
        realTime: true,
        onValid: function (event) {
            event.preventDefault();
            var method = formulario.attr("method");
            var action = formulario.attr("action");
            var data = formulario.serialize();
            Swal.fire({
                icon: "question",
                title: "Desea ingresar un nuevo registro?",
                showDenyButton: true,
                confirmButtonText: 'Aceptar',
                dennyButtonText: 'Cancelar'
            }).then((result) => {
                if (result.isConfirmed) {
                    $.ajax({
                        type: method,
                        url: "ClienteServlet?accion=GuardarCliente",
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


$(document).ready(function () {
    agregarcCliente();
    $('#Ugenerales').hide();
    $('body').on('click', '#btnEliminar', function () {
        $('button[name=btnEditarCliente]').hide();
        $('button[name=btnEliminarCliente]').show();
        $('button[name=btnAgregarCliente]').hide();
        let fila = $(this).closest('tr');
        llenarFormularios(fila);
        var formulario = $("#FormularioCliente");
        formulario.validetta({
            realTime: true,
            onValid: function (event) {
                event.preventDefault();
                var method = formulario.attr("method");
                var data = formulario.serialize();
                Swal.fire({
                    icon: "question",
                    title: "¿Desea Eliminar este registro?",
                    showDenyButton: true,
                    confirmButtonText: 'Aceptar',
                    dennyButtonText: 'Cancelar'
                }).then((result) => {
                    if (result.isConfirmed) {
                        $.ajax({
                            type: method,
                            url: "ClienteServlet?accion=EliminarCliente",
                            data: data,
                            datatype: "json",
                            success: function (response) {
                                if (response == 1) {
                                    Swal.fire({
                                        icon: 'success',
                                        title: 'Eliminado Exitosamente'
                                    });
                                    setTimeout(function () {
                                        parent.location.href = "Usuarios_Clientes.jsp";
                                    },
                                            800);
                                    console.log(response);
                                } else {
                                    Swal.fire({
                                        icon: 'warning',
                                        title: 'Registro con dependencias',
                                        text: 'usted no puede eliminar este registro'
                                    });


                                    $("#ModalCliente").modal("hide");
                                }
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


    $('body').on('click', '#btnEditar', function () {
        $('button[name=btnEditarCliente]').show();
        $('button[name=btnEliminarCliente]').hide();
        $('button[name=btnAgregarCliente]').hide();
        let fila = $(this).closest('tr');
        llenarFormularios(fila);
        var formulario = $("#FormularioCliente");
        formulario.validetta({
            realTime: true,
            onValid: function (event) {
                event.preventDefault();
                var method = formulario.attr("method");
                var data = formulario.serialize();
                Swal.fire({
                    icon: "question",
                    title: "¿Desea Modificar este registro?",
                    showDenyButton: true,
                    confirmButtonText: 'Aceptar',
                    dennyButtonText: 'Cancelar'
                }).then((result) => {
                    if (result.isConfirmed) {
                        $.ajax({
                            type: method,
                            url: "ClienteServlet?accion=ModificarCliente",
                            data: data,
                            success: function (response) {
                                Swal.fire({
                                    icon: 'success',
                                    title: 'Modificado exitosamente'
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


    function llenarFormularios(fila) {

        $('#ID_Cliente').show();
        var id = fila.find('.id').text();
        var nombre = fila.find('.nombre').text();
        var apellido = fila.find('.apellido').text();
        var telefono = fila.find('.telefono').text();
        var direccion = fila.find('.direccion').text();
        var documento = fila.find('.documento').text();
        var sexo = fila.find('.sexo').text();
        var Usuario = fila.find('.ds').text();
        var categoria = fila.find('.categoria').text();
        $('input[name=txtID]').val(id);
        $('input[name=txtNombres]').val(nombre);
        $('input[name=txtApellidos]').val(apellido);
        $('input[name=txtTelefono]').val(telefono);
        $('input[name=txtDireccion]').val(direccion);
        $('input[name=txtDocumento]').val(documento);
        $('select[name=txtSexo]').find('option:contains(' + sexo + ')').prop('selected', true);
        $('select[name=txtCategoriaCli]').find('option:contains(' + categoria + ')').prop('selected', true);

        $('select[name=Ugenerales]').find('option:contains(' + Usuario + ')').prop('selected', true);
        var valor = $("#Ugenerales").val();
        $('select[name=UsuarioX]').find('option:contains(' + Usuario + ')').remove();
        $('#UsuarioX').prepend("<option value='4f'>" + Usuario + "</option>");
        $('select[name=UsuarioX]').find('option:contains(' + Usuario + ')').prop('selected', true);




        //console.log(usuario);
    }
});