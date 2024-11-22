package com.mycompany.proyectochunk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaJuego extends JFrame{
    public JPanel panelVista, panelHerramientas, panelMundo;
    public JLabel ImagenHerramienta;
    public JButton botonPico, botonHacha, botonPala;
    public int lado = 10; 
    public int altura = 20;
    public JLabel[][] etiquetaNivel = new JLabel[lado][lado];
    public JButton[][][] botonesBloque = new JButton[altura][lado][lado];
    public int[][][] tipoBloque = new int[altura][lado][lado];
    public String herramientaActual = "Pico";
    
    public VentanaJuego(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);    // Finalizamos el programa al cerrar la ventana
        setTitle("Minecraft ver.ICO.2024");         // Título de la ventana
        setSize(780, 720);                          // Tamaño (Ancho, Alto)
        setLocationRelativeTo(null);                // Fija la ventana al centro
        setLayout(new BorderLayout(10, 10));        // Notemos que le agregamos un Layout a
                                                    // la ventana, esto se hace para acomodar
                                                    // los paneles creados correctamente
        crearMundo();
    
    }
    
    // Nuevamente tenemos un método para llenar la ventana
    // Esta vez se resume en crear los paneles y dentro de estos se hacen
    // las especificaciones de sus elementos respectivos
    private void crearMundo(){
        colocarPanelVista();
        colocarPanelHerramientas();
        colocarPanelMundo();
    }
    
    // Este panel se coloca a la derecha de la pantalla y su función es
    // mostrar la herramienta que estamos usando y una vista general del chunk
    // por los lados (solo como imagen de referencia)
    private void colocarPanelVista(){   
                
        //Este panel también tiene un Layout para acomodar correctamente ambos elementos
        panelVista = new JPanel(new BorderLayout());    
        panelVista.setBackground(Color.WHITE);
        
        // Etiqueta de herramienta actual
        // Por defecto le asignamos el pico
        ImagenHerramienta = new JLabel();
        ImagenHerramienta.setBounds(150, 50, 130, 150);
        ImageIcon imagenH = new ImageIcon("PicoSelect.png");
        ImagenHerramienta.setIcon(new ImageIcon(imagenH.getImage().getScaledInstance(ImagenHerramienta.getWidth(), ImagenHerramienta.getHeight(), Image.SCALE_SMOOTH)));
        panelVista.add(ImagenHerramienta, BorderLayout.NORTH);
        
        // Etiqueta de vista lateral del chunk (ilustrativo)
        JLabel ImagenVista = new JLabel();
        ImagenVista.setBounds(50, 500, 150, 400);
        ImageIcon imagenV = new ImageIcon("vistachunk.png");
        ImagenVista.setIcon(new ImageIcon(imagenV.getImage().getScaledInstance(ImagenVista.getWidth(), ImagenVista.getHeight(), Image.SCALE_SMOOTH)));
        panelVista.add(ImagenVista, BorderLayout.CENTER);
        
        add(panelVista, BorderLayout.EAST);   // Se acomoda a la derecha gracias al Layout     
    }
    
    // Este panel esta relacionado con el anterior pero aquí funciona con botones
    // para poder cambiar la herramienta. Aunado a esto, la imagen de la herramienta
    // actual cambia con estos.
    private void colocarPanelHerramientas(){ 
        
        // El Layout de este panel acomoda los botones centrados
        panelHerramientas = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelHerramientas.setBackground(Color.GRAY);
        
        //BOTONES DE ACCION
        botonPico = new JButton();
        botonPico.setBounds(0, 0, 50, 50);
        ImageIcon botonP = new ImageIcon("pico.png");
        botonPico.setIcon(new ImageIcon(botonP.getImage().getScaledInstance(botonPico.getWidth(), botonPico.getHeight(), Image.SCALE_SMOOTH)));
        usarPico();
        panelHerramientas.add(botonPico);
        
        botonHacha = new JButton();
        botonHacha.setBounds(0, 0, 50, 50);
        ImageIcon botonH = new ImageIcon("hacha.png");
        botonHacha.setIcon(new ImageIcon(botonH.getImage().getScaledInstance(botonHacha.getWidth(), botonHacha.getHeight(), Image.SCALE_SMOOTH)));
        usarHacha();
        panelHerramientas.add(botonHacha);
        
        botonPala = new JButton();
        botonPala.setBounds(0, 0, 50, 50);
        ImageIcon botonPa = new ImageIcon("pala.png");
        botonPala.setIcon(new ImageIcon(botonPa.getImage().getScaledInstance(botonPala.getWidth(), botonPala.getHeight(), Image.SCALE_SMOOTH)));
        usarPala();
        panelHerramientas.add(botonPala);
                
        add(panelHerramientas, BorderLayout.SOUTH);       // Se acomoda abajo gracias al Layout 
    }
    
    // Los siguientes son eventos para que el programa identifique que herramienta
    // estamos usando, a la vez que cambia la imagen de la parte superior derecha
    // con nuestra selección
    
    // Cambiar al Pico
    private void usarPico(){
        ActionListener picoSeleccionado = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon imagenNueva = new ImageIcon("PicoSelect.png");
                ImagenHerramienta.setIcon(new ImageIcon(imagenNueva.getImage().getScaledInstance(ImagenHerramienta.getWidth(), ImagenHerramienta.getHeight(), Image.SCALE_SMOOTH)));
                herramientaActual = "Pico";
            }
        };
        
        botonPico.addActionListener(picoSeleccionado);
    }
    
    // Cambiar al Hacha
    private void usarHacha(){
        ActionListener hachaSeleccionado = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon imagenNueva = new ImageIcon("HachaSelect.png");
                ImagenHerramienta.setIcon(new ImageIcon(imagenNueva.getImage().getScaledInstance(ImagenHerramienta.getWidth(), ImagenHerramienta.getHeight(), Image.SCALE_SMOOTH)));
                herramientaActual = "Hacha";
            }
        };
        
        botonHacha.addActionListener(hachaSeleccionado);
    }
    
    // Cambiar a la Pala
    private void usarPala(){
        ActionListener palaSeleccionado = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon imagenNueva = new ImageIcon("PalaSelect.png");
                ImagenHerramienta.setIcon(new ImageIcon(imagenNueva.getImage().getScaledInstance(ImagenHerramienta.getWidth(), ImagenHerramienta.getHeight(), Image.SCALE_SMOOTH)));
                herramientaActual = "Pala";
            }
        };
        
        botonPala.addActionListener(palaSeleccionado);
    }
    
    // Este es el panel más importante, aquí es expondrá el chunk visto desde
    // arriba, para ello se ocupó esencialmente de:
    // * un arreglo de botones tridimensional para usarlos como bloques
    // * un arreglo de etiquetas bidimensional para identificar el nivel de altura
    // * un arreglo similar al primero para asignar el tipo de bloque
    private void colocarPanelMundo(){ 
        
        // Esta vez omitimos el Layout, esto nos ayudará a poner botones encima de otros
        panelMundo = new JPanel();
        panelMundo.setLayout(null);
        panelMundo.setBackground(Color.GREEN);
        
        int posicionX = 0;          // Esta variables ayudarána acomodar los bloques
        int posicionY = 0;          // y las etiquetas
        int nivel=10;
        
        // Este ciclo asigna etiquetas de nivel de altura, las colocamos al inicio 
        // para evitar que los bloques lo oculten
        // Empieza en el 10, ya que por defecto es el suelo del mundo
        for (int j = 0; j < lado; j++) {
            posicionX = 0;
            for (int k = 0; k < lado; k++) {
                    crearEtiquetaNivel(nivel,j,k,posicionX,posicionY);
                    posicionX += 60;
                }
                posicionY += 60;
        }
        
        // Este ciclo agrega los botones con respecto al nivel en que nos
        // encontremos, dependiendo de la capa crea determinado bloque
        for(int i = 11; i >= 0; i--){
            posicionY = 0;
            for (int j = 0; j < lado; j++) {
                posicionX = 0;
                for (int k = 0; k < lado; k++) {
                    // CAPA DE BEDROCK
                    if(i <= 2){
                        crearBloqueBedrock(i,j,k,posicionX,posicionY);
                    }else{
                        // CAPA DE PIEDRA
                        if(i <= 6){
                            crearBloquePiedra(i,j,k,posicionX,posicionY);
                        }else{
                            // CAPA DE TIERRA
                            if(i < 10){
                                crearBloqueTierra(i,j,k,posicionX,posicionY);
                            }else{
                                // CAPA DE PASTO
                                // Actua similar a la tierra, sólo cambia la textura
                                if(i==10){
                                    crearBloquePasto(i,j,k,posicionX,posicionY);
                                }else{
                                    // CREACION DE ARBOLES
                                    // Esta adecuado para que se efectue sólo una vez,
                                    // por ello el nivel i empieza en 11
                                    if(j == 0 && k == 0){
                                        // Escoge un numero de 2 a 4
                                        int numArboles = 2 + (int)(Math.random()*10);
                                        for(int n = 0; n < numArboles; n++){
                                            // Escoge coordenadas aleatorias
                                            int columnaX = (int)(Math.random()*10);
                                            int columnaY = (int)(Math.random()*10);
                                            // Inicia con la altura del arbol 
                                            int nivelAltura = 14;
                                            // Calcula su posición
                                            posicionX = 60*columnaX;
                                            posicionY = 60*columnaY;
                                            // Nuevamente, nos adelantamos a la creación
                                            // de bloque y cambiamos el nivel de altura
                                            etiquetaNivel[columnaY][columnaX].setText(Integer.toString(nivelAltura));
                                            // Este ciclo recorre la altura asignado un bloque
                                            // verticalmente hasta llegar al suelo
                                            do{  
                                                crearBloqueMadera(nivelAltura,columnaX,columnaY,posicionX,posicionY);
                                                nivelAltura--;
                                            }while(nivelAltura > 10);
                                        }
                                    }
                                    // CREACION DE MONTAÑAS
//                                    // Esta adecuado para que se efectue sólo una vez
//                                    if(j == 0 && k == 0){
//                                        // Escoge un numero de 1 a 2
//                                        int numMountain = 1 + (int)(Math.random()*1);
//                                        for(int n = 0; n < numMountain; n++){
//                                            // Escoge coordenadas aleatorias
//                                            // Queremos que el centro este mas hacia dentro
//                                            // Por ello los valores van de 1 a 8
//                                            int columnaX = 1+(int)(Math.random()*8);
//                                            int columnaY = 1+(int)(Math.random()*8);
//                                            // Inicia con la altura de la montaña 
//                                            int nivelAltura = 12;
//                                            // Calcula su posición
//                                            posicionX = 60*columnaX;
//                                            posicionY = 60*columnaY;
//                                            // Nuevamente, nos adelantamos a la creación
//                                            // de bloque y cambiamos el nivel de altura
//                                            etiquetaNivel[columnaY][columnaX].setText(Integer.toString(nivelAltura));
//                                            // Colocamos el bloque del centro de la montaña y bajamos 
//                                            // a la siguiente capa
//                                            crearBloquePiedra(nivelAltura,columnaX,columnaY,posicionX,posicionY);
//                                            nivelAltura--;
//                                            // Este ciclo hace una capa de 3x3 de piedra
//                                            // para la montaña
//                                            int posicionaYaux = posicionY-60;
//                                            for (int fila = columnaY-1; fila <= columnaY+1; fila++) {
//                                                int posicionaXaux = posicionX-60;
//                                                for (int columna = columnaX-1; columna <= columnaX+1; columna++) {
//                                                    if(fila == columnaY && columna == columnaX){
//                                                        etiquetaNivel[fila][columna].setText(Integer.toString(nivelAltura+1));
//                                                    }else{
//                                                        etiquetaNivel[fila][columna].setText(Integer.toString(nivelAltura));
//                                                    }
//                                                    crearBloquePiedra(nivelAltura,fila,columna,posicionaXaux,posicionaYaux);
//                                                    posicionaXaux += 60;
//                                                }
//                                                posicionaYaux += 60;
//                                            }
//                                        }
//                                    }
                                
                                }
                            }
                        }
                    }
                    posicionX += 60;
                }
                posicionY += 60;
            }
        }
            
        add(panelMundo, BorderLayout.CENTER);        // Finalmente se agrega el panel
    }
    
    // Los siguientes son métodos para crear los bloques, para ello necesitan la
    // posición y sus coordenadas, recordemos que se ocupan para trabajar con 
    // arreglos. Aquí mismo se asigna el tipo de bloque.
    // En resumen, crea botones con la imágen correspondiente del bloque y se agregan.
    
    // BLOQUES DE BEDROCK (0)
    private void crearBloqueBedrock(int nivelAltura, int x, int y, int pX, int pY){
        tipoBloque[nivelAltura][x][y] = 0;
        botonesBloque[nivelAltura][x][y] = new JButton();
        botonesBloque[nivelAltura][x][y].setSize(60, 60);
        botonesBloque[nivelAltura][x][y].setLocation(pX, pY);
        ImageIcon bloque = new ImageIcon("bedrock.png");
        botonesBloque[nivelAltura][x][y].setIcon(new ImageIcon(bloque.getImage().getScaledInstance(botonesBloque[nivelAltura][x][y].getWidth(), botonesBloque[nivelAltura][x][y].getHeight(), Image.SCALE_SMOOTH)));             
        cerrarBoton(nivelAltura,x,y);
        mantenerVisible(nivelAltura,x,y);
        panelMundo.add(botonesBloque[nivelAltura][x][y]);
    }
    
    // BLOQUES DE PIEDRA (1)
    private void crearBloquePiedra(int nivelAltura, int x, int y, int pX, int pY){
        tipoBloque[nivelAltura][x][y] = 1;
        botonesBloque[nivelAltura][x][y] = new JButton();
        botonesBloque[nivelAltura][x][y].setSize(60, 60);
        botonesBloque[nivelAltura][x][y].setLocation(pX, pY);
        ImageIcon bloque = new ImageIcon("piedra.jpg");
        botonesBloque[nivelAltura][x][y].setIcon(new ImageIcon(bloque.getImage().getScaledInstance(botonesBloque[nivelAltura][x][y].getWidth(), botonesBloque[nivelAltura][x][y].getHeight(), Image.SCALE_SMOOTH)));             
        cerrarBoton(nivelAltura,x,y);
        mantenerVisible(nivelAltura,x,y);
        panelMundo.add(botonesBloque[nivelAltura][x][y]);
    }
    
    // BLOQUES DE TIERRA (2)    
    private void crearBloqueTierra(int nivelAltura, int x, int y, int pX, int pY){
        tipoBloque[nivelAltura][x][y] = 2;
        botonesBloque[nivelAltura][x][y] = new JButton();
        botonesBloque[nivelAltura][x][y].setSize(60, 60);
        botonesBloque[nivelAltura][x][y].setLocation(pX, pY);
        ImageIcon bloque = new ImageIcon("tierra.jpg");
        botonesBloque[nivelAltura][x][y].setIcon(new ImageIcon(bloque.getImage().getScaledInstance(botonesBloque[nivelAltura][x][y].getWidth(), botonesBloque[nivelAltura][x][y].getHeight(), Image.SCALE_SMOOTH)));             
        cerrarBoton(nivelAltura,x,y);
        mantenerVisible(nivelAltura,x,y);
        panelMundo.add(botonesBloque[nivelAltura][x][y]);
    }
    
    // BLOQUES DE PASTO (3)
    private void crearBloquePasto(int nivelAltura, int x, int y, int pX, int pY){
        tipoBloque[nivelAltura][x][y] = 3;
        botonesBloque[nivelAltura][x][y] = new JButton();
        botonesBloque[nivelAltura][x][y].setSize(60, 60);
        botonesBloque[nivelAltura][x][y].setLocation(pX, pY);
        ImageIcon bloque = new ImageIcon("pasto.jpg");
        botonesBloque[nivelAltura][x][y].setIcon(new ImageIcon(bloque.getImage().getScaledInstance(botonesBloque[nivelAltura][x][y].getWidth(), botonesBloque[nivelAltura][x][y].getHeight(), Image.SCALE_SMOOTH)));             
        cerrarBoton(nivelAltura,x,y);
        mantenerVisible(nivelAltura,x,y);
        panelMundo.add(botonesBloque[nivelAltura][x][y]);
    }
    
    // BLOQUES DE MADERA (4)
    private void crearBloqueMadera(int nivelAltura, int x, int y, int pX, int pY){
        tipoBloque[nivelAltura][x][y] = 4;
        botonesBloque[nivelAltura][x][y] = new JButton();
        botonesBloque[nivelAltura][x][y].setSize(60, 60);
        botonesBloque[nivelAltura][x][y].setLocation(pX, pY);
        ImageIcon bloque = new ImageIcon("madera.jpg");
        botonesBloque[nivelAltura][x][y].setIcon(new ImageIcon(bloque.getImage().getScaledInstance(botonesBloque[nivelAltura][x][y].getWidth(), botonesBloque[nivelAltura][x][y].getHeight(), Image.SCALE_SMOOTH)));             
        cerrarBoton(nivelAltura,x,y);
        mantenerVisible(nivelAltura,x,y);
        panelMundo.add(botonesBloque[nivelAltura][x][y]);
    }
    
    // Este método tiene una estructura similar a los botones de bloque pero solo
    // actúa como una matriz, la componente de altura sirve como un identificador
    private void crearEtiquetaNivel(int nivelAltura, int x, int y, int pX, int pY){
        etiquetaNivel[x][y] = new JLabel();
        etiquetaNivel[x][y].setSize(60, 60);
        etiquetaNivel[x][y].setLocation(pX, pY);
        etiquetaNivel[x][y].setText(Integer.toString(nivelAltura));
        etiquetaNivel[x][y].setForeground(Color.white);
        etiquetaNivel[x][y].setHorizontalAlignment(SwingConstants.CENTER);
        panelMundo.add(etiquetaNivel[x][y]);
    }
    
    // Este evento está asignado en todos los botones, básicamente comprueba
    // que la herramienta y los bloques sean compatibles para poder eliminarlos
    private void cerrarBoton(int i, int j, int k){
        ActionListener ocultar = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean breakable;
                switch (herramientaActual) {
                    case "Pico":
                        breakable = tipoBloque[i][j][k] == 1;
                        break;
                    case "Pala":
                        breakable = (tipoBloque[i][j][k] == 2) || (tipoBloque[i][j][k] == 3);
                        break;
                    case "Hacha":
                        breakable = tipoBloque[i][j][k] == 4;
                        break;
                    default:
                        breakable = false;
                        break;
                }
                if(breakable == true){
                    botonesBloque[i][j][k].setVisible(false);
                    if(i <= 10){
                        etiquetaNivel[j][k].setText(Integer.toString(i-1));
                    }else{
                        etiquetaNivel[k][j].setText(Integer.toString(i-1));
                    }
                }
            }
        };
        botonesBloque[i][j][k].addActionListener(ocultar);
    }
    
    // Este evento se agregó por el modo de trabajo con etiquetas (nivel de altura),
    // estas podían ocultarse sin quererlo al pasar el mouse y por esto mismo
    // este evento funciona tratando de mantener visible el nivel cuando pasemos
    // o salgamos del bloque
    private void mantenerVisible(int i, int j, int k){
        MouseListener verNivel = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                etiquetaNivel[j][k].setVisible(true);
                etiquetaNivel[j][k].setVisible(false);
                etiquetaNivel[j][k].setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                etiquetaNivel[j][k].setVisible(false);
                etiquetaNivel[j][k].setVisible(true);
            }
        };
        botonesBloque[i][j][k].addMouseListener(verNivel);
    }
}
