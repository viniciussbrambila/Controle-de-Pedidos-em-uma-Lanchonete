import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pedido> pedidosDoDia = new ArrayList<>();

        try {
            Produto p1 = new Produto("X-Burguer", "Pão, carne e queijo", 25.0);
            Produto p2 = new Produto("Coca-Cola", "Lata 350ml", 7.0);
            Produto p3 = new Produto("Batata Frita", "Porção média", 15.0);

            System.out.println("--- Abrindo Pedido 1 ---");
            Pedido pedido1 = new Pedido("18/04/2026");
            pedido1.adicionarProduto(p1);
            pedido1.adicionarProduto(p2);
            pedido1.finalizarPedido();
            pedidosDoDia.add(pedido1);
            pedido1.exibirCupom();

            System.out.println("\n--- Abrindo Pedido 2 ---");
            Pedido pedido2 = new Pedido("18/04/2026");
            pedido2.adicionarProduto(p1);
            pedido2.adicionarProduto(p3);
            pedido2.finalizarPedido();
            pedidosDoDia.add(pedido2);
            pedido2.exibirCupom();

            System.out.println("\n=== Fechamento do Caixa (18/04/2026) ===");
            double faturamentoDia = 0;
            int totalPedidos = 0;

            for (Pedido p : pedidosDoDia) {
                if (p.getDataPedido().equals("18/04/2026") && p.isFinalizado()) {
                    faturamentoDia += p.getValorTotal();
                    totalPedidos++;
                }
            }

            System.out.println("Total de Pedidos Finalizados: " + totalPedidos);
            System.out.println("Faturamento Total: R$" + faturamentoDia);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}