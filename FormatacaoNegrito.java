public class FormatacaoNegrito implements Formatacao {

    @Override
    public String aplicarFormatacao(String texto) {
        //return "<span><b>" + texto + "</b></span>";
        return "<b>" + texto + "</b>";
    }
    
}
