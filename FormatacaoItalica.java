public class FormatacaoItalica implements FormatacaoDecorator {

    @Override
    public String aplicarFormatacao(String texto) {
        return "<i>" + texto + "</i>";
    }
    
}
