import java.util.List;

public interface CriterioFiltragem {
    List<Produto> filtra(List<Produto> produtos, String argumento);
}
