public class FormatacaoCorVermelha extends FormatacaoDecorator {
    public FormatacaoCorVermelha(Produto produto) {
        super(produto);
    }

    protected String getCor() {
        return "red";
    }
}
