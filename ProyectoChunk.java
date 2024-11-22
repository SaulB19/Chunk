package com.mycompany.proyectochunk;

//  AUTOR: Bautista Cerón Saúl Rodrigo

public class ProyectoChunk {

    public static void main(String[] args) {
        
        // Este es nuestro método main, aquí solamente tendrá que crear
        // un objeto del tipo VentanaMenu y este nos dirigirá después al
        // juego por medio de la interfaz gráfica
        
        VentanaMenu mundoNuevo = new VentanaMenu();
        mundoNuevo.setVisible(true);
    }
}
