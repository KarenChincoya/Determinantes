/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Listeners.DatosPanelListener;
import Listeners.TableroPanelListener;
import Model.Matriz;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Karen Velasco
 */
public class MainFrame extends JFrame {

    DatosPanel datosPanel;
    TableroPanel tableroPanel;
    Matriz matriz;
    Integer[][] data;
    String resultado;

    public MainFrame() {
        super("Cuadros magicos");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLayout(new BorderLayout());
        super.setSize(500, 500);

        datosPanel = new DatosPanel();

        datosPanel.setListener(new DatosPanelListener() {
            @Override
            public void onBtnClick() {
                tableroPanel = new TableroPanel(datosPanel.getN());
                
                MainFrame.this.add(tableroPanel);
                setVisible(true);
                
                tableroPanel.setListener(new TableroPanelListener() {
                    @Override
                    public void onBtnClick() {
                    
                        matriz = new Matriz(datosPanel.getN(), tableroPanel.getMatriz());
                        //System.out.println(matriz.Resolver());
                        resultado = "Determinante = "+matriz.Resolver();
                        
                        JOptionPane.showMessageDialog(tableroPanel, resultado, "Resultado", JOptionPane.DEFAULT_OPTION);
                        
                        tableroPanel.setVisible(false);
                    
                    }
                });
                
            }
        });
        
        
        super.add(datosPanel, BorderLayout.NORTH);
        super.setVisible(true);
    }
}
