public class ProdutoNegrito extends ProdutoDecorator {
    public ProdutoNegrito(Produto produtoDecorado) {
        super(produtoDecorado);
    }

    @Override
    public String formataParaImpressao() {
        // Aplicar formatação negrito ao produtoDecorado e retornar o texto formatado
        return "<b>" + produtoDecorado.formataParaImpressao() + "</b>";
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

