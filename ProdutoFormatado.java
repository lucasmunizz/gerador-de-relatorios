public class ProdutoFormatado implements Produto {
    private Produto produto;
    private FormatacaoDecorator formatacao;

    public ProdutoFormatado(Produto produto, FormatacaoDecorator formatacao) {
        this.produto = produto;
        this.formatacao = formatacao;
    }

    @Override
    public String formataParaImpressao() {
        String textoFormatado = formatacao.aplicarFormatacao(produto.formataParaImpressao());
        return textoFormatado;
    }

    @Override
    public void setQtdEstoque(int qtdEstoque) {
        produto.setQtdEstoque(qtdEstoque);
    }

    @Override
    public void setPreco(double preco) {
        produto.setPreco(preco);
    }

    @Override
    public int getId() {
        return produto.getId();
    }

    @Override
    public String getDescricao() {
        return produto.getDescricao();
    }

    @Override
    public String getCategoria() {
        return produto.getCategoria();
    }

    @Override
    public int getQtdEstoque() {
        return produto.getQtdEstoque();
    }

    @Override
    public double getPreco() {
        return produto.getPreco();
    }
}
