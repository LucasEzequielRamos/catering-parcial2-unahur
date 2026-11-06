package ar.edu.unahur.obj2.catering.Gestor;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.catering.Excepciones.NadaParaRevertirException;

/**
 * Gestor
 */
public class Gestor {

    private final List<Operacion> operacionesPendiente = new ArrayList<Operacion>();
    private final List<Operacion> historial = new ArrayList<Operacion>();


    public void ejecutarOperacion(Operacion operacion){
        operacion.ejecutar();
        historial.add(operacion);
    }

    public void registrarOperacion(Operacion operacion){
        operacionesPendiente.add(operacion);
    }

    public void revertirUltimaOperacion(){
         if (historial.size() < 1){
             throw new NadaParaRevertirException("No hay ninguna operacion en el historial");
         }

        Operacion ultimaOperacion = historial.reversed().getFirst();
        
        ultimaOperacion.deshacer();

        historial.remove(ultimaOperacion);
    }

    
    
}
