public class FormatacaoCor implements FormatacaoDecorator {

    private String cor;

    public FormatacaoCor(String cor){
        this.cor = cor;
    }

    @Override
    public String aplicarFormatacao(String texto) {
        return "<span><font color=\"" + cor + "\">" + texto + "</font></span>";
    }
}
