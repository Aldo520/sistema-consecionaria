
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Swal */

function ocultarOpciones() {
    $('button[name=btnEditarEmp]').hide();
    $('button[name=btnEliminarEmp]').hide();
    $('button[name=btnAgregarEmp]').show();
    $('#ID_Empleado').hide();
     $('select[name=Usuario]').find('[value="nombre"]').remove();
   
}

function agregarEmpleado() {
    var formulario = $("#FormularioEmpleado");
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
                        url: "Empleado_Servlet?accion=GuardarEmpleado",
                        data: data,
                        success: function (response) {
                            Swal.fire({
                                icon: 'success',
                                title: 'Registrado Exitosamente'
                            });
                            setTimeout(function () {
                                parent.location.href = "Empleado.jsp";
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
agregarEmpleado();
 $('#Ugenerales').hide();

$('body').on('click', '#btnEliminar', function () {
    $('button[name=btnEditarEmp]').hide();
    $('button[name=btnEliminarEmp]').show();
    $('button[name=btnAgregarEmp]').hide();
    let fila = $(this).closest('tr');
    llenarFormularios(fila);
    var formulario = $("#FormularioEmpleado");
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
                        url: "Empleado_Servlet?accion=EliminarEmpleado",
                        data: data,
                        success: function (response) {
                            alert(response);
                            Swal.fire({
                                icon: 'success',
                                title: 'Eliminado Exitosamente'
                            });
                            setTimeout(function () {
                                parent.location.href = "Empleado.jsp";
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


$('body').on('click', '#btnEditar', function () {
    $('button[name=btnEditarEmp]').show();
    $('button[name=btnEliminarEmp]').hide();
    $('button[name=btnAgregarEmp]').hide();
    let fila = $(this).closest('tr');
    llenarFormularios(fila);
    var formulario = $("#FormularioEmpleado");
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
                        url: "Empleado_Servlet?accion=ModificarEmpleado",
                        data: data,
                        success: function (response) {
                            Swal.fire({
                                icon: 'success',
                                title: 'Modificado exitosamente'
                            });
                            setTimeout(function () {
                                parent.location.href = "Empleado.jsp";
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
$('select#Ugenerales').on('change',function(){
    var valor = $(this).val();
    alert(valor);
});

function llenarFormularios(fila) {
    
    
    $('#ID_Empleado').show();
    var id = fila.find('.id').text();
    var nombre = fila.find('.nombre').text();
    var apellido = fila.find('.apellido').text();
    var telefono = fila.find('.telefono').text();
    var direccion = fila.find('.direccion').text();
    var documento = fila.find('.documento').text();
    var sexo = fila.find('.sexo').text();
    var usuario = fila.find('.username').text();
    $('input[name=txtID]').val(id);
    $('input[name=txtNombres]').val(nombre);
    $('input[name=txtApellidos]').val(apellido);
    $('input[name=txtTelefono]').val(telefono);
    $('input[name=txtDireccion]').val(direccion);
    $('input[name=txtDocumento]').val(documento);
    $('select[name=txtSexo]').find('option:contains(' + sexo + ')').prop('selected', true);
    
   $('select[name=Ugenerales]').find('opt\n\
ion:contains(' + usuario + ')').prop('selected', true);
    var valor = $("#Ugenerales").val();
   $('select[name=Usuario]').find('option:contains(' + usuario + ')').remove();
   $('#Usuario').prepend("<option value='"+valor+"'>"+usuario+"</option>");
   $('select[name=Usuario]').find('option:contains(' + usuario + ')').prop('selected', true);
    
    //console.log(usuario);
}
});