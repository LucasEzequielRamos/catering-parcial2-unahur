package ar.edu.unahur.obj2.catering;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.catering.Excepciones.NadaParaRevertirException;
import ar.edu.unahur.obj2.catering.Gestor.ActualizarPrecioServicio;
import ar.edu.unahur.obj2.catering.Gestor.AgregarAlMenu;
import ar.edu.unahur.obj2.catering.Gestor.Gestor;
import ar.edu.unahur.obj2.catering.Gestor.Operacion;
import ar.edu.unahur.obj2.catering.Gestor.QuitarDelMenu;
import ar.edu.unahur.obj2.catering.Ofertas.Menu;
import ar.edu.unahur.obj2.catering.Ofertas.Servicio;

public class GestorTest {

    private Menu menuParrillero = new Menu("Menu parrillero", 10.0);
    private Servicio mesaDeEntradas = new Servicio("Mesa de entradas", 80_000.0);
    private Servicio parrilladaCompleta = new Servicio("Parrillada completa", 240_000.0);
    private Servicio mesaDulce = new Servicio("Mesa dulce", 60_000.0);

    // private Menu packFiesta = new Menu("Pack fiesta", 5.0);
    // private Servicio barraDeTragos = new Servicio("Barra de tragos", 150_000.0);
    // private Servicio djYSonido = new Servicio("DJ y sonido", 120_000.0);

    // private Menu eventoCompleto = new Menu("Evento completo", 20.0);
    // private Servicio brindisDeBienvenida = new Servicio("Brindis de bienvenida", 50_000.0);

    private Gestor gestor = new Gestor();

    @Test
    public void dadoUnGestorYUnMenuParrillero_alAplicarCadaCambio_seRecibeElResultadoEsperado(){

        Servicio fotografo = new Servicio("Fotografo", 100_000.0);


        menuParrillero.agregarOferta(mesaDeEntradas);
        menuParrillero.agregarOferta(parrilladaCompleta);
        menuParrillero.agregarOferta(mesaDulce);

        assertEquals(342_000.0, menuParrillero.precio());

        Operacion agregarOfertaAlMenu = new AgregarAlMenu(menuParrillero,fotografo);
        
        gestor.ejecutarOperacion(agregarOfertaAlMenu);

        assertEquals(432_000.0, menuParrillero.precio());

        Operacion actualizarPrecioParrilladaCompleta = new ActualizarPrecioServicio(parrilladaCompleta, 260_000.0);

        gestor.ejecutarOperacion(actualizarPrecioParrilladaCompleta);

        assertEquals(450_000.0, menuParrillero.precio());

        Operacion quitarMesaDulceDelMenu = new QuitarDelMenu(menuParrillero, mesaDulce);

        gestor.ejecutarOperacion(quitarMesaDulceDelMenu);

        assertEquals(396_000.0, menuParrillero.precio());

        gestor.revertirUltimaOperacion();

        assertEquals(450_000.0, menuParrillero.precio());
        
        gestor.revertirUltimaOperacion();

        assertEquals(432_000.0, menuParrillero.precio());
        
        gestor.revertirUltimaOperacion();

        assertEquals(342_000.0, menuParrillero.precio());

        assertThrows(NadaParaRevertirException.class, ()-> gestor.revertirUltimaOperacion());

    }


    @Test
    public void dadoUnGestorYUnServicioParrilladaCompletaConDosCambios_alRevertirAmbosCambios_losResultadosSonLosEsperados(){

       gestor.ejecutarOperacion(new ActualizarPrecioServicio(parrilladaCompleta, 260_000.0));
       gestor.ejecutarOperacion(new ActualizarPrecioServicio(parrilladaCompleta, 300_000.0));

        assertEquals(300_000.0, parrilladaCompleta.precio());

        gestor.revertirUltimaOperacion();

        assertEquals(260_000.0, parrilladaCompleta.precio());

        gestor.revertirUltimaOperacion();

        assertEquals(240_000.0, parrilladaCompleta.precio());

    }

    @Test
    public void dadoUnGestorYUnMenuParrillero_alProgramarUnLoteEjecutarloYRevertirlo_losResultadosSonLosEsperados(){

        menuParrillero.agregarOferta(mesaDeEntradas);
        menuParrillero.agregarOferta(parrilladaCompleta);
        menuParrillero.agregarOferta(mesaDulce);

        Servicio fotografo = new Servicio("Fotografo", 100_000.0);

        Operacion agregarOfertaAlMenu = new AgregarAlMenu(menuParrillero,fotografo);
        
        gestor.registrarOperacion(agregarOfertaAlMenu);

        Operacion actualizarPrecioParrilladaCompleta = new ActualizarPrecioServicio(parrilladaCompleta, 260_000.0);

        gestor.registrarOperacion(actualizarPrecioParrilladaCompleta);

        Operacion quitarMesaDulceDelMenu = new QuitarDelMenu(menuParrillero, mesaDulce);

        gestor.registrarOperacion(quitarMesaDulceDelMenu);


    }


}
