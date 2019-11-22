<?php
     require("BD.php");
    
     if(isset($_GET["busca"])){
        $param =  $_GET["busca"];
        $conexion = mysqli_connect($hostname,$username,$password,$database);
        $canciones = false;
        $artistas = false;
        $album = false;
        //Canciones
        $select = "SELECT c.Id,c.Titulo,c.Duracion,(SELECT IMG FROM album WHERE Id = c.FkAlbum) as Img,
        (SELECT NOMBRE FROM artista WHERE Id = ca.FkArtista) as Artista 
        FROM cancion c JOIN cancionartista ca 
        ON c.id = ca.FkCancion WHERE c.Titulo LIKE '$param%'";	
        $resultado = mysqli_query($conexion,$select);
        while($registro = mysqli_fetch_array($resultado,MYSQLI_ASSOC)){
            echo $registro['Id']."|";
            echo $registro['Titulo']. "|";
            echo $registro['Duracion']. "|";
            echo $registro['Img']. "|";
            echo $registro['Artista']. "|";
            echo "\n";
            $canciones = true;
        }

        if(!$canciones){
            echo"&\n";
        }else{
            echo"---\n";
        }
        //Artistas
        $select1 = "SELECT * FROM artista WHERE Nombre LIKE '$param%'";
        $resultado1 = mysqli_query($conexion,$select1);
        while($registro1 = mysqli_fetch_array($resultado1,MYSQLI_ASSOC)){
            echo $registro1['Id'] ."|";
            echo $registro1['Nombre'] . "|";
            echo $registro1['Img'];
            echo "\n";
            $artistas = true;
        }
        if(!$artistas){
            echo"&\n";
        }else{
            echo"---\n";
        }
        //Album
        $select2 = "SELECT DISTINCT c.FkAlbum AS Id, 
        (SELECT Titulo FROM album WHERE Id = c.FkAlbum) as Titulo, 
        (SELECT NOMBRE FROM artista WHERE Id = ca.FkArtista) as Artista, 
        (SELECT IMG FROM album WHERE Id = c.FkAlbum) as Img 
        FROM cancion c JOIN cancionartista ca 
        ON c.id = ca.FkCancion WHERE Titulo LIKE '$param%'";
        $resultado2 = mysqli_query($conexion,$select2);
        while($registro2 = mysqli_fetch_array($resultado2,MYSQLI_ASSOC)){
            echo $registro2['Id'] ."|";
            echo $registro2['Titulo'] . "|";
            echo $registro2['Artista'] . "|";
            echo $registro2['Img'];
            echo "\n";
            $album = true;
        }
        mysqli_close($conexion);
        if(!$album){
            echo"&\n";
        }else{
            echo"---\n";
        }
     }else{
         echo "#";
     }
?>