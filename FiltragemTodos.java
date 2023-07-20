import java.util.List;

public class FiltragemTodos implements FiltroStrategy {
    @Override
    public List<Produto> filtra(List<Produto> produtos, String parametro) {
        return produtos;
    }
}
