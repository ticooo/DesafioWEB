# language: pt

Funcionalidade: Produtos

	Contexto:
		Dado que eu esteja na home
		
	@Carrinho
	Cenário: Incluir produto no carrinho
		Quando procuro por "Sapato Casual Masculino"
			E incluo o produto "Sapato Casual Couro Shoestock Camurça Liso Masculino" no carrinho
		Entao valido produto "Sapato Casual Couro Shoestock Camurça Liso Masculino" no carrinho
		
		