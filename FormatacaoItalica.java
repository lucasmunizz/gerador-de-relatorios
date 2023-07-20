public class FormatacaoItalica implements Formatacao {

    @Override
    public String aplicarFormatacao(String texto) {
        return "<span style=\"font-style:italic\">" + texto + "</span>";
    }
    
}
