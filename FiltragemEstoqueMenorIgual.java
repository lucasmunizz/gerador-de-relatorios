import java.util.ArrayList;
import java.util.List;

public class FiltragemEstoqueMenorIgual implements FiltroStrategy {
    @Override
    public List<Produto> filtra(List<Produto> produtos, String argumento) {
        int limite = Integer.parseInt(argumento);
        List<Produto> produtosFiltrados = new ArrayList<>();
        for (Produto p : produtos) {
            if (p.getQtdEstoque() <= limite) {
                produtosFiltrados.add(p);
            }
        }
        return produtosFiltrados;
    }
}