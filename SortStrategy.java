import java.util.List;

public interface SortStrategy {
    void ordena(List<Produto> produtos, String criterio);
}
