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

/* global Swal */

function ocultarB() {
    $('#FormularioAutomovil')[0].reset();
    $('button[name=btnEliminarA]').hide();
    $('button[name=btnEditarA]').hide();
    $('button[name=btnAgregarA]').show();
}


function agregarAutomovil() {
    var formulario = $("#FormularioAutomovil")
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
                        url: "AutomovilServlet?accion=Guardar",
                        data: data,
                        success: function (response) {
                            formulario[0].reset()
                            $("#automovil").modal("hide");
                            Swal.fire({
                                icon: 'success',
                                title: 'Registrado Exitosamente'
                            })
                            setTimeout(function () {
                                parent.location.href = "Inventario.jsp"
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
    function llenarFormulario(fila) {
        var codigo = fila.find('.codigo').text();
        var modelo = fila.find('.modelo').text();
        var color = fila.find('.color').text();
        var transmision = fila.find('.transmision').text();
        var version = fila.find('.version').text();
        var precio = fila.find('.precio').text();
        
        $('input[name=TxtMotor]').val(codigo);
        $('select[name=TxtEspecificacion]').find('option:contains(' + modelo + ')').prop('selected', true);
        $('select[name=TxtColor]').find('option:contains(' + color + ')').prop('selected', true);
        $('select[name=TxtTransimision]').find('option:contains(' + transmision + ')').prop('selected', true);
        $('select[name=TxtVersion]').find('option:contains(' + version + ')').prop('selected', true);
          $('input[name=TxtPrecio]').val(precio);

    }
 
 

    $('body').on('click', '#btnEliminarAutomovil', function () {
        let fila = $(this).closest('tr');
        llenarFormulario(fila);
        $('button[name=btnEliminarAutomovil]').show();
        $('button[name=btnEditarAutomovil]').hide();
        $('button[name=btnAgregarAutomovil').hide();
        
    var formulario = $("#FormularioAutomovil")
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
                        url: "AutomovilServlet?accion=Eliminar",
                        data: data,
                        success: function (response) {
                            formulario[0].reset()
                            $("#automovil").modal("hide");
                            Swal.fire({
                                icon: 'success',
                                title: 'Elimanado Exitosamente'
                            })
                            setTimeout(function () {
                                parent.location.href = "Inventario.jsp"
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




    $('body').on('click', '#btnEditarAutomovil', function () {
        let fila = $(this).closest('tr');
        llenarFormulario(fila);
        
        $('button[name=btnEliminarAutomovil]').hide();
        $('button[name=btnEditarAutomovil]').show();
        $('button[name=btnAgregarAutomovil]').hide();

        var formulario = $("#FormularioAutomovil")
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
                            url: "AutomovilServlet?accion=Modificar",
                            data: data,
                            success: function (response) {
                                formulario[0].reset()
                                $("#automovil").modal("hide");
                                Swal.fire({
                                    icon: 'success',
                                    title: 'Modificada exitosamente'
                                })
                                setTimeout(function () {
                                    parent.location.href = "Inventario.jsp"
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
    
