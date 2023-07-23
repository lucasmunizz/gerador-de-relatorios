import java.io.PrintWriter;
import java.io.IOException;

import java.util.*;

public class GeradorDeRelatorios {

	// operador bit a bit "ou" pode ser usado para combinar mais de  
	// um estilo de formatacao simultaneamente (veja como no main)
	public static final int FORMATO_PADRAO  = 0b0000;
	public static final int FORMATO_NEGRITO = 0b0001;
	public static final int FORMATO_ITALICO = 0b0010;

	private List<Produto> produtos;
	private SortStrategy algoritmo;
	private String criterio;
	private FiltroStrategy filtro;
	private String argFiltro;
	private int format_flags;

	public GeradorDeRelatorios(List<Produto> produtos, String algoritmo, String criterio, String filtro, String argFiltro, int format_flags){

		this.produtos = new ArrayList<>(produtos);
		this.algoritmo = Ordenador.getSortStrategy(algoritmo, criterio);
		this.criterio = criterio;
		this.format_flags = format_flags;
		this.filtro = Filtrador.getFiltroStrategy(filtro);
		this.argFiltro = argFiltro;
	}

	public void debug(){

		System.out.println("Gerando relatório para array contendo " + produtos.size() + " produto(s)");
		System.out.println("parametro filtro = '" + argFiltro + "'"); 
	}


	public void geraRelatorio(String arquivoSaida) throws IOException {

		debug();

		algoritmo.ordena(produtos, criterio);

		PrintWriter out = new PrintWriter(arquivoSaida);

		out.println("<!DOCTYPE html><html>");
        out.println("<head><title>Relatorio de produtos</title></head>");
        out.println("<body>");
        out.println("Relatorio de Produtos:");
        out.println("<ul>");

        int count = 0;
		List<Produto> produtosFiltrados = filtro.filtra(produtos, argFiltro);

		for (Produto p : produtosFiltrados) {
            out.print("<li>");

			Produto produtoFormatado = (ProdutoFormatadoCSV) p;
            out.print(produtoFormatado.formataParaImpressao());

            out.println("</li>");
            count++;
        }

        out.println("</ul>");
        out.println(count + " produtos listados, de um total de " + produtos.size() + ".");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }		

	public static void main(String [] args) {

		if(args.length < 4){

			System.out.println("Uso:");
			System.out.println("\tjava " + GeradorDeRelatorios.class.getName() + " <algoritmo> <critério de ordenação> <critério de filtragem> <parâmetro de filtragem> <opções de formatação>");
			System.out.println("Onde:");
			System.out.println("\talgoritmo: 'quick' ou 'insertion'");
			System.out.println("\tcriterio de ordenação: 'preco_c' ou 'descricao_c' ou 'estoque_c'");
			System.out.println("\tcriterio de filtragem: 'todos' ou 'estoque_menor_igual' ou 'categoria_igual'"); 
			System.out.println("\tparâmetro de filtragem: argumentos adicionais necessários para a filtragem"); 
			System.out.println("\topções de formatação: 'negrito' e/ou 'italico'");
			System.out.println();
			System.exit(1);
		}

		String opcao_algoritmo = args[0];
		String opcao_criterio_ord = args[1];
		String opcao_criterio_filtro = args[2];
		String opcao_parametro_filtro = args[3];
		String [] opcoes_formatacao = new String[2];
		opcoes_formatacao[0] = args.length > 4 ? args[4] : null;
		opcoes_formatacao[1] = args.length > 5 ? args[5] : null;
		int formato = FORMATO_PADRAO;
		
		for(int i = 0; i < opcoes_formatacao.length; i++) {

			String op = opcoes_formatacao[i];
			formato |= (op != null ? op.equals("negrito") ? FORMATO_NEGRITO : (op.equals("italico") ? FORMATO_ITALICO : 0) : 0); 
		}
		
		GeradorDeRelatorios gdr = new GeradorDeRelatorios(	LeitorCSV.carregaProdutosCSV(), 
									opcao_algoritmo,
									opcao_criterio_ord,
									opcao_criterio_filtro,
									opcao_parametro_filtro,
									formato
								 );

		try{
			gdr.geraRelatorio("saida.html");
		}
		catch(IOException e){
			
			e.printStackTrace();
		}
	}
}
