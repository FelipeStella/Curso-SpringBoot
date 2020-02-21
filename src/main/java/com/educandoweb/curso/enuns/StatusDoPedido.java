package com.educandoweb.curso.enuns;

public enum StatusDoPedido {

	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private Integer codigo;

	private StatusDoPedido(Integer codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static StatusDoPedido valueOf(Integer codigo) {
		for (StatusDoPedido valor : StatusDoPedido.values()) {
			if(valor.getCodigo() == codigo) {
				return valor;
			}			
		}
		throw new IllegalArgumentException("Código inválido");
	}
	
	
}
