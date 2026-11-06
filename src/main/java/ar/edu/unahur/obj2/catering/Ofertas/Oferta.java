package ar.edu.unahur.obj2.catering.Ofertas;

/**
 * Oferta
 */
public interface Oferta {
    public String descripcion();
    public Double precio();
    public Integer cantidadOfertas();
    public Boolean incluye(String nombre);

}
