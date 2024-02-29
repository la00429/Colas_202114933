package co.edu.uptc.model;

import co.edu.uptc.structures.MyQueue;

public class QueueTurn {
    private MyQueue<Object> turnsPatients;
    private int countTurn;

    public QueueTurn() {
        turnsPatients = new MyQueue<Object>();
        countTurn = 0;
    }

    public void crateTurnByCategory(Patient patient) {
        switch (patient.getCategory()) {
            case 'A':
                createTurn(patient);
                break;
            case 'E':
                createTurn(patient);
                break;
            case 'G':
                createTurn(patient);
                break;
        }
    }


    private void createTurn(Patient patient) {
        countTurn++;
        turnsPatients.push(patient.getName() + " - " + patient.getCategory() + countTurn);

    }

    public Object showNextTurn() {
        Object turnNext = new Object();
        if (!turnsPatients.isEmpty()) {
            turnNext = turnsPatients.peek();
        }
        return turnNext;
    }

    public Object attendTurn() {
        Object turnAttend = new Object();
        if (!turnsPatients.isEmpty()) {
            turnAttend = turnsPatients.peek();
            turnsPatients.poll();
        }
        return turnAttend;
    }

    public boolean isEmpty() {
        return turnsPatients.isEmpty();
    }
}
