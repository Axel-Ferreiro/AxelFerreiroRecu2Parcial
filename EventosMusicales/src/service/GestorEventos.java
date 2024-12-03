package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;


public class GestorEventos<T extends CSVSerializable & Comparable<T>> implements Gestionable<T> {

    private List<T> listaEventos = new ArrayList<>();

    @Override
    public void agregar(T evento) {
        if (evento == null) {
            throw new IllegalArgumentException("No se puede agregar un null");
        }
        listaEventos.add(evento);
    }

    @Override
    public T eliminar(int id) {
        validarIndice(id);
        return listaEventos.remove(id);
    }

    @Override
    public void ordenar() {
        ordenar((Comparator<T>) Comparator.naturalOrder());
    }

    @Override
    public void ordenar(Comparator<T> comparator) {
        listaEventos.sort(comparator);
    }

    @Override
    public List<T> filtrar(Predicate<T> predicate) {
        List<T> aux = new ArrayList<>();
        for (T evento : listaEventos) {
            if (predicate.test(evento)) {
                aux.add(evento);
            }
        }
        return aux;
    }

    @Override
    public void mostrarTodos() {
        for (T item : listaEventos) {
            System.out.println(item);
        }
    }

    @Override
    public void guardarEnCSV(String path) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        bw.write(listaEventos.get(0).toHeaderCSV() + "\n");
        for (T item : listaEventos) {
            bw.write(item.toCSV() + "\n");
        }
        bw.close();
    }

    @Override
    public void cargarDesdeCSV(String path, Function<String, T> transformadora) throws IOException {
        listaEventos.clear();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String linea = "";
        br.readLine();
        while ((linea = br.readLine()) != null) {
            listaEventos.add(transformadora.apply(linea));
        }
        br.close();        
    }

    @Override
    public void cargarDesdeBinario(String path) throws IOException, ClassNotFoundException {
        listaEventos.clear();
        ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(path));
        listaEventos.addAll((List<T>) entrada.readObject());
        entrada.close();
        
    }

    @Override
    public void guardarEnBinario(String path) throws IOException {
        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(path));
        salida.writeObject(listaEventos);
        salida.close();

 
    }

    public void validarIndice(int indice) {
        if (indice < 0 || indice >= listaEventos.size()) {
            throw new IndexOutOfBoundsException("Indice fuera de rango: " + indice);
        }
    }

}
