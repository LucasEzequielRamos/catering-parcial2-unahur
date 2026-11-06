package ar.edu.unahur.obj2.catering.Gestor;

import ar.edu.unahur.obj2.catering.Ofertas.Menu;
import ar.edu.unahur.obj2.catering.Ofertas.Servicio;

/**
 * QuitarDelMenu
 */
public class QuitarDelMenu implements Operacion{

    private final Menu menu;
    private final Servicio servicioPorQuitar;
    

    public QuitarDelMenu(Menu menu, Servicio servicioPorQuitar) {
        this.menu = menu;
        this.servicioPorQuitar = servicioPorQuitar;
    }

    @Override
    public void ejecutar() {
        menu.quitarOferta(servicioPorQuitar.descripcion());
    }

    @Override
    public void deshacer() {
        menu.agregarOferta(servicioPorQuitar);
    }

}
