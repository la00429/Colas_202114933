package co.edu.uptc.presenter;

import co.edu.uptc.model.Patient;
import co.edu.uptc.model.QueueTurn;
import co.edu.uptc.view.View;

public class Presenter {

    private QueueTurn turn;
    private View view;

    private final String MENU = "_______SISTEMA DE TURNOS______\n" +
            "1.Generar Turno\n" +
            "2.Siguiente Turno\n" + "3.Atender Turno\n" + "0.Salir\n";

    public Presenter() {
        turn = new QueueTurn();
        view = new View();
    }

    public int mostrarMenu() {
        int option = 0;
        try {
            option = Integer.parseInt(view.readData(MENU));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return option;
    }

    public void run() {
        int option = mostrarMenu();
        switch (option) {
            case 1:
                createTurn();
                break;
            case 2:
                showNextTurn();
                break;
            case 3:
                attendingTurn();
                break;
            case 0:
                view.showMessage("Fin del programa");
                System.exit(0);
                break;
            default:
                view.showMessage("Ingrese otra opcion");
                break;
        }
        do {
            run();
        } while (option != 4);
    }

    private void createTurn() {
        String name = view.readData("Ingrese el nombre del paciente");
        char category = selectCategory();
        Patient patient = new Patient(name, category);
        turn.crateTurnByCategory(patient);
    }

    private char selectCategory() {
        char category = view.readData("Ingrese la categoria del paciente: (A) Adulto Mayor, (E) Embarazada y  (G) Usuario General").charAt(0);
        while (category!='A' && category !='E'&& category !='G' ){
            view.showMessage("Categoria no valida");
            category = view.readData("Ingrese la categoria del paciente: (A) Adulto Mayor, (E) Embarazada y  (G) Usuario General").charAt(0);
        }
        return category;
    }

    private void showNextTurn() {
        view.showMessage("Turno Siguiente. Modulo de Atención: " + turn.showNextTurn());
    }

    private void attendingTurn() {
        if (turn.isEmpty()) {
            view.showMessage("No hay turnos por atender");
            return;
        }else{
            view.showMessage("Turno atendido: " + turn.attendTurn());
        }
    }

}
