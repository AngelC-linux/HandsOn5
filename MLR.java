/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handsOn5;

import javax.swing.JOptionPane;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

/**
 *
 * @author ANGEL
 */
public class MLR extends Agent {
    
     HelperArithmetic HA = new HelperArithmetic();

    boolean I = HA.DoMLR();

    double[][] producto = HA.getProducto();

    public void displayRegressioEquation(){

        System.out.println("Regression Equation B0 + B1x1 + B2x2");

    }

    public double predict(){

        double x1 = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingresa El Valor De X1: "));
        double x2 = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingresa El Valor De X2: "));

        double predict = (producto[0][0] + (producto[1][0] * x1) + (producto[2][0] * x2));

        System.out.println("Predict: " + predict);

        return predict;

    }




//LLAMANDO AL AGENTE 




 @Override
    protected void setup() {

        System.out.println("Agent "+getLocalName()+" started.");
        addBehaviour(new MyOneShotBehaviour());

    }

    private class MyOneShotBehaviour extends OneShotBehaviour {

        @Override
        public void action() {

            MLR MR = new MLR();

            MR.displayRegressioEquation();
            MR.predict();

        }

        @Override
        public int onEnd() {

            myAgent.doDelete();
            return super.onEnd();

        }

    }

}