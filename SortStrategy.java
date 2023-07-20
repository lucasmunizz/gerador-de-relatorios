import java.util.Comparator;
import java.util.List;

public interface SortStrategy {
    void ordena(List<Produto> produtos, Comparator<Produto> comparator);
}
