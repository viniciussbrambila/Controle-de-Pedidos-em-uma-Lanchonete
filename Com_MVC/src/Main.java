import Controller.PedidoController;
import View.PedidoView;
import Model.Produto;
import Model.Pedido;

public class Main {
    public static void main(String[] args) {
        PedidoView view = new PedidoView();
        PedidoController controller = new PedidoController();

        try {
            view.mostrarMensagem("Iniciando Sistema da Lanchonete...");

            Produto p1 = new Produto("X-Burguer", "Pão, carne e queijo", 25.0);
            Produto p2 = new Produto("Coca-Cola", "Lata 350ml", 7.0);
            Produto p3 = new Produto("Batata Frita", "Porção média", 15.0);

            view.mostrarMensagem("Registrando Pedido 1...");
            Pedido pedido1 = controller.abrirPedido("18/04/2026");
            controller.adicionarProdutoAoPedido(pedido1, p1);
            controller.adicionarProdutoAoPedido(pedido1, p2);
            controller.finalizarPedido(pedido1);
            view.exibirCupom(pedido1);

            view.mostrarMensagem("Registrando Pedido 2...");
            Pedido pedido2 = controller.abrirPedido("18/04/2026");
            controller.adicionarProdutoAoPedido(pedido2, p1);
            controller.adicionarProdutoAoPedido(pedido2, p3);
            controller.finalizarPedido(pedido2);
            view.exibirCupom(pedido2);

            var pedidosDeHoje = controller.consultarPedidosDoDia("18/04/2026");
            double faturamentoHoje = controller.calcularFaturamentoDoDia("23/10/2026");

            view.exibirFechamentoCaixa("18/04/2026", pedidosDeHoje.size(), faturamentoHoje);

        } catch (Exception e) {
            view.mostrarErro(e.getMessage());
        }
    }
}