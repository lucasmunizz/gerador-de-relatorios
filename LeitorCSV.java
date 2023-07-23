import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class LeitorCSV {

    public static List<Produto> lerProdutosDoCSV(String arquivoCSV) throws IOException {
        List<Produto> produtos = new ArrayList<>();

            BufferedReader br = new BufferedReader(new FileReader(arquivoCSV));
            String linha;
            boolean primeiraLinha = true; // Para ignorar o cabeçalho do CSV

            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                String[] campos = linha.split(",");

                int id = Integer.parseInt(campos[0].trim());
                String descricao = campos[1].trim();
                String categoria = campos[2].trim();
                int quantidadeEstoque = Integer.parseInt(campos[3].trim());
                double preco = Double.parseDouble(campos[4].trim());
                boolean negrito = Boolean.parseBoolean(campos[5].trim());
                boolean italico = Boolean.parseBoolean(campos[6].trim());
                String cor = campos[7].trim();

                Produto produto = new ProdutoPadrao(id, descricao, categoria, quantidadeEstoque, preco);

                if (italico){
                    produto = new ProdutoItalico(produto);
                }

                if (negrito){
                    produto = new ProdutoNegrito(produto);
                }

                produto = new ProdutoFormatado(produto, cor);

                produtos.add(produto);
            }
         return produtos;

        }

        public static List<Produto> carregaProdutosCSV(){
            List<Produto> produtos = new ArrayList<>();
            try {
                produtos = LeitorCSV.lerProdutosDoCSV("produtos.csv");
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
                System.exit(1);
            }
        
            return produtos;
    
        }

    }


