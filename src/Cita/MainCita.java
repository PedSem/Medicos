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
    private static ArrayList<Cita>citas=new ArrayList<>();

    public static void main(String[] args) {

        boolean continuar=true;
        int opcion=0;
        do{
            imprimirmenu();
            try{
                System.out.println("Elige una opcion");
                opcion= scanner.nextInt();
                scanner.nextLine();
                if(opcion<0 || opcion>5){
                    System.out.println("Escoge una opcion valida");
                    continuar=false;
                }


            }catch (InputMismatchException e){
                System.out.println("Error.Solo se permiten numeros");
                scanner.nextLine();
            }
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
                    imprimircita();
                    break;

            }



        }while ((opcion<0 || opcion>5) || continuar);

    }
    public static void imprimircita(){
        System.out.println("Tenemos " + citas.size() + " elementos en el arraylist");
        for(int i=0;i<citas.size();i++){
            System.out.print((i+1) + ".");
            System.out.println("ID_cita:" + citas.get(i).getID_cita() + " Fecha_cita " + citas.get(i).getFecha_cita() + " Hora_cita " + citas.get(i).getHora_cita() + " Diagnosis " + citas.get(i).getDiagnosis());
        }

    }
    public static void imprimirmenu(){
        System.out.println("0-Salir");
        System.out.println("1-Añadir Cita");
        System.out.println("2-Eliminar cita");
        System.out.println("3-Actualizar cita");
        System.out.println("4-Consultar cita");
        System.out.println("5-Imprimir cita");
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
                throw new RuntimeException(e);
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
                for(int i=0;i<diagnosis.length();i++){
                    if(Character.isLetter(diagnosis.charAt(i))){
                        continuar=true;
                    }else{
                        System.out.println("Error.Solo se permite caracteres");
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Error.Solo se permite caracteres");
                scanner.nextLine();
            }
        }while (!continuar);
        Cita cita=Cita.cita(ID_cita,fechacita,hora_cita,diagnosis);
        boolean resultadocita=addCita(cita);
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
        Cita cita=queryCita(ID_cita);
        if(cita!=null){
            boolean removercita=removeCita(cita);
            if(removercita){
                System.out.println("La cita se elimino correctamente");
            }else{
                System.out.println("No se pudo eliminar la cita");
            }
        }else{
            System.out.println("No se encontro la cita");
        }
    }
    private static int findCita(Cita cita){
        int index=citas.indexOf(cita);
        return index;
    }
    private static int findCita(int ID_cita){
        for(int i=0;i<citas.size();i++){
            if(citas.get(i).getID_cita()==ID_cita){
                return i;
            }
        }
        return -1;

    }
    public static boolean addCita(Cita cita){
        int index=findCita(cita);
        if(index==-1){
            citas.add(cita);
            return true;
        }else{
            return false;
        }
    }
    public static Cita queryCita(int ID_cita){
        int index=findCita(ID_cita);
        if(index>=0){
            return citas.get(index);
        }else{
            return null;
        }
    }
    public static boolean removeCita(Cita cita){
        int index=findCita(cita);
        if(index>=0){
            citas.remove(index);
            return true;
        }else{
            return false;
        }

    }
    public static boolean updatecita(Cita citanueva,Cita citaantigua){
        int index=findCita(citaantigua);
        if(index>=0){
            citas.set(index,citanueva);
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
        Cita cita=queryCita(ID_cita);
        if(cita!=null){
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
                    System.out.print("Introduce la fecha de la cita:");
                    nuevafecha_cita= scanner.next();
                    SimpleDateFormat fecha=new SimpleDateFormat("dd/MM/yyyy");
                    fechacita= fecha.parse(nuevafecha_cita);
                    continuar=true;
                }catch (InputMismatchException e){
                    System.out.println("Error.Debes poner solo numeros");
                } catch (ParseException e) {
                    throw new RuntimeException(e);
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
                    for(int i=0;i<nuevodiagnosis.length();i++){
                        if(Character.isLetter(nuevodiagnosis.charAt(i))){
                            continuar=true;
                        }else{
                            System.out.println("Error.Solo se permite caracteres");
                        }
                    }
                }catch (NumberFormatException e){
                    System.out.println("Error.Solo se permite caracteres");
                    scanner.nextLine();
                }
            }while (!continuar);
            Cita cita1=Cita.cita(nuevaID_cita,fechacita,nuevahora_cita,nuevodiagnosis);
            boolean updateContact=updatecita(cita1,cita);
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

            }catch (InputMismatchException e){
                System.out.println("Error.Solo se permiten numeros");
                scanner.nextLine();
                continuar=true;
            }
        }while (continuar);
        Cita EncontrarCita=queryCita(ID_cita);
        if(EncontrarCita!=null){
            System.out.println("Cita encontrada: ID_Cita:" + EncontrarCita.getID_cita() + " Fecha_Cita:" + EncontrarCita.getFecha_cita() + " Hora_Cita:" + EncontrarCita.getHora_cita() + " Diagnosis:" + EncontrarCita.getDiagnosis() );
        }


    }


}
