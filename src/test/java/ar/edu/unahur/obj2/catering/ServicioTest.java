package ar.edu.unahur.obj2.catering;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.catering.Excepciones.PrecioNegativoException;
import ar.edu.unahur.obj2.catering.Ofertas.Servicio;

public class ServicioTest {
    
    @Test 
    public void dadoServicioConNombreYPrecio_alConsultarSusDatos_danResultadoEsperado () {
        
        Servicio mesaDeEntrada = new Servicio("Mesa de entrada", 80_000.0);

        assertEquals("Mesa de entrada", mesaDeEntrada.descripcion());
        assertEquals(80_000.0, mesaDeEntrada.precio());

    }

    @Test 
    public void dadoServicioConNombreYPrecio_alCrearloConPrecioNegativo_daErrorEsperado () {
        
        assertThrows(PrecioNegativoException.class , () -> new Servicio("Mesa de entrada", -1.0));

    }

    

}
