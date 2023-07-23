public class FormatacaoCor implements Formatacao {

    private String cor;

    public FormatacaoCor(String cor){
        this.cor = cor;
    }

    @Override
    public String aplicarFormatacao(String texto) {
        return "<span><font color=\"" + cor + "\">" + texto + "</font></span>";
    }
}
