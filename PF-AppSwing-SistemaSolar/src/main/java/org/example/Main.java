package org.example;

import org.example.controlador.ControladorSS;
import org.example.datos.SSDAO;
import org.example.ventana.VentanaSistemaSolar;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        VentanaSistemaSolar view = new VentanaSistemaSolar("Sistema Solar");
        ControladorSS controller = new ControladorSS(view);



    }
}