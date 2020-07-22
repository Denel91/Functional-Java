package Laboratorio.Queue_Stack;

import java.util.ArrayList;

/**
 * Definizione della classe PriorityQueue (coda prioritaria).
 * Si tratta di un contenitore di elementi, ciascuno dei quali ha un livello
 * di priorità: si può inserire qualsiasi elemento, ma è consentita la rimozione
 * del solo elemento avente la priorità migliore.
 *
 * PriorityQueue is mutable, bounded.
 *
 * Class overview:
 * PriorityQueue() : Default Constructor
 * PriorityQueue(int capacity) : Constructor (Creator)
 * getSize() : int
 * isEmpty() : boolean
 * enqueue(Node a) : void
 * poll() : Node
 * peek() : Node
 * toString() : String
 *
 * @version 27/06/2020
 */
public class PriorityQueue {
    // variabili di istanza
    private ArrayList<Node> queue;                  // rappresentazione interna della PriorityQueue
    private static final int DEFAULT_SIZE = 128;    // default PriorityQueue size
    private int capacity;                           // specifica la capacità massima della PriorityQueue
    private int size;                               // numero di elementi nella PriorityQueue

    //------------ classe annidata Node ------------ //

    private static class Node implements Comparable<Node> {
        // variabili di istanza
        private char character;
        private int weight;

        public Node(char chr, int wgt) {
            this.character = chr;
            this.weight = wgt;
        }

        public char getCharacter() {
            return character;
        }

        public int getWeight() {
            return weight;
        }

        public void setKey(char key) {
            character = key;
        }

        private void setValue(int value) {
            weight = value;
        }

        @Override
        public int compareTo(Node n) {
            if (weight < n.getWeight()) {
                return -1;
            } else if (weight == n.getWeight()) {
                return 0;
            } else { // weight > n.weight()
                return 1;
            }
        }

        @Override
        public String toString() {
            return "(" + weight + "," + character + ")";
        }
    }

    //------------ Fine classe annidata Node ------------ //

    /**
     * Constructor (Creator).
     *
     * @param capacity the size of the PriorityQueue. REQUIRE >= 0
     */
    public PriorityQueue(int capacity) {
        this.capacity = capacity == 0 ? DEFAULT_SIZE : capacity;
        this.queue = new ArrayList<>(capacity);
        this.size = 0;
    }

    /**
     * Default Constructor
     */
    public PriorityQueue() {
        this(DEFAULT_SIZE);
    }

    /**
     * Restituisce il numero di elementi presenti nella coda.
     *
     * @return il numero di nodi della coda
     */
    public int getSize() {
        return queue.size();
    }

    /**
     * Verifica se la coda è vuota.
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Inserisce un nodo in fondo alla coda.
     *
     * @param a il nodo da inserire nella coda.
     */
    public void enqueue(Node a) {
        queue.add(a);
        size++;
    }

    /**
     * Restituisce e rimuove dalla coda l’elemento con “peso minore”
     *
     * @return il nodo con peso minore
     */
    public Node poll() {
        if (isEmpty())
            return null;
        Node small = queue.get(0);
        int k = 0;
        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i).weight < small.weight) {
                small = queue.get(i);
                k = i;
            }
        }
        queue.remove(k);
        size--;
        return small;
    }

    /**
     * Restituisce il nodo con “peso minore” senza rimuoverlo dalla coda.
     *
     * @return il nodo con "peso minore" senza rimuoverlo dalla coda.
     */
    public Node peek() {
        if (isEmpty())
            return null;
        return findMin();
    }

    /**
     * Procedura di supporto che restituisce il nodo con “peso minore” senza rimuoverlo dalla coda.
     *
     * @return il nodo con "peso minore" senza rimuoverlo dalla coda.
     */
    private Node findMin() {
        Node small = queue.get(0);
        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i).weight < small.weight)
                small = queue.get(i);
        }
        return small;
    }

    /**
     * Restituisce una rappresentazione in formato stringa della coda come un elenco di elementi.
     *
     * @return una rappresentazione testuale della coda.
     */
    @Override
    public String toString() {
        return queue.toString();
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        Node a = new Node('A', 8);
        Node b = new Node('B', 5);
        Node c = new Node('T', 7);
        Node d = new Node('P', 9);
        Node e = new Node('F', 4);
        Node f = new Node('K', 6);
        priorityQueue.enqueue(a);
        priorityQueue.enqueue(b);
        priorityQueue.enqueue(c);
        priorityQueue.enqueue(d);
        priorityQueue.enqueue(e);
        priorityQueue.enqueue(f);
        System.out.println(priorityQueue.toString()); // [(8,A), (5,B), (7,T), (9,P), (4,F), (6,K)]
        System.out.println("Empty?: " + priorityQueue.isEmpty()); // false
        System.out.println("Size: " + priorityQueue.getSize()); // 6
        System.out.println(priorityQueue.poll()); // (4,F)
        System.out.println(priorityQueue.toString()); // [(8,A), (5,B), (7,T), (9,P), (6,K)]
        System.out.println(priorityQueue.peek()); // (5,B)
        System.out.println(priorityQueue.toString()); // [(8,A), (5,B), (7,T), (9,P), (6,K)]
        System.out.println("Size: " + priorityQueue.getSize()); // 5
    }
}
