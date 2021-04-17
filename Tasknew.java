/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesktaskarraylist;

import java.time.LocalDate;

/**
 *
 * @author luca
 */
public class Tasknew {
    
    //ATRIBUTOS
    private String descripcion;
    private boolean completado;
    private LocalDate fechaVencimiento;
    
    //CONSTRUCTORES
    public Tasknew(String descripcion, boolean completado,LocalDate fechaVencimiento) {
        this.descripcion = descripcion;
        this.completado = completado;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Tasknew(String descripcion) {
        this.descripcion = descripcion;
    }
    
    //GETS Y SETTER
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
        
    //PROCEDIMIENTOS
    //CAMBIA EL ESTADO ACTUAL AL INVERSO
    public void CambiarEstado(){
        if(this.completado){
            this.completado=false;
        }else{
            this.completado=true;
        }
    }
    
}
