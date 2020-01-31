
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kievk
 */
public class Labotatorio2PlanillaSueldosMatrices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            String[][] stDatos=new String[11][1000];
        double[][] dbValores=new double[11][1000];
        int iContadorFilaDatos=0, iContadorFilaValores=0, iContadorColumnaDatos=0, iContadorColumnaValores=0;
        double dbSueldoBase=0, dbSueldoExtra=0, dbBonificacion=0, dbComisiones=0, dbIgss=0, dbIsr=0, dbSueldoBruto=0;
        double dbSueldoAnual=0, dbBonificacionAnual=0, dbIgssAnual=0, dbIsrAnual=0;
        double dbIngresoAnual=0, dbDescuentoAnual=0, dbRentaBruta=0;
        double dbDescuentosJ=0, dbAnticipos=0;
        double dbTotalDescuentos=0, dbTotalLiquido=0;
        String stNombre="", stPuesto="";
        
        Scanner in=new Scanner(System.in);
        System.out.println("--- SISTEMA PLANILLA DE SUELDOS ---");
        System.out.println("");
        for(int x=0;x<11;x++){
            //INGRESO NOMBRE
           System.out.println("\t--- Ingreso de datos ---\n");
        System.out.println("Ingrese el nombre del empleado:");
        stNombre=in.nextLine();
        stDatos[iContadorFilaDatos][iContadorColumnaDatos]="Nombre: "+String.valueOf(stNombre);
        iContadorColumnaDatos=iContadorColumnaDatos+1;
        
        //INGRESO DEL PUESTO
        System.out.println("Ingrese el puesto del empleado:");
        stPuesto=in.nextLine();
        stDatos[iContadorFilaDatos][iContadorColumnaDatos]="Puesto: "+String.valueOf(stPuesto);
        iContadorColumnaDatos=iContadorColumnaDatos+1;
        //INGRESO SUELDO
        while(dbSueldoBase<2800){   
        System.out.println("Ingrese el sueldo del empleado:");
        dbSueldoBase=in.nextDouble();in.nextLine();
        dbValores[iContadorFilaValores][iContadorColumnaValores]=dbSueldoBase;                
        stDatos[iContadorFilaDatos][iContadorColumnaDatos]="Sueldo Base: "+String.valueOf(dbSueldoBase);
        }
        iContadorColumnaValores=iContadorColumnaValores+1;
        iContadorColumnaDatos=iContadorColumnaDatos+1;
        
        //INGRESO SUELDO EXTRAORDINARIO
         System.out.println("Ingrese el sueldo extraordinario del empleado:");
         dbSueldoExtra=in.nextDouble();in.nextLine();
        dbValores[iContadorFilaValores][iContadorColumnaValores]=dbSueldoExtra;
        stDatos[iContadorFilaDatos][iContadorColumnaDatos]="Sueldo Extraordinario: "+String.valueOf(dbSueldoExtra);
        iContadorColumnaValores=iContadorColumnaValores+1;
        iContadorColumnaDatos=iContadorColumnaDatos+1;
        
        //INGRESO BONIFICACION
        while(dbBonificacion!=250){
        System.out.println("Ingrese la bonificacion del empleado:");
        dbBonificacion=in.nextDouble();in.nextLine();
        dbValores[iContadorFilaValores][iContadorColumnaValores]=dbBonificacion;
        stDatos[iContadorFilaDatos][iContadorColumnaDatos]="Bonificacion Incentivo: "+String.valueOf(dbBonificacion);
        }
        iContadorColumnaValores=iContadorColumnaValores+1;
        iContadorColumnaDatos=iContadorColumnaDatos+1;
        
        //INGRESO DE COMISIONES
         System.out.println("Ingrese las comisiones del empleado:");
         dbComisiones=in.nextDouble();in.nextLine();
        dbValores[iContadorFilaValores][iContadorColumnaValores]=dbComisiones;        
         stDatos[iContadorFilaDatos][iContadorColumnaDatos]="Comisiones: "+String.valueOf(dbComisiones);
        iContadorColumnaValores=iContadorColumnaValores+1;
        iContadorColumnaDatos=iContadorColumnaDatos+1;
        
        //CALCULO SUELDO BRUTO
        dbSueldoBruto=dbSueldoBase+dbSueldoExtra+dbBonificacion+dbComisiones;
        dbValores[iContadorFilaValores][iContadorColumnaValores]=dbSueldoBruto;
        stDatos[iContadorFilaDatos][iContadorColumnaDatos]="Sueldo Devengado: "+String.valueOf(dbSueldoBruto);
        iContadorColumnaValores=iContadorColumnaValores+1;
        iContadorColumnaDatos=iContadorColumnaDatos+1;
       
        //CALCULO IGSS
        dbIgss=dbSueldoBase*0.0438;
        dbValores[iContadorFilaValores][iContadorColumnaValores]=dbIgss;
        stDatos[iContadorFilaDatos][iContadorColumnaDatos]="IGSS: "+String.valueOf(dbIgss);
        iContadorColumnaValores=iContadorColumnaValores+1;
        iContadorColumnaDatos=iContadorColumnaDatos+1;
        
        //CALCULO ISR
            //ingresos
        if(dbSueldoBase<6000){
        dbIsr=0;
        dbValores[iContadorFilaValores][iContadorColumnaValores]=dbIsr;
        stDatos[iContadorFilaDatos][iContadorColumnaDatos]="ISR: "+String.valueOf(dbIsr);
        iContadorColumnaValores=iContadorColumnaValores+1;
        iContadorColumnaDatos=iContadorColumnaDatos+1;
        }
        else
        if(dbSueldoBase>6000||dbSueldoBase<7500){
        dbSueldoAnual=dbSueldoBase*12;
        dbBonificacionAnual=dbBonificacion*12;
        dbIngresoAnual=dbSueldoAnual+dbBonificacionAnual;
            //descuentos
        dbIgssAnual=dbIgss*12;
        dbDescuentoAnual=dbIgssAnual+48000;
        
        dbRentaBruta=dbIngresoAnual-dbDescuentoAnual;
        dbIsrAnual=dbRentaBruta*0.05;
        
        dbIsr=dbIsrAnual/12;
        dbValores[iContadorFilaValores][iContadorColumnaValores]=dbIsr;
        stDatos[iContadorFilaDatos][iContadorColumnaDatos]="ISR: "+String.valueOf(dbIsr);
        iContadorColumnaValores=iContadorColumnaValores+1;
        iContadorColumnaDatos=iContadorColumnaDatos+1;
        }
        else
            if(dbSueldoBase>79000){
        dbSueldoAnual=dbSueldoBase*12;
        dbBonificacionAnual=dbBonificacion*12;
        dbIngresoAnual=dbSueldoAnual+dbBonificacionAnual;
            //descuentos
        dbIgssAnual=dbIgss*12;
        dbDescuentoAnual=dbIgssAnual+48000;
        
        dbRentaBruta=dbIngresoAnual-dbDescuentoAnual;
        dbIsrAnual=dbRentaBruta*0.06;
        
        dbIsr=dbIsrAnual/12;
        dbValores[iContadorFilaValores][iContadorColumnaValores]=dbIsr;
        stDatos[iContadorFilaDatos][iContadorColumnaDatos]="ISR: "+String.valueOf(dbIsr);
        iContadorColumnaValores=iContadorColumnaValores+1;
        iContadorColumnaDatos=iContadorColumnaDatos+1;
        }
        else
            if(dbSueldoBase>6000&&dbSueldoBase<7500){
        dbSueldoAnual=dbSueldoBase*12;
        dbBonificacionAnual=dbBonificacion*12;
        dbIngresoAnual=dbSueldoAnual+dbBonificacionAnual;
            //descuentos
        dbIgssAnual=dbIgss*12;
        dbDescuentoAnual=dbIgssAnual+48000;
        
        dbRentaBruta=dbIngresoAnual-dbDescuentoAnual;
        dbIsrAnual=dbRentaBruta*0.08;
        
        dbIsr=dbIsrAnual/12;
        dbValores[iContadorFilaValores][iContadorColumnaValores]=dbIsr;
        stDatos[iContadorFilaDatos][iContadorColumnaDatos]="ISR: "+String.valueOf(dbIsr);
        iContadorColumnaValores=iContadorColumnaValores+1;
        iContadorColumnaDatos=iContadorColumnaDatos+1;
            }
        
        //INGRESO DESCUENTOS JUDICIALES
         System.out.println("Ingrese los descuentos judiciales del empleado: ");
        dbDescuentosJ=in.nextDouble();in.nextLine();
        dbValores[iContadorFilaValores][iContadorColumnaValores]=dbDescuentosJ;
        stDatos[iContadorFilaDatos][iContadorColumnaDatos]="Descuentos Judiciales: "+String.valueOf(dbDescuentosJ);
        iContadorColumnaValores=iContadorColumnaValores+1;
        iContadorColumnaDatos=iContadorColumnaDatos+1;
        
        //INGRESO ANTICIPOS CONDEDIDOS
        System.out.println("Ingrese los anticipos concedidos al empleado:");
        dbAnticipos=in.nextDouble();in.nextLine();
        dbValores[iContadorFilaValores][iContadorColumnaValores]=dbAnticipos;
        stDatos[iContadorFilaDatos][iContadorColumnaDatos]="Anticipos Concedidos: "+String.valueOf(dbAnticipos);
        iContadorColumnaValores=iContadorColumnaValores+1;
        iContadorColumnaDatos=iContadorColumnaDatos+1;
        
        //CALCULO TOTAL DESCUENTOS
        dbTotalDescuentos=dbIgss+dbIsr+dbDescuentosJ+dbAnticipos;
        dbValores[iContadorFilaValores][iContadorColumnaValores]=dbTotalDescuentos;
        stDatos[iContadorFilaDatos][iContadorColumnaDatos]="Total Descuentos: "+String.valueOf(dbTotalDescuentos);
        iContadorColumnaValores=iContadorColumnaValores+1;
        iContadorColumnaDatos=iContadorColumnaDatos+1;
        
        //CALCULO TOTAL LIQUIDO
        stDatos[iContadorFilaDatos][iContadorColumnaDatos]="Total Liquido: "+String.valueOf(dbTotalLiquido);
        iContadorColumnaValores=iContadorColumnaValores+1;
        iContadorColumnaDatos=iContadorColumnaDatos+1;

        x++;
        iContadorFilaValores=iContadorFilaValores+1;
        iContadorFilaDatos=iContadorFilaDatos+1;
      //  System.out.println("");
      //  System.out.println("");
        dbSueldoBase=0;
        dbBonificacion=0;
        //in.nextLine();
        }        
        
        //IMPRESION DE DATOS
         //System.out.print(iContadorColumnaValores + iContadorFilaValores);
         // System.out.print(iContadorColumnaDatos + iContadorFilaDatos);
        // System.out.print("");
         System.out.println("\n--- DATOS DE LOS EMPLEADOS INGRESADOS---\n");
        for(int i=0;i<iContadorFilaDatos;i++){
            System.out.println("\tEMPLEADO INGRESADO #"+(i+1)); 
            for(int j=0;j<iContadorColumnaDatos;j++){
               System.out.println("");
                System.out.println(stDatos[i][j]);
                
            }
          
        }
    }
}