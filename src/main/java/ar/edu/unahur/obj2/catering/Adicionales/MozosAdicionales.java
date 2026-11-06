package ar.edu.unahur.obj2.catering.Adicionales;

import ar.edu.unahur.obj2.catering.Ofertas.Oferta;

public class MozosAdicionales extends Adicional {

    public  MozosAdicionales(Oferta oferta) {
        super(oferta);
    }

    @Override
    public String descripcion() {
        return oferta.descripcion() + " + Mozos adicionales";
    }

    @Override
    public Double precio() {
        return oferta.precio() + 18_000.0;
    }

}
