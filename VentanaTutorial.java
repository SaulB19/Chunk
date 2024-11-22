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
import javax.swing.SwingConstants;

public class VentanaTutorial extends JFrame{
    public JPanel panelTutorial;
    public JButton BotonOK;
    
    public VentanaTutorial(){
        setDefaultCloseOperation(HIDE_ON_CLOSE);    // Escondemos la ventana para volver al menu
        setTitle("Cómo jugar:");                    // Título de la ventana
        setSize(1200, 600);                         // Tamaño (Ancho, Alto)
        setLocationRelativeTo(null);                // Fija la ventana al centro
        iniciaTutorial();
    }
    
    // Este metodo resume las instrucciones para crear la ventana 
    private void iniciaTutorial(){
        colocarPanelTutorial();
        colocarInstrucciones();
    }
    
    // Se implementa el panel donde se va a trabajar
    // Nuevamente, no requerimos de un layout específico
    private void colocarPanelTutorial(){
        panelTutorial = new JPanel();
        panelTutorial.setLayout(null);
        panelTutorial.setBackground(Color.white);
        this.add(panelTutorial);
    }
    
    // Coloca los elementos para el panel
    private void colocarInstrucciones(){
              
        // Etiqueta para instrucciones
        String texto = "TUTORIAL \n \n"
                       + ">>> Bienvenido a mi mundo de Minecraft! \n"
                       + " Este programa recrea las funcionalidades principales del mundo de Minecraft \n" 
                       + " > Usa el pico para romper piedra \n"
                       + " > Usa el hacha para romper madera \n"
                       + " > Usa la pala para romper tierra \n" 
                       + " > El bedrock no lo puedes romper! \n"
                       + " \n"
                       +  "Recuerda alternar tus herramientas y disfruta el juego! \n";
        
        JLabel Tutorial = new JLabel();
        Tutorial.setText(StrtoHtml(texto));
        Tutorial.setHorizontalAlignment(SwingConstants.CENTER);
        Tutorial.setBounds(50, 50, 800, 500);
        Tutorial.setFont(new Font("consolas", Font.BOLD, 28));
        panelTutorial.add(Tutorial);
        
        // Etiqueta de imagenes
        JLabel ImagenTutorial = new JLabel();
        ImagenTutorial.setBounds(850, 50, 200, 500);
        ImageIcon imagenT = new ImageIcon("tutorial.png");
        ImagenTutorial.setIcon(new ImageIcon(imagenT.getImage().getScaledInstance(ImagenTutorial.getWidth(), ImagenTutorial.getHeight(), Image.SCALE_SMOOTH)));
        panelTutorial.add(ImagenTutorial);
        
        // Boton para confirmar
        BotonOK = new JButton();
        BotonOK.setText("OK!");
        BotonOK.setBounds(650, 50, 120, 100);
        BotonOK.setFont(new Font("consolas", Font.BOLD, 36));
        cerrarTutorial();
        panelTutorial.add(BotonOK);
    }
    
    // Este metodo ayuda a convertir nuestro texto en un formato correcto,
    // respetando los saltos de línea.
    private String StrtoHtml(String texto){
        String cadena = texto.replace("\n", "<br>");
        return "<html><p>" + cadena + "</p></html>";
    }
    
    // Este metodo asigna un evento al BotonOk, el cual es confirmar las 
    // indicaciones y ocultar esta ventana
    private void cerrarTutorial(){
        ActionListener tutorial = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        };
        
        BotonOK.addActionListener(tutorial);
    }
    
}
