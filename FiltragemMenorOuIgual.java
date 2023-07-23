import java.util.ArrayList;
import java.util.List;

public class FiltragemMenorOuIgual implements FiltroStrategy {
    @Override
    public List<Produto> filtra(List<Produto> produtos, String argFiltro) {
        int limite = Integer.parseInt(argFiltro);
        List<Produto> produtosFiltrados = new ArrayList<>();
        for (Produto p : produtos) {
            if (p.getQtdEstoque() <= limite) {
                produtosFiltrados.add(p);
            }
        }
        return produtosFiltrados;
    }
}