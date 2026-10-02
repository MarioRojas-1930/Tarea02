/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tarea02;

/**
 *
 * @author mro19
 */
public class SistemaPrestamos {

    // Creamos los arreglos
    private Equipo[] equipos = new Equipo[5];

    private int[] diasAtraso = new int[5];

    public SistemaPrestamos() {

        // Creamos los equipos y los guardamos en el arreglo
        equipos[0] = new Equipo("EQ01", "Camara DSLR", "Camara", true, 500);
        equipos[1] = new Equipo("EQ02", "Trípode", "Soporte", true, 500);
        equipos[2] = new Equipo("EQ03", "Micrófono", "Audio", true, 500);
        equipos[3] = new Equipo("EQ04", "Tableta grafica", "Diseño", true, 500);
        equipos[4] = new Equipo("EQ05", "Kit de iluminacion", "Iluminacion", true, 800);

    }

    public String consultarCatalogo() {

        String catalogo = "Catalogo de equipos\n\n";

        for (int i = 0; i < equipos.length; i++) {

            if (equipos[i] != null) {

                catalogo += "Posicion: " + (i + 1) + "\n";

                catalogo += equipos[i].infoEquipo(true);

                catalogo += "\n\n";
            }
        }

        return catalogo;
    }
    
    public String prestamos(int posicion) {

        if (posicion < 1) {
            return "Posición inválida";
        }

        if (posicion > equipos.length) {
            return "Posición inválida";
        }

        int indice = posicion - 1;

        if (equipos[indice] == null) {
            return "No hay un equipo disponible";
        }

        if (equipos[indice].isDisponible() == false) {
            return "El equipo fue prestado";
        }

        equipos[indice].prestar();

        return "Préstamo realizado correctamente.\n"
                + "Equipo: " + equipos[indice].getNombre();
    }

    public String devolucion(int posicion, int dias) {

        if (posicion < 1) {
            return "Posición inválida";
        }

        if (posicion > equipos.length) {
            return "Posición inválida";
        }

        int indice = posicion - 1;

        if (equipos[indice] == null) {
            return "No hay un equipo disponible";
        }

        if (equipos[indice].isDisponible()) {
            return "El equipo fue prestado.";
        }

        if (dias < 0) {
            return "Los dias no pueden ser negativos. Repita la accion";
        }

        diasAtraso[indice] = dias;

        int multa = equipos[indice].calcularMulta(dias);

        equipos[indice].devolver();

        return "Devolución realizada: \n\n"
                + "Equipo: " + equipos[indice].getNombre()
                + "\nDías de atraso: " + dias
                + "\nMulta: " + multa;
    }

    public String consultarMultas() {

        String resultado = "Registro de multas\n\n";

        for (int i = 0; i < equipos.length; i++) {

            if (equipos[i] != null) {

                int dias = diasAtraso[i];

                int multa = equipos[i].calcularMulta(dias);

                resultado += "Equipo: "
                        + equipos[i].getNombre() + "\n";

                resultado += "Días de atraso: "
                        + dias + "\n";

                resultado += "Multa: "
                        + multa + "\n\n";
            }
        }

        return resultado;
    }

    public String mostrarResumen() {

        int disponibles = 0;
        int prestados = 0;

        int totalDias = 0;
        int totalMultas = 0;

        for (int i = 0; i < equipos.length; i++) {

            if (equipos[i] != null) {

                if (equipos[i].isDisponible()) {
                    disponibles++;
                } else {
                    prestados++;
                }

                totalDias = totalDias + diasAtraso[i];

                int multa = equipos[i].calcularMulta(
                        diasAtraso[i]
                );

                totalMultas = totalMultas + multa;
            }
        }

        String resumen = "Sistema de prestamos\n\n";

        resumen += "Equipos disponibles: "
                + disponibles + "\n";

        resumen += "Equipos prestados: "
                + prestados + "\n";

        resumen += "Total de días de atraso: "
                + totalDias + "\n";

        resumen += "Total de multas: ₡"
                + totalMultas;

        return resumen;
    }


}// fin de la clase