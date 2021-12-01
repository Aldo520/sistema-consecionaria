/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Swal */

const $seleccionArchivos = document.querySelector("#seleccionArchivos"),
        $imagenPrevisualizacion = document.querySelector("#imagenPrevisualizacion");

$seleccionArchivos.addEventListener("change", () => {

    const archivos = $seleccionArchivos.files;
    if (!archivos || !archivos.length) {
        $imagenPrevisualizacion.src = "";
        return;
    }
    const primerArchivo = archivos[0];
    const objectURL = URL.createObjectURL(primerArchivo);
    $imagenPrevisualizacion.style.width = "50%";
    $imagenPrevisualizacion.style.width = "display:block;margin;auto";
    $imagenPrevisualizacion.src = objectURL;
});


function Agregar() {
    $('#FormularioUsuario')[0].reset();
    $('button[name=btnAgregarUser]').show();
    $('button[name=btnEditarUser]').hide();
    $('button[name=btnEliminarUser]').hide();
    document.getElementById('imagenPrevisualizacion').style.width = "";
    document.getElementById('imagenPrevisualizacion').src = "Imagenes/user.png";
    $('#ID').hide();
    $('#contra').show();
}

function agregarUser() {
    document.getElementById('contra').style.display = "block";
    $('#FormularioUsuario').on('submit');
    var formulario = $("#FormularioUsuario")
    formulario.validetta({
        realTime: true,
        onValid: function (event) {
            event.stopPropagation();
            event.preventDefault();
            var form = document.getElementById('FormularioUsuario');
            var data = new FormData(form);
            Swal.fire({
                icon: "question",
                title: "¿Desea ingresar un nuevo registro?",
                showDenyButton: true,
                confirmButtonText: 'Aceptar',
                dennyButtonText: 'Cancelar'
            }).then((result) => {
                if (result.isConfirmed) {
                    $.ajax({
                        url: 'UsuarioServlet?accion=GuardarUsuario',
                        type: 'POST',
                        data: data,
                        cache: false,
                        datatype: 'json',
                        enctype: 'multipart/form-data',
                        processData: false,
                        contentType: false,
                        success: function (response) {
                            alert(response)
                            if (response == 1) {
                                formulario[0].reset()
                                Swal.fire({
                                    icon: 'success',
                                    title: 'Registrado Exitosamente'
                                })
                                setTimeout(function () {
                                    parent.location.href = "Usuario.jsp"
                                },
                                        800);
                            } else {
                                Swal.fire({
                                    icon: 'warning',
                                    title: 'Usuario No Disponible',
                                    text: 'porfavor ingresa otro nombre de usuario'
                                })
                            }
                        },
                        error: function (textStatus) {
                            alert('ERRORS: ' + textStatus);
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
    $('body').on('click', '#btnEliminar', function () {
        let fila = $(this).closest('tr');
        llenarFormularios(fila);
        $('button[name=btnAgregarUser]').hide();
        $('button[name=btnEditarUser]').hide();
        $('button[name=btnEliminarUser]').show();

        $('#FormularioUsuario').on('submit');
        var formulario = $("#FormularioUsuario")
        formulario.validetta({
            realTime: true,
            onValid: function (event) {
                event.stopPropagation();
                event.preventDefault();
                var form = document.getElementById('FormularioUsuario');
                var data = new FormData(form);
                Swal.fire({
                    icon: "question",
                    title: "Desea Eliminar Este Registro?",
                    showDenyButton: true,
                    confirmButtonText: 'Aceptar',
                    dennyButtonText: 'Cancelar'
                }).then((result) => {
                    if (result.isConfirmed) {
                        $.ajax({
                            url: 'UsuarioServlet?accion=Eliminar',
                            type: 'POST',
                            data: data,
                            cache: false,
                            datatype: 'json',
                            enctype: 'multipart/form-data',
                            processData: false,
                            contentType: false,
                            success: function (response) {
                                if (response == 1) {
                                    formulario[0].reset()
                                    Swal.fire({
                                        icon: 'success',
                                        title: 'Eliminar Exitosamente'
                                    })
                                    setTimeout(function () {
                                        parent.location.href = "Usuario.jsp"
                                    },
                                            800);
                                } else {
                                    Swal.fire({
                                        icon: 'warning',
                                        title: 'Registro con Dependencias',
                                        text: 'Usted no puede eliminar este registro'
                                    })
                                    $("#ModalUsuario").modal("hide");
                                }
                            },
                            error: function (textStatus) {
                                alert('ERRORS: ' + textStatus);
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
        llenarFormularios(fila);
        $('button[name=btnAgregarUser]').hide();
        $('button[name=btnEditarUser]').show();
        $('button[name=btnEliminarUser]').hide();
        $('#FormularioUsuario').on('submit');
        var formulario = $("#FormularioUsuario")
        formulario.validetta({
            realTime: true,
            onValid: function (event) {
                event.stopPropagation();
                event.preventDefault();
                var form = document.getElementById('FormularioUsuario');
                var data = new FormData(form);
                Swal.fire({
                    icon: "question",
                    title: "Desea Modificar Este Registro?",
                    showDenyButton: true,
                    confirmButtonText: 'Aceptar',
                    dennyButtonText: 'Cancelar'
                }).then((result) => {
                    if (result.isConfirmed) {
                        $.ajax({
                            url: 'UsuarioServlet?accion=Modificar',
                            type: 'POST',
                            data: data,
                            cache: false,
                            datatype: 'json',
                            enctype: 'multipart/form-data',
                            processData: false,
                            contentType: false,
                            success: function (response) {
                                if (response == 1) {
                                    formulario[0].reset()
                                    Swal.fire({
                                        icon: 'success',
                                        title: 'Modificado Exitosamente'
                                    })
                                    setTimeout(function () {
                                        parent.location.href = "Usuario.jsp"
                                    },
                                            800);
                                } else {
                                    Swal.fire({
                                        icon: 'warning',
                                        title: 'Usuario Existente',
                                        text: 'Este usuario ya esta en uso'
                                    });
                                }
                            },
                            error: function (textStatus) {
                                alert('ERRORS: ' + textStatus);
                            }
                        })
                    } else if (result.isDenied) {
                        Swal.fire('Operacion Cancelada')
                    }
                })
            }
        })
    });




    function llenarFormularios(fila) {
        $('#contra').hide();
        var id = fila.find('.id').text();
        var username = fila.find('.username').text();
        var correo = fila.find('.correo').text();
        var tipo = fila.find('.tipo').text();
        $('input[name=txtID]').val(id);
        $('input[name=txtUserName]').val(username);
        $('input[name=txtCorreo]').val(correo);
        $('select[name=tipousuario]').find('option:contains(' + tipo + ')').prop('selected', true);
        document.getElementById('imagenPrevisualizacion').style.width = "50%";
        document.getElementById('imagenPrevisualizacion').src = "UsuarioImagen?id=" + id;
    }


});