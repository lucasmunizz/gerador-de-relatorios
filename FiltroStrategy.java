import java.util.List;

public interface FiltroStrategy {
    List<Produto> filtra(List<Produto> produtos, String argumento);
}
