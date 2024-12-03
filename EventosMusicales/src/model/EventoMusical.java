
package model;

import java.io.Serializable;
import java.time.LocalDate;
import service.CSVSerializable;


public class EventoMusical extends Evento implements CSVSerializable,Serializable,Comparable<EventoMusical>  {
    private static final long SerialVersion = 1L;
    private String artista;
    private GeneroMusical generoMusical;

    public EventoMusical(int id, String nombre, LocalDate fecha,String artista, GeneroMusical generoMusical ) {
        super(id, nombre, fecha);
        this.artista = artista;
        this.generoMusical = generoMusical;
    }

    @Override
    public String toCSV() {
        return super.getId() + "," + super.getNombre() + "," + super.getFecha() + "," + artista + "," + generoMusical.toString();
    }

    @Override
    public String toHeaderCSV() {
        return "id,nombre,fecha,artista,generoMusical";
    }

    @Override
    public int compareTo(EventoMusical o) {
        return super.getNombre().compareTo(o.getNombre());
    }
    
    
    public static EventoMusical fromCSV(String eventoMusicalCSV) {
        EventoMusical p1 = null;
        String[] values = eventoMusicalCSV.split(",");
        if (values.length == 5) {
            int id = Integer.parseInt(values[0]);
            String nombre = values[1];
            LocalDate fecha = LocalDate.parse(values[2]);
            String artista = values[3];
            GeneroMusical generoMusical = GeneroMusical.valueOf(values[4]);

            p1 = new EventoMusical(id, nombre, fecha ,artista, generoMusical);
        }
        return p1;
    }

    public GeneroMusical getGeneroMusical() {
        return generoMusical;
    }
    
    
    
}
