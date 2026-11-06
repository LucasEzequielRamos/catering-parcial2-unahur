package ar.edu.unahur.obj2.catering.Gestor;

import ar.edu.unahur.obj2.catering.Excepciones.PrecioNegativoException;
import ar.edu.unahur.obj2.catering.Ofertas.Servicio;

/**
 * ActualizarPrecioServicio
 */
public class ActualizarPrecioServicio implements  Operacion{

    private final Servicio servicio;
    private final Double nuevoPrecio;
    private Double precioAntiguo;

    public ActualizarPrecioServicio(Servicio servicio, Double nuevoPrecio){
        this.servicio = servicio;
        this.nuevoPrecio = nuevoPrecio;
    }

    @Override
    public void ejecutar() {
         if(nuevoPrecio < 0.0) {throw new PrecioNegativoException("La tarifa no puede ser negativa");}
        precioAntiguo = servicio.precio();
        servicio.setPrecio(nuevoPrecio);
    }

    @Override
    public void deshacer() {
        servicio.setPrecio(precioAntiguo);
    }

}
