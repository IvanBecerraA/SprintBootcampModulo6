const dataTableOptions = {
    lengthMenu: [5, 10, 15, 20],
    pageLength: 10,
    destroy: true,
    language:{
        lengthMenu: "Mostrar _MENU_ registros por página",
        zeroRecords: "Ningún usuario encontrado",
        info: "Mostrando de _START_ a _END_ de un total de _TOTAL_ registros",
        infoEmpty: "Ningún usuario encontrado",
        infoFiltered: "(filtrados desde _MAX_ registros totales)",
        search: "Buscar:",
        loadingRecords: "Cargando...",
        paginate: {
            first: "Primero",
            last: "Último",
            next: "Siguiente",
            previous: "Anterior"
        }
    }
}

$('document').ready(function () {
    $('#tablaUsuarios').DataTable(dataTableOptions);

    // Agregar eventos click a los botones de editar y eliminar
    $('#tablaUsuarios tbody').on('click', '#eliminar', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $('#modalEliminar #confirmarEliminar').attr('href', href);
        $('#modalEliminar').modal();
    });

    $('#tablaUsuarios tbody').on('click', '#editar', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function (usuario, status) {
            console.log(usuario);
            $('#idUsuario').val(usuario.idUsuario);
            $('#run').val(usuario.run);
            $('#run2').val(usuario.run);
            $('#nombre').val(usuario.nombre);
            $('#apellido1').val(usuario.apellido1);
            $('#apellido2').val(usuario.apellido2);
            $('#email').val(usuario.email);
            $('#telefono').val(usuario.telefono);
            $('#clave').val(usuario.clave);

            if (usuario.perfil.idPerfil == 2) {
                $('#contador').prop('checked', true);
            } else {
                $('#empleador').prop('checked', true);
            }
        });

        $('#modalEditar').modal();
    });
});