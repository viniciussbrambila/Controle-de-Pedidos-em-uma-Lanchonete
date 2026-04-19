package View;

import Model.Pedido;
import Model.Produto;

public class PedidoView {

    public void mostrarMensagem(String msg) {
        System.out.println(">> " + msg);
    }

    public void mostrarErro(String erro) {
        System.err.println("[ERRO] " + erro);
    }

    public void exibirCupom(Pedido pedido) {
        System.out.println("\n--- Cupom do Pedido (" + pedido.getDataPedido() + ") ---");
        for (Produto p : pedido.getProdutos()) {
            System.out.println("1x " + p.getNome() + " - R$" + p.getPreco());
        }
        System.out.println("Status: " + (pedido.isFinalizado() ? "FINALIZADO" : "ABERTO"));
        System.out.println("Total: R$" + pedido.getValorTotal());
        System.out.println("------------------------------------");
    }

    public void exibirFechamentoCaixa(String data, int totalPedidos, double faturamento) {
        System.out.println("\n=== Fechamento do Caixa (" + data + ") ===");
        System.out.println("Total de Pedidos Finalizados: " + totalPedidos);
        System.out.println("Faturamento Total: R$" + faturamento);
        System.out.println("=========================================\n");
    }

}
