package Cita;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


public class EscribirXML {
    public static void main(String[] args) {
        Date fechacita=new Date();
        int ID_cita=0,hora_cita=0;
        String diagnosis="";



    }
    public static void infoclase(Object o){
        Class<?>c;
        c=o.getClass();
        System.out.println("Nombre de la clase:" + c.getName());
        System.out.println("Nombre del paquete:" + c.getPackage().getName());
        System.out.println("Hereda de la clase:" + c.getSuperclass().getName());
        for(int i=0;i<c.getDeclaredFields().length;i++){
            System.out.println("\t" + "" +c.getDeclaredFields()[i].getName() + "" + c.getDeclaredFields()[i].getType().getName());

        }
    }
    public void EscribirFichero(int ID_cita,Date fechacita,int hora_cita,String diagnosis){
        Scanner scanner=new Scanner(System.in);
       String fecha_cita;
        boolean continuar=false;

        try{
            FileOutputStream fileOutputStream=new FileOutputStream("XML.txt");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
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
            do{
                    System.out.print("Introduce el diagnosis:");
                    diagnosis= scanner.next();
            }while (!ValidarLetras(diagnosis));
            Cita cita=Cita.createCita(ID_cita,fechacita,hora_cita,diagnosis);
            objectOutputStream.writeObject(cita);

        }catch (IOException e){
            e.printStackTrace();
        }


    }
    public boolean ValidarLetras(String nombre){
        for(int i=0;i<nombre.length();i++){
            if(!Character.isLetter(nombre.charAt(i))){
                System.out.println("Solo se permiten caracteres");
                return false;
            }
        }
        return true;
    }


}
