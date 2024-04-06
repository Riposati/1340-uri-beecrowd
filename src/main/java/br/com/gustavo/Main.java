package br.com.gustavo;

import java.util.*;

class GuessDataStructure {
    private boolean isStack;
    private boolean isQueue;
    private boolean isPriorityQueue;
    private final Stack<Integer> stackOfNumbers = new Stack<>();
    private final Queue<Integer> queueOfNumbers = new LinkedList<>();
    private final PriorityQueue<Integer> priorityQueueOfNumbers = new PriorityQueue<Integer>(new Comparator<Integer>() {
        public int compare(Integer lhs, Integer rhs) {
            if (lhs < rhs) return +1;
            if (lhs.equals(rhs)) return 0;
            return -1;
        }
    });

    public GuessDataStructure() {
        this.isQueue = this.isStack = this.isPriorityQueue = true;
    }

    public void insertValue(int value) {
        this.queueOfNumbers.add(value);
        this.stackOfNumbers.push(value);
        this.priorityQueueOfNumbers.add(value);
    }

    public void guessDataStructure(int value) {
        if (!this.stackOfNumbers.isEmpty() && this.stackOfNumbers.peek() != value)
            this.isStack = false;
        else if (!this.stackOfNumbers.isEmpty())
            this.stackOfNumbers.pop();

        if (!this.queueOfNumbers.isEmpty() && this.queueOfNumbers.peek() != value)
            this.isQueue = false;
        else if (!this.queueOfNumbers.isEmpty())
            this.queueOfNumbers.poll();

        if (!this.priorityQueueOfNumbers.isEmpty() && this.priorityQueueOfNumbers.peek() != value)
            this.isPriorityQueue = false;
        
        else if (!this.priorityQueueOfNumbers.isEmpty())
            this.priorityQueueOfNumbers.poll();

    }

    public void giveAnswerAboutGuessingDS() {
        if (this.isStack && !this.isQueue && !this.isPriorityQueue)
            System.out.println("stack");
        else if (!this.isStack && this.isQueue && !this.isPriorityQueue)
            System.out.println("queue");
        else if (!this.isStack && !this.isQueue && this.isPriorityQueue)
            System.out.println("priority queue");
        else if (!this.isPriorityQueue && !this.isQueue)
            System.out.println("impossible");
        else
            System.out.println("not sure");
    }
}

public class Main {
    public static void main(String[] args) {
        int howManyTests;
        Scanner s = new Scanner(System.in);
        String aux;
        int firstValue, secondValue;

        while (s.hasNext()) {
            howManyTests = Integer.parseInt(s.nextLine());
            GuessDataStructure guessDataStructure = new GuessDataStructure();

            for (int i = 0; i < howManyTests; i++) {
                aux = s.nextLine();
                firstValue = Integer.parseInt(aux.split(" ")[0]);
                secondValue = Integer.parseInt(aux.split(" ")[1]);

                if (firstValue == 1) {
                    guessDataStructure.insertValue(secondValue);
                } else if (firstValue == 2) {
                    guessDataStructure.guessDataStructure(secondValue);
                }
            }
            guessDataStructure.giveAnswerAboutGuessingDS();
        }
    }
}