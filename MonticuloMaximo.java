public class MonticuloMaximo<T extends Comparable<T>> {
    private T[] cola;
    private int elementos;

    @SuppressWarnings("unchecked")
    public MonticuloMaximo(int capacidad) {
        this.cola = (T[]) new Comparable[capacidad]; // arreglo genérico
        this.elementos = 0;
    }

    private static int obtenerPadre(int indice) {
        return (indice - 1) / 2;
    }

    private static int obtenerHijoIzquierdo(int indice) {
        return 2 * indice + 1;
    }

    private static int obtenerHijoDerecho(int indice) {
        return 2 * indice + 2;
    }

    public void agregar(T elemento) {
        if (elementos == cola.length) {
            throw new RuntimeException("Cola llena");
        }

        // Si tenemos 0 elementos, queremos insertar en cola[0]
        // Si tenemos 1 elemento, queremos insertar en cola[1]

        cola[elementos] = elemento;
        int indiceActual = elementos;
        elementos++;

        // Heapify-up
        while (indiceActual > 0 &&
                cola[obtenerPadre(indiceActual)].compareTo(cola[indiceActual]) < 0) {
            swap(indiceActual, obtenerPadre(indiceActual));
            indiceActual = obtenerPadre(indiceActual);
        }
    }

    public T extraerMaximo() {
        if (elementos == 0) {
            throw new RuntimeException("Cola vacía");
        }

        T maximo = cola[0];
        cola[0] = cola[elementos - 1];
        // cola = { x1, x2, x3, x4, x5}
        // cola[0] = cola[elementos - 1]
        // cola[0] = x5 -> cola = { x5, x2, x3, x4, x5}
        // insertar(x6) -> elementos = 4 -> cola[4] = x6 -> cola = { x5, x2, x3, x4, x6}
        elementos--;
        heapifyDown(0);
        return maximo;
    }

    private void heapifyDown(int i) {
        int mayor = i;
        int izq = obtenerHijoIzquierdo(i);
        int der = obtenerHijoDerecho(i);

        if (izq < elementos && cola[izq].compareTo(cola[mayor]) > 0) {
            mayor = izq;
        }
        if (der < elementos && cola[der].compareTo(cola[mayor]) > 0) {
            mayor = der;
        }

        if (mayor != i) {
            swap(i, mayor);
            heapifyDown(mayor);
        }
    }

    private void swap(int i, int j) {
        T temp = cola[i];
        cola[i] = cola[j];
        cola[j] = temp;
    }

    public int size() {
        return elementos;
    }

    public boolean isEmpty() {
        return elementos == 0;
    }
}