package service;

*import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import model.Produto;

public class ProdutoService {
	private ProdutoDAO produtoDAO;
	
	public ProdutoService() {
		try {
			produtoDAO = new ProdutoDAO("produto.dat");
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Object add(Request req, Response res) {
		String descricao = req.queryParams("descricao");
		float preco = Float.parseFloat(req.queryParams("preco"));
		int quantidade = Integer.parseInt(req.queryParams("preco"));
		LocalDateTime dataFabricacao = LocalDateTime.parse(req.queryParams("dataFabricacao"));
		LocalDate dataValidade = LocalDate.parse(req.queryParams("dataValidade"));
		
		int id = produtoDAO.getMaxId() + 1;
		
		Produto produto = new Produto(id, descricao, preco, quantidade, dataFabricacao, validade);
		
		produtoDAO.add(produto);
		
		res.status(201);
		return id;
	}
	
	public Object update(Request req, Response res) {
		int id = Integer.parseInt(req.params(":id"));
		
		Produto produto = (Produto) produtoDAO.get(id);
		
		if(produto != null) {
			produto.setDescricao(req.queryParams("descricao"));
			produto.setPreco(Float.parseFloat(req.queryParams("preco")));
			produto.setQuant(Integer.parseInt(req.queryParams("quantidade")));
			produto.setDataFabricacao(LocalDateTime.parse(req.queryParams("dataFabricacao")));
			produto.setDataValidade(LocalDate.parse(req.queryParams("dataValidade")));
			
			produtoDAO.update(produto);
			
			return id;
		}else {
			res.status(404);
			return "Produto não encontrado.";
		}
	}
	
	public Object getAll(Request req, Response res) {
		StringBuffer returnValue = new StringBuffer("<produtos type=\"array\">");
		for(Produto produto: produtoDAO.getALL()) {
			returnValue.append("\n<produto>\n" +
					"\t<id>" + produto.getId() +
					"\t<descricao>" + produto.getDescricao() +
					"\t<preco>" + produto.getPreco() +
					"\t<quantidade>" + produto.getQuant() +
					"\t<fabricacao>" + produto.getDataFabricacao() +
					"\t<validade>" + produto.getDataValidade() +
					"\t<produto>\n");
		}
	}
}
