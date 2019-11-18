<?php
    require("BD.php");

    $conexion = mysqli_connect($hostname,$username,$password,$database);
    $select = "SELECT * FROM artista";	
    $resultado = mysqli_query($conexion,$select);
    while($registro = mysqli_fetch_array($resultado,MYSQLI_ASSOC)){
        echo $registro['Id'] ."|";
        echo $registro['Nombre'] . "|";
        echo $registro['Img'];
        echo "\n";
    }
    mysqli_close($conexion);
?>