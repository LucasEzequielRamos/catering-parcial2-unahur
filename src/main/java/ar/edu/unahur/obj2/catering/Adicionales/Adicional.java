package ar.edu.unahur.obj2.catering.Adicionales;

import ar.edu.unahur.obj2.catering.Ofertas.Oferta;

public abstract class Adicional implements Oferta{

    protected final Oferta oferta;

    protected Adicional(Oferta oferta){
        this.oferta = oferta;
    }

      @Override
    public Boolean incluye(String nombre) {
        return oferta.incluye(nombre);
    }

    @Override
    public Integer cantidadOfertas() {
        return oferta.cantidadOfertas();
    }

}
