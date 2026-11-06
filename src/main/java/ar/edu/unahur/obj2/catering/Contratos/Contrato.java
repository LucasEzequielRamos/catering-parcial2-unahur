package ar.edu.unahur.obj2.catering.Contratos;


import ar.edu.unahur.obj2.catering.Ofertas.Oferta;

/**
 * Contrato
 */
public class Contrato {

    private final String nombreCliente;
    private final Double precioReservado;
    private final String descripcionOferta;

    public Contrato(String nombreCliente, Oferta oferta) {
    
        this.nombreCliente = nombreCliente;
        this.precioReservado = oferta.precio();
        this.descripcionOferta = oferta.descripcion();
    
    }

    public Double precioReserva(){
        return this.precioReservado;
    }

    public String descripcionReserva(){
        return this.descripcionOferta;
    }

    

}
