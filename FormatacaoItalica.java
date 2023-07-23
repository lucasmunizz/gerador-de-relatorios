public class FormatacaoItalica implements Formatacao {

    @Override
    public String aplicarFormatacao(String texto) {
        //return "<span><i>" + texto + "</i></span>";
        return "<i>" + texto + "</i>";
    }
    
}
