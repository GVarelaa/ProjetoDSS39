package RacingManagerUI;

import java.util.List;
import java.util.Scanner;

public class CircuitView {
    private Controller controller;
    private Scanner sc;

    public CircuitView(Controller sc, Scanner scanner) {
        this.controller = sc;
        this.sc = scanner;
    }

    public void run() {
        String circuitName = getName();
        int length = getLength();
        int numLaps = getNumLaps();
        int numCurves = getNumCurves();
        int numChicanes = getNumChicanes();

        try{
            this.controller.addCircuit(circuitName, length, numLaps, numCurves, numChicanes);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("\nCircuito adicionado à lista de circuitos disponíveis!");
        setGDUs(circuitName);
        System.out.println("\nCircuito registado com sucesso!");
    }

    private String getName() {
        System.out.print("Indique o nome do circuito: ");
        return sc.nextLine();
    }

    private int getLength() {
        System.out.print("Indique o comprimento do circuito em km: ");
        int len = sc.nextInt(); sc.nextLine();
        return len;
    }

    private int getNumLaps() {
        System.out.print("Indique o número de voltas do circuito: ");
        int numLaps = sc.nextInt(); sc.nextLine();
        return numLaps;
    }

    private int getNumCurves() {
        System.out.print("Indique o número de curvas do circuito: ");
        int numCurves = sc.nextInt(); sc.nextLine();
        return numCurves;
    }

    private int getNumChicanes() {
        System.out.print("Indique o número de chicanes do circuito: ");
        int numChicanes = sc.nextInt(); sc.nextLine();
        return numChicanes;
    }

    private int setGDU() {
        System.out.print("Indique o grau de dificuldade de ultrapassagem deste setor: ");
        int gdu = sc.nextInt();
        sc.nextLine();
        return gdu;
    }

    private void setGDUs(String circuitName) {
        List<String> sectors = this.controller.showCircuitSectors(circuitName);
        int i=0;

        for (String sector : sectors) {
            System.out.print("--------------");
            System.out.print(sector);
            System.out.print("--------------");
            int gdu = setGDU();

            this.controller.addSector(circuitName, gdu, i);
            i++;
        }
    }
}
