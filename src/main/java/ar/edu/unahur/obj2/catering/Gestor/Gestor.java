package ar.edu.unahur.obj2.catering.Gestor;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.catering.Excepciones.NadaParaRevertirException;

/**
 * Gestor
 */
public class Gestor {

    private final List<Operacion> operacionesPendientes = new ArrayList<Operacion>();
    private final List<Operacion> historial = new ArrayList<Operacion>();
    public Object ejecutarLote;


    public void ejecutarOperacion(Operacion operacion){
        operacion.ejecutar();
        historial.add(operacion);
    }

    public void registrarOperacion(Operacion operacion){
        operacionesPendientes.add(operacion);
    }

    public void revertirUltimaOperacion(){
         if (historial.size() < 1){
             throw new NadaParaRevertirException("No hay ninguna operacion en el historial");
         }

        Operacion ultimaOperacion = historial.reversed().getFirst();
        
        ultimaOperacion.deshacer();

        historial.remove(ultimaOperacion);
    }

    public void ejecutarLote() {
    List<Operacion> ejecutadas = new ArrayList<>();

    try {
        for (Operacion operacion : operacionesPendientes) {
            operacion.ejecutar();
            ejecutadas.add(operacion);
        }

        historial.addAll(ejecutadas);
        operacionesPendientes.clear();

    } catch (RuntimeException e) {
        for (int i = ejecutadas.size() - 1; i >= 0; i--) {
            ejecutadas.get(i).deshacer();
        }

        throw e;
    }
}

    
    
}
