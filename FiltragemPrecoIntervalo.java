import java.util.ArrayList;
import java.util.List;

public class FiltragemPrecoIntervalo implements FiltroStrategy {
    public List<Produto> filtra(List<Produto> produtos, String argumento) {
        List<Produto> produtosFiltrados = new ArrayList<>();
        double precoMin = Double.parseDouble(argumento.split(",")[0]);
        double precoMax = Double.parseDouble(argumento.split(",")[1]);
        for (Produto produto : produtos) {
            double preco = produto.getPreco();
            if (preco >= precoMin && preco <= precoMax) {
                produtosFiltrados.add(produto);
            }
        }
        return produtosFiltrados;
    }
}
