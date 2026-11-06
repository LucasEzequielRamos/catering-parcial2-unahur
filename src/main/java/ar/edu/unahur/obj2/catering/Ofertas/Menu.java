package ar.edu.unahur.obj2.catering.Ofertas;

import java.util.ArrayList;

import ar.edu.unahur.obj2.catering.Excepciones.DescuentoInvalidoException;
import ar.edu.unahur.obj2.catering.Excepciones.PropuestaNoIncluidaException;

/**
 * Menu
 */
public class Menu implements Oferta {

    private final String nombre;
    private final Double descuento;
    private ArrayList<Oferta> ofertas;

    public Menu(String nombre, Double descuento) {
        if(descuento < 0.0 || descuento > 100.0) {throw new DescuentoInvalidoException("El descuento no puede ser negativo");}

        this.nombre = nombre;
        this.descuento = descuento;
        this.ofertas = new ArrayList<>();
    }


    @Override
    public String descripcion() {
        return this.nombre;
    }

    @Override
    public Double precio() {
        Double precio = ofertas.stream().mapToDouble(s -> s.precio()).sum();
        return precio - (precio * descuento / 100);
    }

    @Override
    public Integer cantidadOfertas() {
        return ofertas.stream().mapToInt(o -> o.cantidadOfertas()).sum();
    }

    @Override 
    public Boolean incluye(String nombre) {
        return ofertas.stream().anyMatch(o -> o.incluye(nombre));
    }

    public void agregarOferta(Oferta oferta) {
        this.ofertas.add(oferta);
    }


    public void quitarOferta(String ofertaNombre) {
        Oferta oferta = ofertas.stream()
            .filter(o -> o.descripcion().equals(ofertaNombre))
            .findFirst()
            .orElseThrow(() -> new PropuestaNoIncluidaException("La oferta no existe"));

        ofertas.remove(oferta);
    }


    


}
