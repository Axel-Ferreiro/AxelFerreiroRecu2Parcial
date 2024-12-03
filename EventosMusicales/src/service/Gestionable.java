package service;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;



public interface Gestionable<T extends CSVSerializable & Comparable<T>> {

    void agregar(T evento);

    T eliminar(int id);

    void ordenar();

    void ordenar(Comparator<T> comparator);

    List<T> filtrar(Predicate<T> predicate);

    void mostrarTodos();

    void guardarEnCSV(String path) throws IOException;

    void cargarDesdeCSV(String path, Function<String, T> transformadora) throws IOException;

    void cargarDesdeBinario(String path) throws IOException, ClassNotFoundException;

    void guardarEnBinario(String path) throws IOException;
}
