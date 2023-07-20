import java.util.Comparator;
import java.util.List;

public class InsertionSort implements SortStrategy {

    @Override
    public void ordena(List<Produto> produtos, Comparator<Produto> comparador) {
        for (int i = 1; i < produtos.size(); i++) {
            Produto x = produtos.get(i);
            int j = (i - 1);

            while (j >= 0 && comparador.compare(produtos.get(j), x) > 0) {
                produtos.set(j + 1, produtos.get(j));
                j--;
            }

            produtos.set(j + 1, x);
        }
    }
}
    

