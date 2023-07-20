import java.util.List;

public class InsertionSort implements SortStrategy {

    public static final String CRIT_DESC_CRESC = "descricao_c";
	public static final String CRIT_PRECO_CRESC = "preco_c";
	public static final String CRIT_ESTOQUE_CRESC = "estoque_c";

    @Override
    public void ordena(List<Produto> produtos, String criterio) {
        for (int i = 1; i < produtos.size(); i++) {
            Produto chave = produtos.get(i);
            int j = i - 1;

            while (j >= 0 && compara(produtos.get(j), chave, criterio) > 0) {
                produtos.set(j + 1, produtos.get(j));
                j--;
            }
            produtos.set(j + 1, chave);
        }
    }

    private int compara(Produto p1, Produto p2, String criterio) {
        if (criterio.equals(CRIT_DESC_CRESC)) {
            return p1.getDescricao().compareToIgnoreCase(p2.getDescricao());
        } else if (criterio.equals(CRIT_PRECO_CRESC)) {
            return Double.compare(p1.getPreco(), p2.getPreco());
        } else if (criterio.equals(CRIT_ESTOQUE_CRESC)) {
            return Integer.compare(p1.getQtdEstoque(), p2.getQtdEstoque());
        } else {
            throw new IllegalArgumentException("Criterio invalido!");
        }
    }
}
    

