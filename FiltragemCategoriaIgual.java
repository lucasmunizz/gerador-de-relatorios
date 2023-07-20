import java.util.ArrayList;
import java.util.List;

public class FiltragemCategoriaIgual implements FiltroStrategy {
    @Override
    public List<Produto> filtra(List<Produto> produtos, String argumento) {
        String categoria = argumento.toLowerCase();
        List<Produto> produtosFiltrados = new ArrayList<>();
        for (Produto p : produtos) {
            if (p.getCategoria().equalsIgnoreCase(categoria)) {
                produtosFiltrados.add(p);
            }
        }
        return produtosFiltrados;
    }
}
