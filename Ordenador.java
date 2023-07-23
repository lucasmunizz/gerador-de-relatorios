public class Ordenador {

    public static SortStrategy getSortStrategy(String algoritmo, String criterio) {
        SortStrategy strategy;
        switch (algoritmo) {
            case "quick":
                strategy = new QuickSort();
                break;
            case "insertion":
                strategy = new InsertionSort();
                break;
            default:
                throw new IllegalArgumentException("Algoritmo de ordenação inválido: " + algoritmo);
        }
        return strategy;
    }
}
