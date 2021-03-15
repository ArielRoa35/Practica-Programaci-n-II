package Ventana;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Ventana extends JFrame{
    
    public JPanel panel;
    
    public Ventana(){
        
        setSize(500, 500);
        setTitle("El mejor título");
        setLocationRelativeTo(null); //Centro de la pantalla.
        
        // setResizable(false); Reducible o no.
        setMinimumSize(new Dimension(200, 200));
        
        getContentPane().setBackground(Color.blue);
    
        iniciarComponentes();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void iniciarComponentes(){
        
        colocarPaneles();
        //colocarEtiquetas();
        //colocarBotones();
        //colocarRadioBotones();
        //colocarCajasDeTexto();
        //colocarAreasDeTexto();
        colocarListasDesplegables();
        
    }
    
    private void colocarPaneles(){
        
        panel = new JPanel(); //Creación del panel.
        //panel.setBackground(Color.green);
        panel.setLayout(null);
        
        this.getContentPane().add(panel);
    }
    
    private void colocarEtiquetas(){
        
        //Etiqueta 1 - etiqueta de texto.
        JLabel etiqueta = new JLabel("Fursona", SwingConstants.CENTER);
        //etiqueta.setOpaque(true); //Permiso para pintar el fondo de la etiqueta.
        etiqueta.setBounds(85, 10, 300, 80);//Eje "X", eje "Y", ancho y largo.
        etiqueta.setForeground(Color.black);
        //etiqueta.setBackground(Color.black);
        etiqueta.setFont(new Font("Cooper black", 0 , 40));//#3 es cursiva y negrita.
        
        panel.add(etiqueta);
        
        //Etiqueta 2 - etiqueta de imagen.
        ImageIcon imagen = new ImageIcon("pp,550x550.u1.jpg");
        JLabel etiqueta2 = new JLabel();
        etiqueta2.setBounds(80, 90, 300, 300);
        etiqueta2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta2.getWidth(), etiqueta2.getHeight(), Image.SCALE_AREA_AVERAGING)));
        
        panel.add(etiqueta2);
    }
    
    private void colocarBotones(){
        
        //Botón 1 - botón de texto.
        JButton boton1 = new JButton("Click");
        boton1.setBounds(100, 100, 100, 40);
        boton1.setEnabled(true); //Deshabilitar y habilitar.
        boton1.setMnemonic('a'); //Shift + "a" es igual a tocar el botón.
        boton1.setForeground(Color.blue);
        boton1.setFont(new Font("cooper black", 3, 20));
        
        panel.add(boton1);
        
        //Botón 2 - botón de imagen.
        JButton boton2 = new JButton();
        boton2.setBounds(100, 200, 100, 40);
        //boton2.setBackground(Color.blue);
        
        ImageIcon encender = new ImageIcon("boton.png");
        boton2.setIcon(new ImageIcon(encender.getImage().getScaledInstance(boton2.getWidth(), boton2.getWidth(), Image.SCALE_SMOOTH)));
        
        panel.add(boton2);
    }
    
    private void colocarRadioBotones(){
        
        JRadioButton radioBoton1 = new JRadioButton("Opción 1", true);
        radioBoton1.setBounds(50, 100, 200, 50);
        radioBoton1.setEnabled(true);
        radioBoton1.setText("Programación.");
        radioBoton1.setFont(new Font("cooper black", 0, 20));
        
        panel. add(radioBoton1);
        
        JRadioButton radioBoton2 = new JRadioButton("Opción 2", false);
        radioBoton2.setBounds(50, 150, 100, 50); 
        
        panel. add(radioBoton2);
        
        JRadioButton radioBoton3 = new JRadioButton("Opción 3", false);
        radioBoton3.setBounds(50, 200, 100, 50); 
        
        panel. add(radioBoton3);
        
        ButtonGroup grupoRadioBotones = new ButtonGroup();
        grupoRadioBotones.add(radioBoton1);
        grupoRadioBotones.add(radioBoton2);
        grupoRadioBotones.add(radioBoton3);
    }
    
    private void colocarCajasDeTexto(){
        
        JTextField cajaTexto = new JTextField("Hola...");
        cajaTexto.setBounds(50, 50, 100, 30);
        
        panel.add(cajaTexto);
    }
    
    private void colocarAreasDeTexto(){
        
        JTextArea areaTexto = new JTextArea("Ingrese el texto aquí...");
        areaTexto.setBounds(20, 20, 300, 200);
        areaTexto.setEditable(true); //Habilitar edición de texto.
        
        panel.add(areaTexto);
    }
    
    private void colocarListasDesplegables(){
        
        String [] paises = {"Niggaragua", "Niggarica", "Nigganama", "Niggajeria"};
        JComboBox listaDesplegable = new JComboBox(paises);
        listaDesplegable.setBounds(20, 20, 100, 30);
        
        listaDesplegable.addItem("Niggargentina");
        listaDesplegable.setSelectedItem("Niggargentina");
        
        panel.add(listaDesplegable);
    }
}
