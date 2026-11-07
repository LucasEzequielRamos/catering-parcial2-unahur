package ar.edu.unahur.obj2.catering;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.catering.Adicionales.Adicional;
import ar.edu.unahur.obj2.catering.Adicionales.MozosAdicionales;
import ar.edu.unahur.obj2.catering.Adicionales.ServicioNocturno;
import ar.edu.unahur.obj2.catering.Adicionales.VajillaPremium;
import ar.edu.unahur.obj2.catering.Ofertas.Menu;
import ar.edu.unahur.obj2.catering.Ofertas.Servicio;

public class AdicionalTest {

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
    public void dadoUnServicioMesaDeEntradas_alAplicarCadaExtra_elPrecioEsElEsperado(){

        Adicional mesaDeEntradaConMozos = new MozosAdicionales(mesaDeEntradas);
        Adicional mesaDeEntradaConServicioNocturno = new ServicioNocturno(mesaDeEntradas);
        Adicional mesaDeEntradaConVajillaPremium = new VajillaPremium(mesaDeEntradas);

        assertEquals(98_000.0, mesaDeEntradaConMozos.precio());
        assertEquals(96_000.0, mesaDeEntradaConServicioNocturno.precio());
        assertEquals(92_000.0, mesaDeEntradaConVajillaPremium.precio());

    }

    @Test 
    public void dadoUnMenuParrilleroConExtras_alConsultarDatos_sonLosEsperados(){

        menuParrillero.agregarOferta(mesaDeEntradas);
        menuParrillero.agregarOferta(parrilladaCompleta);
        menuParrillero.agregarOferta(mesaDulce);

        Adicional menuParrileroConMozosYServicioNocturno = new ServicioNocturno(new MozosAdicionales(menuParrillero));

        assertEquals(432_000.0, menuParrileroConMozosYServicioNocturno.precio());
        assertEquals("Menu parrillero + Mozos adicionales + Servicio nocturno", menuParrileroConMozosYServicioNocturno.descripcion());

    }
    
    @Test 
    public void dadoUnMenuParrilleroConExtraPorcentualInvertido_alConsultarDatos_sonLosEsperados(){

        menuParrillero.agregarOferta(mesaDeEntradas);
        menuParrillero.agregarOferta(parrilladaCompleta);
        menuParrillero.agregarOferta(mesaDulce);

        Adicional menuParrileroConMozosYServicioNocturno = new MozosAdicionales(new ServicioNocturno(menuParrillero));

        assertEquals(428_400.0, menuParrileroConMozosYServicioNocturno.precio());
        assertEquals("Menu parrillero + Servicio nocturno + Mozos adicionales", menuParrileroConMozosYServicioNocturno.descripcion());

    }

    @Test 
    public void dadoUnServicioConDobleExtra_alConsultarDatos_sonLosEsperados(){

        

        Adicional brindisDeBienvenidaConDobleExtra = new VajillaPremium(new VajillaPremium(brindisDeBienvenida));

        assertEquals(74_000.0, brindisDeBienvenidaConDobleExtra.precio());
        assertEquals("Brindis de bienvenida + Vajilla premium + Vajilla premium", brindisDeBienvenidaConDobleExtra.descripcion());

    }

    @Test 
    public void dadoUnServicioConDobleExtraPorcentual_alConsultarDatos_sonLosEsperados(){

        

        Adicional mesaDulceConDobleExtraPorcentual = new ServicioNocturno(new ServicioNocturno(mesaDulce));

        assertEquals(86_400.0, mesaDulceConDobleExtraPorcentual.precio());
        assertEquals("Mesa dulce + Servicio nocturno + Servicio nocturno", mesaDulceConDobleExtraPorcentual.descripcion());

    }

    @Test 
    public void dadoUnMenuEventoCompletoQueContieneMenusYServiciosDentro_alConsultarDatos_sonLosEsperados(){

        menuParrillero.agregarOferta(mesaDeEntradas);
        menuParrillero.agregarOferta(parrilladaCompleta);
        menuParrillero.agregarOferta(mesaDulce);

        packFiesta.agregarOferta(barraDeTragos);
        packFiesta.agregarOferta(djYSonido);

        eventoCompleto.agregarOferta(menuParrillero);
        eventoCompleto.agregarOferta(packFiesta);
        eventoCompleto.agregarOferta(brindisDeBienvenida);

        Adicional eventoCompletoConVajillaPremium = new VajillaPremium(eventoCompleto);

        assertEquals(530_800.0, eventoCompletoConVajillaPremium.precio());
        assertEquals("Evento completo + Vajilla premium", eventoCompletoConVajillaPremium.descripcion());

    }

}
