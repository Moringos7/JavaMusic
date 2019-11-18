<?php
    require("BD.php");

    $conexion = mysqli_connect($hostname,$username,$password,$database);
    $select = "SELECT DISTINCT c.FkAlbum AS Id, (SELECT Titulo FROM album WHERE Id = c.FkAlbum) as Titulo,
               (SELECT NOMBRE FROM artista WHERE Id = ca.FkArtista) as Artista,
               (SELECT IMG FROM album WHERE Id = c.FkAlbum) as Img 
               FROM cancion c JOIN cancionartista ca ON c.id = ca.FkCancion";	
    $resultado = mysqli_query($conexion,$select);
    while($registro = mysqli_fetch_array($resultado,MYSQLI_ASSOC)){
        echo $registro['Id'] ."|";
        echo $registro['Titulo'] . "|";
        echo $registro['Artista'] . "|";
        echo $registro['Img'];
        echo "\n";
    }
    mysqli_close($conexion);
?>