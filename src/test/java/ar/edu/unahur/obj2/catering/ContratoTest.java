package ar.edu.unahur.obj2.catering;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.catering.Adicionales.MozosAdicionales;
import ar.edu.unahur.obj2.catering.Contratos.Contrato;
import ar.edu.unahur.obj2.catering.Ofertas.Menu;
import ar.edu.unahur.obj2.catering.Ofertas.Servicio;

public class ContratoTest {

    private Menu menuParrillero = new Menu("Menu parrillero", 10.0);
    private Servicio mesaDeEntradas = new Servicio("Mesa de entradas", 80_000.0);
    private Servicio parrilladaCompleta = new Servicio("Parrillada completa", 240_000.0);
    private Servicio mesaDulce = new Servicio("Mesa dulce", 60_000.0);

    
    @Test 
    public void dadoUnContratoConNombreOfertaYAdicional_alConsultarElImporteDelContrato_esElEsperado(){
        
        menuParrillero.agregarOferta(mesaDeEntradas);
        menuParrillero.agregarOferta(parrilladaCompleta);
        menuParrillero.agregarOferta(mesaDulce);


        Contrato contratoLucia = new Contrato("Lucia", new MozosAdicionales(menuParrillero));
        
        assertEquals(360_000.0, contratoLucia.precioReserva());

    }
    @Test 
    public void dadoUnContratoConNombreOfertaYAdicional_alConsultarLaDescripcionDeLaOferta_esElEsperado(){

        menuParrillero.agregarOferta(mesaDeEntradas);
        menuParrillero.agregarOferta(parrilladaCompleta);
        menuParrillero.agregarOferta(mesaDulce);

        Contrato contratoLucia = new Contrato("Lucia", new MozosAdicionales(menuParrillero));


        assertEquals("Menu parrillero + Mozos adicionales", contratoLucia.descripcionReserva());

    }

}
