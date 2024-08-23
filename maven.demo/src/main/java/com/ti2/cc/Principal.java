package com.ti2.cc;

public class Principal {
	public static void main(String[] args) {
		DAO dao = new DAO();
		
		dao.conectar();
		
		Usuario usuario = new Usuario(11, "pablo", "pablo", 'M');
		if(dao.inserirUsuario(usuario) == true) {
			System.out.println("Inserção com sucesso ->" + usuario.toString());
		}
		
		dao.close();
	}
}
