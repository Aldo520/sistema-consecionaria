/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/* global URL, Swal */

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
    $imagenPrevisualizacion.style.width="100%";
    $imagenPrevisualizacion.src = objectURL;
});




function ocultar() {
    $('#Cespecificaciones').hide();
    $('#FormularioEspecificaciones')[0].reset();
    $('button[name=btnAgregar]').show();
    $('button[name=btnEliminar]').hide();
    $('button[name=btnEditar]').hide();
    document.getElementById('imagenPrevisualizacion').style.width="";
    document.getElementById('imagenPrevisualizacion').src = "Imagenes/logo.png";
    
}

function mostrar() {

   $('#Cespecificaciones').show();
}

function Agregar() {
    $('#FormularioEspecificaciones').on('submit');
    var formulario = $("#FormularioEspecificaciones")
    formulario.validetta({
        realTime: true,
        onValid: function (event) {
            event.stopPropagation();
            event.preventDefault();
            var form = document.getElementById('FormularioEspecificaciones');
            var data = new FormData(form);
            Swal.fire({
                icon: "question",
                title: "Desea Ingresar un Nuevo Registro?",
                showDenyButton: true,
                confirmButtonText: 'Aceptar',
                dennyButtonText: 'Cancelar'
            }).then((result) => {
                if (result.isConfirmed) {
                    $.ajax({
                        url: 'EspecificacionesServlet?accion=Guardar',
                        type: 'POST',
                        data: data,
                        cache: false,
                        enctype: 'multipart/form-data',
                        processData: false,
                        contentType: false,
                        success: function (response) {
                            formulario[0].reset()
                            Swal.fire({
                                icon: 'success',
                                title: 'Registrado Exitosamente'
                            })
                            setTimeout(function () {
                                parent.location.href = "Inventario.jsp"
                            },
                                    800);
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
    Agregar();

    $('body').on('click', '#btnEditar', function () {
        let fila = $(this).closest('tr');
        $('button[name=btnAgregar]').hide();
        $('button[name=btnEliminar]').hide();
        $('button[name=btnEditar]').show();
        llenarFormularios(fila);
        $('#FormularioEspecificaciones').on('submit');
        var formulario = $("#FormularioEspecificaciones")
        formulario.validetta({
            realTime: true,
            onValid: function (event) {
                event.stopPropagation();
                event.preventDefault();
                var form = document.getElementById('FormularioEspecificaciones');
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
                            url: 'EspecificacionesServlet?accion=Modificar',
                            type: 'POST',
                            data: data,
                            cache: false,
                            enctype: 'multipart/form-data',
                            processData: false,
                            contentType: false,
                            success: function (response) {
                                formulario[0].reset()
                                Swal.fire({
                                    icon: 'success',
                                    title: 'Modificado Exitosamente'
                                })
                                setTimeout(function () {
                                    parent.location.href = "Inventario.jsp"
                                },
                                        800);
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


    $('body').on('click', '#btnEliminar', function () {
        let fila = $(this).closest('tr');
    $('button[name=btnAgregar]').hide();
    $('button[name=btnEliminar]').show();
    $('button[name=btnEditar]').hide();
        llenarFormularios(fila);
        $('#FormularioEspecificaciones').on('submit');
        var formulario = $("#FormularioEspecificaciones")
        formulario.validetta({
            realTime: true,
            onValid: function (event) {
                event.stopPropagation();
                event.preventDefault();
                var form = document.getElementById('FormularioEspecificaciones');
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
                            url: 'EspecificacionesServlet?accion=Eliminar',
                            type: 'POST',
                            data: data,
                            cache: false,
                            enctype: 'multipart/form-data',
                            processData: false,
                            contentType: false,
                            success: function (response) {
                                formulario[0].reset()
                                Swal.fire({
                                    icon: 'success',
                                    title: 'Eliminar Exitosamente'
                                })
                                setTimeout(function () {
                                    parent.location.href = "Inventario.jsp"
                                },
                                        800);
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

});



function llenarFormularios(fila) {
    var codigo = fila.find('.registro').text();
    var nombre = fila.find('.marca').text();
    var categoria = fila.find('.categoria').text();
    var modelo = fila.find('.modelos').text();
    var descripcion = fila.find('.descrip').text();
    $('input[name=TxtRegistro]').val(codigo);
    $('select[name=TxtMarca]').find('option:contains(' + nombre + ')').prop('selected', true);
    $('input[name=TxtModelos]').val(modelo);
    $('TextArea[name=TxtDescripcion]').val(descripcion);
    $('select[name=TxtCategoria]').find('option:contains(' + categoria + ')').prop('selected', true);
    document.getElementById('imagenPrevisualizacion').style.width="100%";
    document.getElementById('imagenPrevisualizacion').src = "imagen?id=" + codigo;
   
}





 