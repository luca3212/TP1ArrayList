/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesktaskarraylist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author luca
 */
public class TeskTaskArrayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Metodo de ingreso de datos por el usuario
        Scanner leer = new Scanner(System.in);
        
        //DECLARO EL ARRAYLIST
        ArrayList<Tasknew> lista = new ArrayList<Tasknew>();
                       
        System.out.println("*   *   *   *   *   BIENVENIDO   *   *   *   *   *");
        
        //DECLARACION DE VARIABLE
        String DESCRIP;
        boolean ESTADO;
        String fechaIngresada;
        
        int menu=-1;
        while(menu!=0){
            System.out.println("MENU PRINCIPAL");
            System.out.println("OPCION 1 - AGREGAR UNA TAREA");
            System.out.println("OPCION 2 - VER LISTADO DE TAREAS");
            System.out.println("OPCION 3 - MODIFICAR O ELIMINAR UNA TAREA");
            System.out.println("OPCION 0 - FINALIZAR");
            
            System.out.print("INGRESE EL NUMERO DE OPCION: ");
            menu = leer.nextInt();
            
            if(menu!=0){
                
                switch(menu){
                    case 1:
                        System.out.println("\n  *   *   *   *   *   AGREGAR TAREA   *   *   *   *   *");
                        
                        //PEDIMOS AL USUARIO QUE INGRESE LOS DATOS DE LA TAREA
                        System.out.print("INGRESE LA DESCRIPCION DE LA TAREA: ");
                        DESCRIP = leer.next();
                        System.out.print("INGRESE EL ESTADO DE LA TAREA (TRUE/FALSE): ");
                        ESTADO = leer.nextBoolean();
                        System.out.print("FECHA LIMITE PARA COMPLETAR LA TAREA (FORMATO: AAAA/MM/DD): ");
                        fechaIngresada = leer.next();
                            
                        //DIVIDO EL STRING DE FECHA EN PARTES                        
                        String fechaArray[] = fechaIngresada.split("/"); 
                                                       
                        //CONVIERTE Y ASIGNA LOS STRING AL INT QUE CORRESPONDA
                        int anio = Integer.parseInt(fechaArray[0]);
                        int mes = Integer.parseInt(fechaArray[1]);
                        int dia = Integer.parseInt(fechaArray[2]);
                            
                        //GUARDAMOS LOS DATOS
                        Tasknew Tareas = new Tasknew(DESCRIP,ESTADO, LocalDate.of(anio, mes, dia) );
                        //GUARDO EN LA LISTA EL OBJETO
                        lista.add(Tareas);
                                                        
                        //CONFIRMACION DE DATOS GUARDADOS
                        System.out.println("\n  LA TAREA FUE REGISTRADA CON EXITO");
                        System.out.println("\n  *   *   *   *   *   *   *   *   *   *   *   *   *   * \n");
                            
                        break;
                    case 2:
                        System.out.println("\n  *   *   *   *   *   LISTADO DE TAREAS    *   *   *   *   *");
                        int contador=0;
                        //DEVUELVE TRUE SI LA LISTA ESTA VACIA 
                        if(lista.isEmpty()!= true){
                            
                            //RECORRO LA LISTA
                            Iterator<Tasknew> it = lista.iterator();
                            while(it.hasNext()){
                                Tasknew tareas= it.next();
                                contador++;
                                //MUESTRA LA DESCRIPCION DE LA TAREA GUARDADA
                                System.out.println("\n  N° "+contador+" - DESCRIPCION: "+tareas.getDescripcion());
                            }
                            
                        }else{
                            System.out.println("\n  NO SE ENCONTRARON TAREAS REGISTRADAS");
                        }
                        System.out.println("\n  *   *   *   *   *   *   *   *   *   *   *   *   *   *   * \n");
                                                                       
                        break;
                    case 3:
                        System.out.println("\n  *   *   *   *   *   BUSCAR TAREA   *   *   *   *   *");
                        contador=0;
                        //DEVUELVE TRUE SI LA LISTA ESTA VACIA 
                        if(lista.isEmpty()!= true){
                            
                            //RECORRO LA LISTA
                            Iterator<Tasknew> it = lista.iterator();
                            while(it.hasNext()){
                                Tasknew tareas= it.next();
                                contador++;
                                //MUESTRA LA DESCRIPCION DE LA TAREA GUARDADA
                                System.out.println("\n  N° "+contador+" - DESCRIPCION: "+tareas.getDescripcion());
                            }
                            
                            //ELEGIR TAREA A MODIFICAR O ELIMINAR
                            int opcion;
                            System.out.print("\n  INGRESE EL NUMERO DE TAREA A MODIFICAR O ELIMINAR (0 PARA VOLVER AL MENU): ");
                            opcion = leer.nextInt();
                            
                            if(opcion<=lista.size() && opcion>=0){
                                if(opcion!=0){
                                    //MOSTRAMOS LOS DATOS DE LA TAREA SELECCIONADA
                                    System.out.println("\n  N° "+opcion+" - DESCRIPCION:        "+lista.get(opcion-1).getDescripcion());
                                    System.out.println("        -   TAREA COMPLETA?   "+lista.get(opcion-1).isCompletado());
                                    System.out.println("        -   FECHA LIMITE:     "+lista.get(opcion-1).getFechaVencimiento());
                                     
                                        //MENU DE MODIFICACIONES A LA TAREA SELECCIONADA
                                        int opcion1;
                                        System.out.println("\n    OPCION 1 - MODIFICAR EL ESTADO DE LA TAREA");
                                        System.out.println("    OPCION 2 - ELIMINAR TAREA");
                                        System.out.println("    OPCION 0 - VOLVER AL MENU");
                                        System.out.print("    SELECCIONE UNA OPCION: ");
                                        opcion1 = leer.nextInt();
                                        
                                        if(opcion1==1){
                                            //CAMBIAMOS EL ESTADO DE LA TAREA
                                            lista.get(opcion-1).CambiarEstado();
                                            
                                            //MOSTRAMOS LOS DATOS DE LA TAREA SELECCIONADA
                                            System.out.println("\n  N° "+opcion+" - DESCRIPCION:        "+lista.get(opcion-1).getDescripcion());
                                            System.out.println("        -   TAREA COMPLETA?   "+lista.get(opcion-1).isCompletado());
                                            System.out.println("        -   FECHA LIMITE:     "+lista.get(opcion-1).getFechaVencimiento());
                                            
                                            System.out.println("\n  LA MODIFICACION FUE REALIZADA CON EXITO.");
                                            System.out.println("\n  *   *   *   *   *   *   *   *   *   *   *   *   *   * \n");
                                        }
                                        if(opcion1==2){
                                            //ELIMINAMOS LOS DATOS REGISTRADOS EN LA ACTIVIDAD
                                            lista.remove(opcion-1);
                                            System.out.println("\n  LA TAREA FUE ELIMINADA CON EXITO.");
                                            System.out.println("\n  *   *   *   *   *   *   *   *   *   *   *   *   *   * \n");
                                        }
                                    
                                }
                            }else{
                                System.out.println("\n  LA OPCION INGRESA ES INVALIDA.");
                                System.out.println("\n  *   *   *   *   *   *   *   *   *   *   *   *   *   * \n");
                            }
                            
                            
                        }else{
                            System.out.println("\n  NO SE ENCONTRARON TAREAS REGISTRADAS");
                            System.out.println("\n  *   *   *   *   *   *   *   *   *   *   *   *   *   *   * \n");
                        }
                        break;
                }
            }
        }
    }
    
}
