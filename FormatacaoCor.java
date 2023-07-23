public class FormatacaoCor implements Formatacao {

    private String cor;
    private Formatacao formatacaoAnterior;

    public FormatacaoCor(String cor, Formatacao formatacaoAnterior){
        this.cor = cor;
        this.formatacaoAnterior = formatacaoAnterior;
    }
     public FormatacaoCor(String cor){
        this.cor = cor;
    }

    @Override
    public String aplicarFormatacao(String texto) {
        return "<span><font color=\"" + cor + "\">" + texto + "</font></span>";
    }
}
