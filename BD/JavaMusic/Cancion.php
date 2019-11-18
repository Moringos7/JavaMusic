<?php
     require("BD.php");
    
     if(isset($_GET["id"])){
         $idCancion =  $_GET["id"];
         $conexion = mysqli_connect($hostname,$username,$password,$database);
         $select = "SELECT c.Id,c.Titulo,c.Duracion,(SELECT IMG FROM album WHERE Id = c.FkAlbum) as Img,
                    (SELECT NOMBRE FROM artista WHERE Id = ca.FkArtista) as Artista 
                    FROM cancion c JOIN cancionartista ca 
                    ON c.id = ca.FkCancion WHERE c.Id = '$idCancion'";	
         $resultado = mysqli_query($conexion,$select);
         while($registro = mysqli_fetch_array($resultado,MYSQLI_ASSOC)){
             echo $registro['Id']."|";
             echo $registro['Titulo']. "|";
             echo $registro['Duracion']. "|";
             echo $registro['Img']. "|";
             echo $registro['Artista']. "|";
             echo "\n";
         }
         mysqli_close($conexion);
     }else{
         echo "#";
     }
?>