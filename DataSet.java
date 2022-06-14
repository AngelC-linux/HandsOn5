/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handsOn5;

/**
 *
 * @author ANGEL
 */
public class DataSet {

    double x[][] = {

        {1, 41.9, 29.1}, {1, 43.4, 29.3}, {1, 43.9, 29.5}, {1, 44.5, 29.7}, {1, 47.3, 29.9},
        {1, 47.5, 30.3}, {1, 47.9, 30.5}, {1, 50.2, 30.7}, {1, 52.8, 30.8}, {1, 53.2, 30.9}, {1, 56.7, 31.5},
        {1, 57, 31.7}, {1, 63.5, 31.9}, {1, 65.3, 32}, {1, 71.1, 32.1}, {1, 77, 32.5}, {1, 77.8, 32.9}
            
        //{1, 1, 2}, {1, 2, 4}, {1, 3, 6}, {1, 4, 8}, {1, 5, 10},
        //{1, 6, 12}, {1, 7, 14}, {1, 8, 16}, {1, 9, 18}

    };

    double y[][] = {

        {251.3}, {251.3}, {248.3}, {267.5}, {273}, {276.5}, {270.3}, {274.9}, {285}, {290},
        {297}, {302.5}, {304.5}, {309.3}, {321.7}, {330.7}, {349}
        //{101},{102},{103},{104},{105},{106},{107},{108},{109}

    };

    public double[][] getMatrizx(){

        return x;

    }

    public double[][] getMatrizy(){

        return y;

    }

}
