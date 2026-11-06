package ar.edu.unahur.obj2.catering.Adicionales;

import ar.edu.unahur.obj2.catering.Ofertas.Oferta;

public class VajillaPremium extends Adicional {

    public VajillaPremium(Oferta oferta) {
        super(oferta);
    }

    @Override
    public String descripcion() {
        return oferta.descripcion() + " + Vajilla premium";
    }

    @Override
    public Double precio() {
        return oferta.precio() + 12_000.0;
    }
}
