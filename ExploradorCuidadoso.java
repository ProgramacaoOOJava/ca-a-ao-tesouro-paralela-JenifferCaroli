
public class ExploradorCuidadoso extends Explorador implements Runnable {
//construtor

    public ExploradorCuidadoso(String nome, int prioridade, String tarefa) {
        super(nome, "Cuidadoso", tarefa, prioridade);
    }
//sobreescrevendo o metodo executarTarefa

    @Override
    public void executarTarefa() throws TarefaInvalidaException {
        //validando a tarefa
        if (getTarefa() == null || getTarefa().isEmpty()) {
            //caso de erro
            throw new TarefaInvalidaException("Tarefa inválida para Explorador Cuidadoso!");
        }
        //imprimindo a tarefa
        System.out.println("Explorador Cuidadoso explorando " + getTarefa());
        System.out.println("--------------------");
    }
//sobreescrevendo o metodo run

    @Override
    public void run() {
        try {
            //chamando o metodo executarTarefa
            executarTarefa();
            //caso de erro
        } catch (TarefaInvalidaException e) {
            //imprimindo o erro
            System.err.println("Erro no Explorador Cuidadoso: " + e.getMessage());
        }
    }
}
