package ar.edu.unahur.obj2.catering;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.catering.Excepciones.DescuentoInvalidoException;
import ar.edu.unahur.obj2.catering.Ofertas.Menu;
import ar.edu.unahur.obj2.catering.Ofertas.Servicio;

public class MenuTest {

    private Menu menuParrillero = new Menu("Menu parrillero", 10.0);
    private Servicio mesaDeEntradas = new Servicio("Mesa de entradas", 80_000.0);
    private Servicio parrilladaCompleta = new Servicio("Parrillada completa", 240_000.0);
    private Servicio mesaDulce = new Servicio("Mesa dulce", 60_000.0);

    private Menu packFiesta = new Menu("Pack fiesta", 5.0);
    private Servicio barraDeTragos = new Servicio("Barra de tragos", 150_000.0);
    private Servicio djYSonido = new Servicio("DJ y sonido", 120_000.0);

    private Menu eventoCompleto = new Menu("Evento completo", 20.0);
    private Servicio brindisDeBienvenida = new Servicio("Brindis de bienvenida", 50_000.0);

    
    @Test 
    public void dadoUnMenuConNombreYDescuento_alConsultarSusNombres_elResultadoEsElEsperado(){

        menuParrillero.agregarOferta(mesaDeEntradas);
        menuParrillero.agregarOferta(parrilladaCompleta);
        menuParrillero.agregarOferta(mesaDulce);

        assertEquals("Menu parrillero", menuParrillero.descripcion());
    }
    
    @Test 
    public void dadoUnMenuConNombreYDescuentoInvalido_alCrearlo_lanzaElErrorEsperado(){

        assertThrows(DescuentoInvalidoException.class,()-> new Menu("Menu parrillero", -10.0));
        assertThrows(DescuentoInvalidoException.class,()-> new Menu("Menu parrillero", 110.0));

    }

    @Test 
    public void dadoUnosMenusConNombresYDescuentos_alConsultarSusPrecios_losResultadosSonLosEsperados(){

        menuParrillero.agregarOferta(mesaDeEntradas);
        menuParrillero.agregarOferta(parrilladaCompleta);
        menuParrillero.agregarOferta(mesaDulce);

        packFiesta.agregarOferta(barraDeTragos);
        packFiesta.agregarOferta(djYSonido);

        assertEquals(342_000.0, menuParrillero.precio());
        assertEquals(256_500.0, packFiesta.precio());
    }

    @Test 
    public void dadoUnMenuParrillero_alConsultarCantidadDeServicios_elResultadoEsElEsperado(){

        menuParrillero.agregarOferta(mesaDeEntradas);
        menuParrillero.agregarOferta(parrilladaCompleta);
        menuParrillero.agregarOferta(mesaDulce);

        assertEquals(3, menuParrillero.cantidadOfertas());
    }

     @Test 
    public void dadoUnMenuParrillero_alConsultarSiIncluyeCiertoServicio_elResultadoEsElEsperado(){

        menuParrillero.agregarOferta(mesaDeEntradas);
        menuParrillero.agregarOferta(parrilladaCompleta);
        menuParrillero.agregarOferta(mesaDulce);

        assertEquals(true, menuParrillero.incluye("Parrillada completa"));
        assertEquals(false, menuParrillero.incluye("DJ y sonido"));
    }

     @Test 
    public void dadoUnMenuEventoCompletoQueContieneServiciosYMenus_alConsultarElPrecioDelEventoCompleto_elResultadoEsElEsperado(){

        menuParrillero.agregarOferta(mesaDeEntradas);
        menuParrillero.agregarOferta(parrilladaCompleta);
        menuParrillero.agregarOferta(mesaDulce);

        packFiesta.agregarOferta(barraDeTragos);
        packFiesta.agregarOferta(djYSonido);

        eventoCompleto.agregarOferta(menuParrillero);
        eventoCompleto.agregarOferta(packFiesta);
        eventoCompleto.agregarOferta(brindisDeBienvenida);



        assertEquals(518_800.0, eventoCompleto.precio());
    }

    @Test 
    public void dadoUnMenuEventoCompletoQueContieneServiciosYMenus_alConsultarCantidadDeServicios_elResultadoEsElEsperado(){

        menuParrillero.agregarOferta(mesaDeEntradas);
        menuParrillero.agregarOferta(parrilladaCompleta);
        menuParrillero.agregarOferta(mesaDulce);

        packFiesta.agregarOferta(barraDeTragos);
        packFiesta.agregarOferta(djYSonido);

        eventoCompleto.agregarOferta(menuParrillero);
        eventoCompleto.agregarOferta(packFiesta);
        eventoCompleto.agregarOferta(brindisDeBienvenida);



        assertEquals(6, eventoCompleto.cantidadOfertas());
    }

    @Test 
    public void dadoUnMenuEventoCompletoQueContieneServiciosYMenus_alConsultarSiIncluyeDjYFotografo_elResultadoEsElEsperado(){

        menuParrillero.agregarOferta(mesaDeEntradas);
        menuParrillero.agregarOferta(parrilladaCompleta);
        menuParrillero.agregarOferta(mesaDulce);

        packFiesta.agregarOferta(barraDeTragos);
        packFiesta.agregarOferta(djYSonido);

        eventoCompleto.agregarOferta(menuParrillero);
        eventoCompleto.agregarOferta(packFiesta);
        eventoCompleto.agregarOferta(brindisDeBienvenida);



        assertEquals(true, eventoCompleto.incluye("DJ y sonido"));
        assertEquals(false, eventoCompleto.incluye("Fotografo"));
    }

}
