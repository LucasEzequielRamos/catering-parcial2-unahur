package ar.edu.unahur.obj2.catering.Adicionales;

import ar.edu.unahur.obj2.catering.Ofertas.Oferta;

public class ServicioNocturno extends Adicional {

    public  ServicioNocturno(Oferta oferta) {
        super(oferta);
    }

    @Override
    public String descripcion() {
        return oferta.descripcion() + " + Servicio nocturno";
    }

    @Override
    public Double precio() {
        return oferta.precio() * 1.2;
    }
}
