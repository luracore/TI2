package app;

*import static spark.Spark.*;

public class Aplicacao {
	private static ProdutoService produtoService = new ProdutoService();
	
	public static void main(String[] args) {
		port(6789);
		
		post("/produto", (req, res) -> produtoService.add(req, res));
		
		get("/produto/:id", (req, res) -> produtoService.get(req, res));
		
		get("/produto/:id", (req, res) -> produtoService.get(req, res));
		
		get("/produto/update/:id", (req, res) -> produtoService.get(req, res));
		
		get("/produto/delete/:id", (req, res) -> produtoService.get(req, res));
		
		get("/produto/", (req, res) -> produtoService.getAll(req, res));
	}
}
