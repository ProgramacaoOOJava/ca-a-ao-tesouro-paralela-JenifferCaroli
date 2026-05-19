
public abstract class Explorador {
//atributos

    private String nome, tipo, tarefa;
    private int prioridade;
//construtor

    public Explorador(String nome, String tipo, String tarefa, int prioridade) {
        this.nome = nome;
        this.tipo = tipo;
        this.tarefa = tarefa;
        this.prioridade = prioridade;

    }
//metodo abstrato 

    public abstract void executarTarefa() throws TarefaInvalidaException;
//metodo exibirStatus

    public void exibirStatus() {
        System.out.println("Status do Explorador:");
        System.out.println("Nome: " + nome);
        System.out.println("Tarefa: " + tarefa);
        System.out.println("Prioridade: " + prioridade);
        System.out.println("Tipo: " + tipo);
        System.out.println("--------------------");
    }
//metodo getTarefa

    public String getTarefa() {
        return this.tarefa;
    }
}
