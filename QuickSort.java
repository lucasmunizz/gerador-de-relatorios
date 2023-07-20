import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuickSort implements SortStrategy {

    @Override
    public void ordena(List<Produto> produtos, Comparator<Produto> comparator) {
        ordenaRecursivo(produtos, comparator, 0, produtos.size() - 1);
    }

     private void ordenaRecursivo(List<Produto> produtos, Comparator<Produto> comparador, int ini, int fim) {
        if (ini < fim) {
            int q = particiona(produtos, comparador, ini, fim);
            ordenaRecursivo(produtos, comparador, ini, q);
            ordenaRecursivo(produtos, comparador, q + 1, fim);
        }
    }

    private int particiona(List<Produto> produtos, Comparator<Produto> comparador, int ini, int fim) {
        Produto x = produtos.get(ini);
        int i = (ini - 1);
        int j = (fim + 1);

        while (true) {
            do {
                j--;
            } while (comparador.compare(produtos.get(j), x) > 0);

            do {
                i++;
            } while (comparador.compare(produtos.get(i), x) < 0);

            if (i < j) {
                Collections.swap(produtos, i, j);
            } else {
                return j;
            }
        }
    }
    
}
