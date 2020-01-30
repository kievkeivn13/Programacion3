/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labotatorio2.planilla.sueldos.matrices;

import java.util.Scanner;

/**
 *
 * @author kievk
 */
public class Labotatorio2PlanillaSueldosMatrices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    //datos empleados 
        String [][] stDatosempleados = new String [10][2];
        double [][] dbeVoaloresempleados= new double [10][16];
        
        int iOpcion=0, iContadorcolumna=0, iContadorfila=0;
        Scanner in= new Scanner(System.in);
        System.out.print("~~~~~~ SISTEMA PLANILLA DE EMPLEADOS ~~~~~~");
        // Ingreso datos de empleado 
        //ingreso Nombre 
          System.out.println("Ingrese el nombre del empleado:");
        Scanner entrada=new Scanner(System.in);
            stDatosempleados[iContadorfila][iContadorcolumna]=entrada.nextLine();
            iContadorcolumna =iContadorcolumna+1;
        //puesto empledo     
         System.out.println("Ingrese el cargo del empledao:");
         stDatosempleados[iContadorfila][iContadorcolumna]=entrada.nextLine();
         iContadorcolumna =iContadorcolumna+1;
         //
        
        
    }
    
}
