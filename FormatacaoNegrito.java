public class FormatacaoNegrito implements FormatacaoDecorator {

    @Override
    public String aplicarFormatacao(String texto) {
        //return "<span><b>" + texto + "</b></span>";
        return "<b>" + texto + "</b>";
    }
    
}
