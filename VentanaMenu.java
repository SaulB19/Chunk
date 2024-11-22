package com.mycompany.proyectochunk;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaMenu extends JFrame{
    public JPanel panelPrincipal;
    public JLabel Presentacion;
    public JButton BotonJugar, BotonIntro;
    
    //FondoPanel fondo = new FondoPanel();
        
    public VentanaMenu(){      
        setDefaultCloseOperation(EXIT_ON_CLOSE);    // Finalizamos el programa al cerrar la ventana
        setTitle("Minecraft ver.ICO.2024");         // Título de la ventana
        setSize(1200, 600);                         // Tamaño (Ancho, Alto)
        setLocationRelativeTo(null);                // Fija la ventana al centro
        iniciarMenu();
    }
    
    // Este metodo resume las instrucciones para crear la ventana 
    private void iniciarMenu(){                 
        colocarPanel();                            
        colocarOpciones();
    }
    
    // Se implementa el panel donde se va a trabajar
    // No requerimos de un layout específico
    private void colocarPanel(){                
        panelPrincipal = new JPanel();          
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(Color.pink);
        this.add(panelPrincipal);
        
    }
    
    // Coloca los elementos para el panel
    private void colocarOpciones(){             
        // Etiqueta de imagen del nombre del juego
        Presentacion = new JLabel();
        Presentacion.setBounds(300, 50, 600, 100);
        ImageIcon imagenP = new ImageIcon("titulo.png");
        Presentacion.setIcon(new ImageIcon(imagenP.getImage().getScaledInstance(Presentacion.getWidth(), Presentacion.getHeight(), Image.SCALE_SMOOTH)));
        panelPrincipal.add(Presentacion);
        
        // Botón para empezar a jugar
        BotonJugar = new JButton();
        BotonJugar.setText("Crear mundo nuevo");
        BotonJugar.setBounds(300, 200, 600, 100);
        BotonJugar.setFont(new Font("consolas", Font.BOLD, 36));
        abrirJuego();
        panelPrincipal.add(BotonJugar);
        
        // Botón para conocer el progama o tutorial
        BotonIntro = new JButton();
        BotonIntro.setText("Tutorial");
        BotonIntro.setBounds(300, 350, 600, 100);
        BotonIntro.setFont(new Font("consolas", Font.BOLD, 36));
        abrirTutorial();
        panelPrincipal.add(BotonIntro);
    }
    
    // Este metodo asigna un evento al BotonJugar, el cual es dirigir al chunk
    // pero en una ventana nueva
    private void abrirJuego(){
        ActionListener jugar = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaJuego venJ = new VentanaJuego();
                venJ.setVisible(true);
                setVisible(false);
            }
        };
        BotonJugar.addActionListener(jugar);
    }
        
    // Este metodo asigna un evento al BotonIntro, el cual es crear 
    // una ventana de tutorial
    private void abrirTutorial(){
        ActionListener tutorial = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaTutorial venT = new VentanaTutorial();
                venT.setVisible(true);
            }
        };
        BotonIntro.addActionListener(tutorial);
    }    
}