
public class ProdutoCor extends ProdutoDecorator {
    private String cor;

    public ProdutoCor(Produto produtoDecorado, String cor) {
        super(produtoDecorado);
        this.cor = cor;
    }

    @Override
    public String formataParaImpressao() {
        // Aplicar formatação de cor ao produtoDecorado e retornar o texto formatado
        return "<span><font color='" + cor + "'>" + produtoDecorado.formataParaImpressao() + "</font></span>";
    }

    @Override
    public void setQtdEstoque(int qtdEstoque) {
        super.produtoDecorado.setQtdEstoque(qtdEstoque);
    }

    @Override
    public void setPreco(double preco) {
        super.produtoDecorado.setPreco(preco);
    }
}
