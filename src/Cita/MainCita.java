package Cita;
//Pedro Guillo
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainCita {
    private static Scanner scanner=new Scanner(System.in);
    private static ArrayList<ArrayListdeCita> arrayListdeCitas =new ArrayList<>();

    public static void main(String[] args) {
        boolean continuar=true;
        boolean entradavalida;
        int opcion=0;
        do{
            imprimirmenu();
            do{
                entradavalida=true;
                try{
                    System.out.println("Elige una opcion");
                    opcion= scanner.nextInt();
                    scanner.nextLine();
                    entradavalida=false;
                    if(opcion<0 || opcion>5){
                        entradavalida=true;
                        System.out.println("Introduce una opcion valida");
                        imprimirmenu();
                    }
                }catch (InputMismatchException e){
                    System.out.println("Error.Solo se permiten numeros");
                    scanner.nextLine();
                }
            }while (entradavalida);
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
                    printcita();
                    break;
            }



        }while (continuar);

    }
    public static void printcita(){
        System.out.println("Tenemos " + arrayListdeCitas.size() + " elementos en el arraylist");
        for(int i = 0; i< arrayListdeCitas.size(); i++){
            System.out.print((i+1) + ".");
            System.out.println("ID_cita:" + arrayListdeCitas.get(i).getID_cita() + " Fecha_cita " + arrayListdeCitas.get(i).getFecha_cita() + " Hora_cita " + arrayListdeCitas.get(i).getHora_cita() + " Diagnosis " + arrayListdeCitas.get(i).getDiagnosis());
        }

    }
    public static void imprimirmenu(){
        System.out.println("0-Salir");
        System.out.println("1-Añadir cita");
        System.out.println("2-Eliminar cita");
        System.out.println("3-Actualizar cita");
        System.out.println("4-Consultar citas");
        System.out.println("5-Imprimir citas");
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
                System.out.print("Introduce la fecha de la cita:");
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
        ArrayListdeCita arrayListdeCita = ArrayListdeCita.cita(ID_cita,fechacita,hora_cita,diagnosis);
        boolean resultadocita=addNewCita(arrayListdeCita);
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
        ArrayListdeCita arrayListdeCita =queryCita(ID_cita);
        if(arrayListdeCita !=null){
            boolean removercita=removeCita(arrayListdeCita);
            if(removercita){
                System.out.println("La cita se elimino correctamente");
            }else{
                System.out.println("No se pudo eliminar la cita");
            }
        }else{
            System.out.println("No se encontro la cita");
        }
    }
    private static int findCita(ArrayListdeCita arrayListdeCita){
        int index= arrayListdeCitas.indexOf(arrayListdeCita);
        return index;
    }
    private static int findCita(int ID_cita){
        for(int i = 0; i< arrayListdeCitas.size(); i++){
            if(arrayListdeCitas.get(i).getID_cita()==ID_cita){
                return i;
            }
        }
        return -1;

    }
    public static boolean addNewCita(ArrayListdeCita arrayListdeCita){
        int index=findCita(arrayListdeCita);
        if(index==-1){
            arrayListdeCitas.add(arrayListdeCita);
            return true;
        }else{
            return false;
        }
    }
    public static ArrayListdeCita queryCita(int ID_cita){
        int index=findCita(ID_cita);
        if(index>=0){
            return arrayListdeCitas.get(index);
        }else{
            return null;
        }
    }
    public static boolean removeCita(ArrayListdeCita arrayListdeCita){
        int index=findCita(arrayListdeCita);
        if(index>=0){
            arrayListdeCitas.remove(index);
            return true;
        }else{
            return false;
        }

    }
    public static boolean updatecita(ArrayListdeCita citanueva, ArrayListdeCita citaantigua){
        int index=findCita(citaantigua);
        if(index>=0){
            arrayListdeCitas.set(index,citanueva);
            return true;
        }else{
            return false;
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
        ArrayListdeCita arrayListdeCita =queryCita(ID_cita);
        if(arrayListdeCita !=null){
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
            ArrayListdeCita arrayListdeCita1 = ArrayListdeCita.cita(nuevaID_cita,fechacita,nuevahora_cita,nuevodiagnosis);
            boolean updateContact=updatecita(arrayListdeCita1, arrayListdeCita);
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
        ArrayListdeCita encontrarArrayListdeCita =queryCita(ID_cita);
        if(encontrarArrayListdeCita !=null){
            System.out.println("Cita encontrada: ID_Cita:" + encontrarArrayListdeCita.getID_cita() + " Fecha_Cita:" + encontrarArrayListdeCita.getFecha_cita() + " Hora_Cita:" + encontrarArrayListdeCita.getHora_cita() + " Diagnosis:" + encontrarArrayListdeCita.getDiagnosis() );
        }else{
            System.out.println("No se encontro la cita");
        }


    }


}
