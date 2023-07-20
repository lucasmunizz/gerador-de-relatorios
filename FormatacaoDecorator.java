public abstract class FormatacaoDecorator implements Produto{
    Produto produto;

    public FormatacaoDecorator(Produto produto) {
        this.produto = produto;
    }

    public String formataParaImpressao() {
        return "<span style=\"color:" + getCor() + "\">" + produto.formataParaImpressao() + "</span>";
    }

    protected abstract String getCor();
}