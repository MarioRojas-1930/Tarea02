/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tarea02;

/**
 *
 * @author mro19
 */
public class Equipo {
    
    
    //Atributos privados: codigo, nombre, tipo, disponible y tarifaMulta.
    private String codigo;
    private String nombre;
    private String tipo;
    private boolean disponible;
    private int tarifaMulta;

    
    //Un constructor que reciba los datos necesarios. Todo equipo inicia disponible.

    public Equipo(String codigo, String nombre, String tipo, boolean disponible, int tarifaMulta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.disponible = true;
        this.tarifaMulta = tarifaMulta;
    }

    public Equipo() {
    }
    
    
    
    //Métodos de get y set de los atributos
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public double getTarifaMulta() {
        return tarifaMulta;
    }

    public void setTarifaMulta(int tarifaMulta) {
        if(tarifaMulta >= 0)
        {
        this.tarifaMulta = tarifaMulta;
        }
    }
    
    //Métodos prestar() y devolver() para modificar el estado del objeto
    public void prestar() {
      disponible=false;
    }
    
    public void devolver() {
      disponible=true; 
    }
    
    public String infoEquipo() {
    String estado;
    
    if(disponible) {
        
       estado= "Disponible";
    }else {
        
        estado = "Prestado";
    }
    
    return "Codigo: " + codigo
           + "\nNombre: " + nombre
           + "\nTipo: " + tipo
           + "\nEstado: " + estado;
           
    
  }//Fin del InfoEquipo
    
    //Un método con retorno de tipo String para construir la información del equipo.
    public String infoEquipo(boolean mostrarTarifa){
        
        String informacion = infoEquipo();
        
        if(mostrarTarifa){
            informacion += "Multa diaria: " + tarifaMulta;
        }
        return informacion;
    }
    
    
    //Método de multa, que por día de atraso de suma 500 colones por día.
     public int calcularMulta(int diasAtraso) {
         
         if(diasAtraso < 0) {
             return 0;
         }
         
         int multa = diasAtraso * tarifaMulta;
         
         return multa;
     }
}//fin de la clase Equipo
