package br.com.ilegra.batchdataanalyzer;

import br.com.ilegra.batchdataanalyzer.controller.Controller;

/**
 * Class initial, process and analyzes data files with extension .dat.
 * @author Fco Jonas
 */
public class App 
{
    public static void main( String[] args )
    {
        Controller controller = new Controller();
        while(true) {
            controller.lotsProcess();
        }
    }
}
