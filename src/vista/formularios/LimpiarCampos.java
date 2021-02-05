/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.formularios;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class LimpiarCampos {

    public LimpiarCampos() {
    }

    public void limpiarCamposTexto(JPanel panel) {
        JTextField txt;
        for (int i = 0; i < panel.getComponentCount(); i++) {
            if (panel.getComponent(i).getClass().getName().equals("javax.swing.JTextField")) {
                txt = (JTextField) panel.getComponent(i);
                txt.setText("");

            }
        }
    }

    
}
