/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.ac.uem.projecto.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Edilson
 */
public class ConexaoM {

    public static Connection conection() {
        java.sql.Connection conectar = null;

        String driver =  "com.mysql.jdbc.Driver";

        String url = "jdbc:mysql://localhost:3306/bancoSistemaAluguer";
        String user = "root";
        String password = "";

        try {
            Class.forName(driver);
            conectar = DriverManager.getConnection(url, user, password);
            return conectar;
        } catch (Exception e) {
            return null;
        }
    }
}
