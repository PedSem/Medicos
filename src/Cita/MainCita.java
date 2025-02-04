package Cita;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainCita {

    public static void main(String[] args) {
        int ID_cita=0;
        int fecha_cita=0;
        int hora_cita=0;
        Scanner scanner=new Scanner(System.in);
        boolean continuar=true;

        do {

            try {
                System.out.print("Introduce el ID de la cita:");
                ID_cita = scanner.nextInt();
                System.out.print("Introduce la fecha de la cita:");
                fecha_cita= scanner.nextInt();
                System.out.print("Introduce la hora de la cita");
                hora_cita= scanner.nextInt();
                continuar=false;

            } catch (InputMismatchException e) {
                System.out.println("Error.Debes poner solo numeros");
                scanner.nextLine();

            }
        }while (continuar);
        System.out.println("ID_cita:" + ID_cita + " fecha_cita:" + fecha_cita + " hora_cita:" + hora_cita);

    }
}
