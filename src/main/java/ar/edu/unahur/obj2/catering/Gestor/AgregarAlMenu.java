package ar.edu.unahur.obj2.catering.Gestor;

import ar.edu.unahur.obj2.catering.Ofertas.Menu;
import ar.edu.unahur.obj2.catering.Ofertas.Servicio;

/**
 * AgregarAlMenu
 */
public class AgregarAlMenu implements Operacion {

    private Menu menu;
    private Servicio servicio;

    public AgregarAlMenu(Menu menu, Servicio servicio){

        this.menu = menu;
        this.servicio = servicio;

    }

    @Override
    public void ejecutar() {
        menu.agregarOferta(servicio);
    }

    @Override
    public void deshacer() {
        menu.quitarOferta(servicio.descripcion());
    }

}
