package ar.edu.unahur.obj2.catering.Ofertas;

import ar.edu.unahur.obj2.catering.Excepciones.PrecioNegativoException;

public class Servicio implements Oferta {

    private final String nombre;
    private Double precio;

    public Servicio(String nombre, Double precio) {
        if(precio < 0.0){
            throw new PrecioNegativoException("El precio colocado es invalido, debe ser positivo");
        }

        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String descripcion() {
        return this.nombre;
    }

    @Override
    public Double precio() {
        return this.precio;
    }

    @Override
    public Integer cantidadOfertas() {
        return 1;
    }

    @Override
    public Boolean incluye(String nombre) {
        return this.nombre.equals(nombre);

    }

    



}
