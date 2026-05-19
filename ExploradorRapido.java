
public class ExploradorRapido extends Explorador implements Runnable {
//criando o construtor da classe

    public ExploradorRapido(String nome, int prioridade, String tarefa) {
        super(nome, "Rápido", tarefa, prioridade);
    }

    //sobreescrevendo o metodo executarTarefa da classe Explorador
    @Override
    public void executarTarefa() throws TarefaInvalidaException {
        //validando a tarefa
        if (getTarefa() == null || getTarefa().isEmpty()) {
            throw new TarefaInvalidaException("Tarefa inválida para Explorador Rápido!");
        }
        //imprimindo a tarefa
        System.out.println("Explorador Rápido executando a tarefa " + getTarefa());
        System.out.println("--------------------");
    }

    //sobreescrevendo o metodo run
    @Override
    public void run() {
        //chamando o metodo executarTarefa 
        try {
            executarTarefa();
            //caso de erro
        } catch (TarefaInvalidaException e) {
            System.err.println("Erro no Explorador Rápido: " + e.getMessage());
        }
    }
}
