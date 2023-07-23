public class Filtrador {

    public static FiltroStrategy getFiltroStrategy(String filtro){
		FiltroStrategy strategy;
		switch (filtro){
			case "todos":
				strategy = new FiltragemTodos();
				break;
			case "estoque_menor_igual":
				strategy = new FiltragemMenorOuIgual();
				break;
			case "categoria_igual":
				strategy = new FiltragemCategoriaIgual();
				break;
			case "preco_intervalo":
				strategy = new FiltragemPrecoIntervalo();
				break;
			case "substring":
				strategy = new FiltragemSubstring();
				break;
			default:
				throw new IllegalArgumentException("Filtro de ordenação inválido: " + filtro);
		}

		return strategy;
	}
}
