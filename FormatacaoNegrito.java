public class FormatacaoNegrito implements Formatacao {

    @Override
    public String aplicarFormatacao(String texto) {
        return "<span style=\"font-style:bold\">" + texto + "</span>";
    }
    
}
