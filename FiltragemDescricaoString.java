import java.util.ArrayList;
import java.util.List;

public class FiltragemDescricaoString implements FiltroStrategy{

    @Override
    public List<Produto> filtra(List<Produto> produtos, String argumento) {
        List<Produto> produtosFiltrados = new ArrayList<>();
        for (Produto produto : produtos) {
            String descricao = produto.getDescricao();
            if (descricao.toLowerCase().contains(argumento.toLowerCase())) {
                produtosFiltrados.add(produto);
            }
        }
        return produtosFiltrados;
    }

}