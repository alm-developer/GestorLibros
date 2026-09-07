package org.example.databaseManager;

import java.sql.*;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/basedatosapp";
    private static final String usuario = "root";
    private static final String contrasena = "";

    public static Connection obtenerConexion() throws SQLException {
        Connection con = DriverManager.getConnection(URL,usuario,contrasena);
        return con;
    }

    public static void iniciarbd (){
        String usuarioSql = "CREATE TABLE IF NOT EXISTS USUARIOS (" +
                "idUsuario INT AUTO_INCREMENT PRIMARY KEY NOT NULL, " +
                "nombre VARCHAR(20) NOT NULL," +
                "contrasena VARCHAR(20) NOT NULL," +
                "descripcion VARCHAR(39)," +
                "librosCompletos INT," +
                "fechaRegistro DATETIME NOT NULL," +
                "ultimaConexion DATETIME NOT NULL," +
                "activo BOOLEAN NOT NULL" +
                ")";

        String grupoSql = "CREATE TABLE IF NOT EXISTS GRUPOS (" +
                "idGrupo INT AUTO_INCREMENT PRIMARY KEY NOT NULL, " +
                "nombre VARCHAR(20)," +
                "contrasena VARCHAR(20) NOT NULL," +
                "descripcion VARCHAR(100)," +
                "fechaCreacion DATETIME NOT NULL," +
                "tiempoConvivido INT," +
                "idUsuarioCreador INT NOT NULL," +
                "FOREIGN KEY (idUsuarioCreador) REFERENCES usuarios(idUsuario)" +
                ")";

        String categoriaSql = "CREATE TABLE IF NOT EXISTS CATEGORIAS (" +
                "idCategoria INT AUTO_INCREMENT PRIMARY KEY NOT NULL, " +
                "nombre VARCHAR(20) NOT NULL," +
                "descripcion VARCHAR(100)," +
                "fechaCreacion DATETIME NOT NULL," +
                "idUsuarioCreador INT NOT NULL," +
                "idGrupo INT NOT NULL," +
                "FOREIGN KEY (idUsuarioCreador) REFERENCES usuarios(idUsuario)," +
                "FOREIGN KEY (idGrupo) REFERENCES GRUPOS(idGrupo)" +
                ")";

        String bibliotecaSql = "CREATE TABLE IF NOT EXISTS BIBLIOTECAS (" +
                "idBiblioteca INT AUTO_INCREMENT PRIMARY KEY NOT NULL," +
                "nombre VARCHAR(20) NOT NULL," +
                "contrasena VARCHAR(20) NOT NULL," +
                "descripcion VARCHAR(100)," +
                "fechaCreacion DATETIME NOT NULL," +
                "idUsuarioModerador INT NOT NULL," +
                "idUsuarioCreador INT NOT NULL," +
                "idGrupo INT NOT NULL," +
                "FOREIGN KEY (idUsuarioModerador) REFERENCES USUARIOS(idUsuario)," +
                "FOREIGN KEY (idUsuarioCreador) REFERENCES USUARIOS(idUsuario)," +
                "FOREIGN KEY (idGrupo) REFERENCES GRUPOS(idGrupo)" +
                ")";

        String libroSql = "CREATE TABLE IF NOT EXISTS LIBROS (" +
                "idLibro INT AUTO_INCREMENT PRIMARY KEY NOT NULL, " +
                "titular VARCHAR(50) NOT NULL," +
                "autor VARCHAR(50) NOT NULL," +
                "descripcion VARCHAR(50)," +
                "isbn VARCHAR(50)," +
                "pagTotales INT," +
                "fechaIntroduccion DATETIME NOT NULL," +
                "fechaLeidoGrupo DATETIME," +
                "abandonado BOOLEAN NOT NULL," +
                "leidoTodos BOOLEAN NOT NULL," +
                "fechaAbandonoTotal DATETIME," +
                "estrellasTotales DOUBLE," +
                "idUsuarioCreador INT NOT NULL,"+
                "idBiblioteca INT NOT NULL," +
                "idCategoria INT NOT NULL," +
                "FOREIGN KEY (idUsuarioCreador) REFERENCES usuarios(idUsuario)," +
                "FOREIGN KEY (IdBiblioteca) REFERENCES bibliotecas(idBiblioteca)," +
                "FOREIGN KEY (idCategoria) REFERENCES categorias(idCategoria)" +
                ")";


        String usuarioGrupoSql = "CREATE TABLE IF NOT EXISTS USUARIOGRUPO (" +
                "idUsuario INT NOT NULL," +
                "idGrupo INT NOT NULL," +
                "tipoRol ENUM('ADMIN', 'MODERADOR', 'USUARIO') NOT NULL," +
                "estado ENUM('ACTIVO','BLOQUEADO') NOT NULL," +
                "PRIMARY KEY (idUsuario, idGrupo), " +
                "FOREIGN KEY (idUsuario) REFERENCES  usuarios(idUsuario)," +
                "FOREIGN KEY (idGrupo) REFERENCES  grupos(idGrupo)" +
                ")";

        String usuarioLibrosql = "CREATE TABLE IF NOT EXISTS USUARIOLIBRO (" +
                "idUsuario INT," +
                "idLibro INT," +
                "pagLeidas INT NOT NULL ," +
                "pagRestantes INT NOT NULL ," +
                "marcapaginas INT NOT NULL," +
                "leido BOOLEAN NOT NULL ," +
                "fechaLeido DATETIME," +
                "opinion VARCHAR(200)," +
                "fechaAbandono DATETIME," +
                "abandonado BOOLEAN NOT NULL ," +
                "estrellas DOUBLE," +
                "PRIMARY KEY (idUsuario,idLibro)," +
                "FOREIGN KEY (idUsuario) REFERENCES  usuarios(idUsuario)," +
                "FOREIGN KEY (idLibro) REFERENCES libros(idLibro)" +
                ")";

        try(Connection con = obtenerConexion(); Statement stmt = con.createStatement()) {

            stmt.execute(usuarioSql);
            System.out.println("Se ejecuto de manera divina la tabla usuarios");
            stmt.execute(grupoSql);
            System.out.println("Se ejecuto de manera divina la tabla grupos");
            stmt.execute(categoriaSql);
            System.out.println("Se ejecuto de manera divina la tabla categorias");
            stmt.execute(bibliotecaSql);
            System.out.println("Se ejecuto de manera divina la tabla biblioteca");
            stmt.execute(libroSql);
            System.out.println("Se ejecuto de manera divina la tabla libro");
            stmt.execute(usuarioGrupoSql);
            System.out.println("Se ejecuto de manera divina la tabla usuariogrupo");
            stmt.execute(usuarioLibrosql);
            System.out.println("Se ejecuto de manera divina la tabla usuariolibros");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
