public class ProdutoItalico extends ProdutoDecorator {

    public ProdutoItalico(Produto produtoDecorado) {
        super(produtoDecorado);
    }

    @Override
    public String formataParaImpressao() {
        return "<i>" + produtoDecorado.formataParaImpressao() + "</i>";
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
