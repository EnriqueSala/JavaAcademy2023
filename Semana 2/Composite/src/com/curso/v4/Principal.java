package com.curso.v4;

public class Principal {

	public static void main(String[] args) {
		Component ejercicio = new CompositeDiv(new CompositeMulti(new CompositeResta(new ConstanteLeaf(4.0), new ConstanteLeaf(6.0)),
				new ConstanteLeaf(200.0)), new CompositeSuma(new ConstanteLeaf(3.0), new ConstanteLeaf(83.0)));
		Component component = new CompositeSuma(
				new CompositeResta(new ConstanteLeaf(3.0),
						new CompositeDiv(new ConstanteLeaf(8.0),
								         new ConstanteLeaf(2.0))
						),
				new CompositeMulti(new ConstanteLeaf(4.0),
						           new ConstanteLeaf(5.0))
				);

		System.out.println(ejercicio.getValor()); //19

	}

}
