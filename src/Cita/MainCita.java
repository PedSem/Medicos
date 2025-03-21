package Cita;

//Pedro Guillo

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainCita {
    private static Scanner scanner=new Scanner(System.in);
    protected static ArraydeCita arraydeCita=new ArraydeCita();

    public static void main(String[] args) {
        boolean continuar=true;
        boolean entradavalida;
        int opcion=0;
        do{
            imprimirmenu();
            do{
                entradavalida=false;
                try{
                    System.out.print("Elige una opcion:");
                    opcion= scanner.nextInt();
                    scanner.nextLine();
                    entradavalida=true;
                    if(opcion<0 || opcion>6){
                        entradavalida=false;
                        System.out.println("Introduce una opcion valida");
                        imprimirmenu();
                    }
                }catch (InputMismatchException e){
                    System.out.println("Error.Solo se permiten numeros");
                    scanner.nextLine();
                }
            }while (!entradavalida);
            switch (opcion){
                case 0:
                    System.out.println("Has salido con exito");
                    continuar=false;
                    break;
                case 1:
                    AnyadirCita();
                    break;
                case 2:
                    removecita();
                    break;
                case 3:
                    updateCita();
                    break;
                case 4:
                    ConsultarCita();
                    break;
                case 5:
                    arraydeCita.printcita();
                    break;
                case 6:
                    arraydeCita.printXML();
                    break;
            }
        }while (continuar);

    }
    public static void imprimirmenu(){
        System.out.println("0-Salir");
        System.out.println("1-Añadir cita");
        System.out.println("2-Eliminar cita");
        System.out.println("3-Actualizar cita");
        System.out.println("4-Consultar citas");
        System.out.println("5-Imprimir citas");
        System.out.println("6-Imprimir citas en XML");
    }
    public static void AnyadirCita(){
        int ID_cita=0;
        String fecha_cita;
        int hora_cita=0;
        Date fechacita=new Date();
        String diagnosis="";
        boolean continuar=false;
        do {
            try {
                System.out.print("Introduce el ID de la cita:");
                ID_cita = scanner.nextInt();
                continuar=true;

            } catch (InputMismatchException e) {
                System.out.println("Error.Debes poner solo numeros");
                scanner.nextLine();

            }
        }while (!continuar);
        continuar=false;
        do{
            try{
                System.out.print("Introduce la fecha de la cita(dd/MM/yyyy):");
                fecha_cita= scanner.next();
                SimpleDateFormat fecha=new SimpleDateFormat("dd/MM/yyyy");
                fechacita= fecha.parse(fecha_cita);
                continuar=true;
            }catch (InputMismatchException e){
                System.out.println("Error.Debes poner solo numeros");
            } catch (ParseException e) {
                System.out.println("Introduce una fecha valida");
            }
        }while (!continuar);
        continuar=false;
        do{
            try{
                System.out.print("Introduce la hora de la cita:");
                hora_cita= scanner.nextInt();
                continuar=true;
            }catch (InputMismatchException e){
                System.out.println("Error.Debes poner solo numeros");
                scanner.nextLine();
            }
        }while (!continuar);

        continuar=false;
        do{
            try{
                System.out.print("Introduce el diagnosis:");
                diagnosis= scanner.next();
                Integer.parseInt(diagnosis);
                System.out.println("Error.Solo se permiten caracteres");
            }catch (NumberFormatException e){
                continuar=true;
                scanner.nextLine();
            }
        }while (!continuar);
        Cita cita = Cita.createCita(ID_cita,fechacita,hora_cita,diagnosis);
        boolean resultadocita=arraydeCita.addNewCita(cita);
        if(resultadocita){
            System.out.println("Se agrego correctamente la cita");
        }else{
            System.out.println("No se pudo agregar la cita");
        }

    }
    public static void removecita(){
        int ID_cita=0;
        boolean continuar=false;
        do{
            try{
                System.out.println("Introduce el ID_cita que quieres eliminar");
                ID_cita= scanner.nextInt();
                continuar=true;
            }catch (InputMismatchException e){
                System.out.println("Error.Solo se permiten numeros");
                scanner.nextLine();
            }
        }while (!continuar);
        Cita cita =arraydeCita.queryCita(ID_cita);
        if(cita!=null){
            boolean removercita=arraydeCita.removeCita(cita);
            if(removercita){
                System.out.println("La cita se elimino correctamente");
            }else{
                System.out.println("No se pudo eliminar la cita");
            }
        }else{
            System.out.println("No se encontro la cita");
        }
    }

    public static void updateCita(){
        int ID_cita=0;
        int nuevaID_cita=0;
        String nuevafecha_cita;
        Date fechacita=new Date();
        int nuevahora_cita=0;
        String nuevodiagnosis="";
        boolean continuar=false;
        do {
            try {
                System.out.print("Introduce el ID de la cita que deseas actualizar:");
                ID_cita = scanner.nextInt();
                continuar=true;

            } catch (InputMismatchException e) {
                System.out.println("Error.Debes poner solo numeros");
                scanner.nextLine();

            }
        }while (!continuar);
        Cita citaantigua =arraydeCita.queryCita(ID_cita);
        if(citaantigua !=null){
            continuar=false;
            do {
                try {
                    System.out.print("Introduce la nueva ID de la cita:");
                    nuevaID_cita = scanner.nextInt();
                    continuar=true;

                } catch (InputMismatchException e) {
                    System.out.println("Error.Debes poner solo numeros");
                    scanner.nextLine();

                }
            }while (!continuar);
            continuar=false;
            do{
                try{
                    System.out.print("Introduce la nueva fecha de la cita:");
                    nuevafecha_cita= scanner.next();
                    SimpleDateFormat fecha=new SimpleDateFormat("dd/MM/yyyy");
                    fechacita= fecha.parse(nuevafecha_cita);
                    continuar=true;
                }catch (InputMismatchException e){
                    System.out.println("Error.Debes poner solo numeros");
                } catch (ParseException e) {
                    System.out.println("Error.Introduce una fecha valida");
                }
            }while (!continuar);
            continuar=false;
            do{
                try{
                    System.out.print("Introduce la nueva hora de la cita:");
                    nuevahora_cita= scanner.nextInt();
                    continuar=true;
                }catch (InputMismatchException e){
                    System.out.println("Error.Debes poner solo numeros");
                    scanner.nextLine();
                }
            }while (!continuar);
            continuar=false;
            do{
                try{
                    System.out.print("Introduce el nuevo diagnosis:");
                    nuevodiagnosis= scanner.next();
                    Integer.parseInt(nuevodiagnosis);
                    System.out.println("Error.Solo se permiten caracteres");
                }catch (NumberFormatException e){
                    continuar=true;
                    scanner.nextLine();
                }
            }while (!continuar);
            Cita citanueva = Cita.createCita(nuevaID_cita,fechacita,nuevahora_cita,nuevodiagnosis);
            boolean updateContact=arraydeCita.updatecita(citanueva, citaantigua);
            if(updateContact){
                System.out.println("La cita se actualizo correctamente");
            }else{
                System.out.println("La cita no se actualizo");
            }


        }else{
            System.out.println("No se encontro la cita");
        }

    }
    public static void ConsultarCita(){
        int ID_cita=0;
        boolean continuar=false;
        do{
            try{
                System.out.println("Introduce el ID_cita que quieres consultar");
                ID_cita= scanner.nextInt();
                continuar=true;

            }catch (InputMismatchException e){
                System.out.println("Error.Solo se permiten numeros");
                scanner.nextLine();
            }
        }while (!continuar);
        Cita encontrarcita =arraydeCita.queryCita(ID_cita);
        if(encontrarcita !=null){
            System.out.println("Cita encontrada: ID_Cita:" + encontrarcita.getID_cita() + " Fecha_Cita:" + encontrarcita.getFecha_cita() + " Hora_Cita:" + encontrarcita.getHora_cita() + " Diagnosis:" + encontrarcita.getDiagnosis() );
        }else{
            System.out.println("No se encontro la cita");
        }


    }


}
