public abstract class ProdutoDecorator implements Produto {
    protected Produto produtoDecorado;

    public ProdutoDecorator(Produto produtoDecorado) {
        this.produtoDecorado = produtoDecorado;
    }

    @Override
    public int getId() {
        return produtoDecorado.getId();
    }

    @Override
    public String getDescricao() {
        return produtoDecorado.getDescricao();
    }

    @Override
    public String getCategoria() {
        return produtoDecorado.getCategoria();
    }

    @Override
    public int getQtdEstoque() {
        return produtoDecorado.getQtdEstoque();
    }

    @Override
    public double getPreco() {
        return produtoDecorado.getPreco();
    }

    @Override
    public abstract String formataParaImpressao();
}
