
import java.util.ArrayList;

public class CacaAoTesouroParelela {

    //main
    public static void main(String[] args) {
        //criando arraylist
        ArrayList<Thread> threads = new ArrayList<Thread>();
        //criando exploradores 
        ExploradorRapido exploradorRapido = new ExploradorRapido("Bob", 1, "Mapear a floresta");
        ExploradorCuidadoso exploradorCuidadoso = new ExploradorCuidadoso("Carlos", 2, "Vasculhar a caverna");
        ExploradorCuidadoso exploradorCuidadoso2 = new ExploradorCuidadoso("Lucas", 3, "Vasculhar a caverna");
        ExploradorRapido exploradorRapido2 = new ExploradorRapido("Joaquim", 4, "Vasculhar a caverna");
       
        //criando threads
        Thread thread1 = new Thread(exploradorRapido);
        thread1.setPriority(Thread.MAX_PRIORITY);
        Thread thread2 = new Thread(exploradorCuidadoso);
        thread2.setPriority(Thread.MIN_PRIORITY);
        Thread thread3 = new Thread(exploradorCuidadoso2);
        thread3.setPriority(Thread.MIN_PRIORITY);
        Thread thread4 = new Thread(exploradorRapido2);
        thread4.setPriority(Thread.MAX_PRIORITY);
        thread4.setDaemon(true);//setando como daemon

        //adicionando as threads ao arraylist
        threads.add(thread1);
        threads.add(thread2);
        threads.add(thread3);
        threads.add(thread4);

        //iniciando as threads
        for (Thread thread : threads) {
            thread.start();
        }
        //mostrar status
        for (Thread thread : threads) {
            try {
                //esperando a thread terminar
                thread.join();
                //caso de erro 
            } catch (InterruptedException e) {
                //imprimindo erro
                System.err.println("Erro ao executar a thread: " + e.getMessage());
            }
            //imprimindo status
            exploradorRapido.exibirStatus();
            System.out.println("Iniciando exploração...");
            exploradorCuidadoso.exibirStatus();
            System.out.println("Iniciando exploração...");
            exploradorCuidadoso2.exibirStatus();
            System.out.println("Iniciando exploração...");
            exploradorRapido2.exibirStatus();

        }

    }

}
