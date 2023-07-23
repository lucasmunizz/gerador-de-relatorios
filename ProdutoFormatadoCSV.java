public class ProdutoFormatadoCSV implements Produto {
    private Produto produto;
    private FormatacaoDecorator formatacao;
    private int id;
    private String descricao;
    private String categoria;
    private int qtdEstoque;
    private double preco;
    private boolean negrito;
    private boolean italico;
    private String cor;

    public ProdutoFormatadoCSV(int id, String descricao, String categoria, int qtdEstoque, double preco,
                            boolean negrito, boolean italico, String cor) {
        setId(id);
        setDescricao(descricao);
        setCategoria(categoria);
        setQtdEstoque(qtdEstoque);
        setPreco(preco);
        this.negrito = negrito;
        this.italico = italico;
        this.cor = cor;
        System.out.println(preco);
     }

     public ProdutoFormatadoCSV(Produto produto, boolean negrito, boolean italico, String cor){
        this.produto = produto;
        this.negrito = negrito;
        this.italico = italico;
        this.cor = cor;
     }

    @Override
    public String formataParaImpressao() {
        String texto = produto.formataParaImpressao();  
        if (isNegrito()){
            formatacao = new FormatacaoNegrito();
            texto = formatacao.aplicarFormatacao(texto);
        }
        if (isItalico()){
            formatacao = new FormatacaoItalica();
            texto = formatacao.aplicarFormatacao(texto);
        }

        formatacao = new FormatacaoCor(texto);
        texto = formatacao.aplicarFormatacao(texto);
        return texto;
    }

    private void setId(int id){

		this.id = id;
	}

	private void setDescricao(String descricao){

		this.descricao = descricao;
	}

	private void setCategoria(String categoria){

		this.categoria = categoria;
	}

	public void setQtdEstoque(int qtdEstoque){

		this.qtdEstoque = qtdEstoque;
	}
	
	public void setPreco(double preco){
	
		this.preco = preco;
	}

    @Override
    public int getId() {
        return produto.getId();
    }

    @Override
    public String getDescricao() {
        return produto.getDescricao();
    }

    @Override
    public String getCategoria() {
        return produto.getCategoria();
    }

    @Override
    public int getQtdEstoque() {
        return produto.getQtdEstoque();
    }

    @Override
    public double getPreco() {
        return produto.getPreco();
    }

    public boolean isNegrito() {
        return negrito;
    }

    public void setNegrito(boolean negrito) {
        this.negrito = negrito;
    }

    public boolean isItalico() {
        return italico;
    }

    public void setItalico(boolean italico) {
        this.italico = italico;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
