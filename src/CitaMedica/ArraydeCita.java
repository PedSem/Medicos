package CitaMedica;
//Pedro Guillo

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class ArraydeCita {
    protected ArrayList<Cita>citas;

    public ArraydeCita() {
        this.citas=new ArrayList<>();
    }
    private  int findCita(Cita cita){
        int index= citas.indexOf(cita);
        return index;
    }
    private int findCita(int ID_cita){
        for(int i = 0; i< citas.size(); i++){
            if(citas.get(i).getID_cita()==ID_cita){
                return i;
            }
        }
        return -1;

    }

    public  boolean addNewCita(Cita cita){
        int index=findCita(cita);
        if(index==-1){
            citas.add(cita);
            return true;
        }else{
            return false;
        }
    }
    public  Cita queryCita(int ID_cita){
        int index=findCita(ID_cita);
        if(index>=0){
            return citas.get(index);
        }else{
            return null;
        }
    }
    public  boolean removeCita(Cita cita){
        int index=findCita(cita);
        if(index>=0){
            citas.remove(index);
            return true;
        }else{
            return false;
        }

    }
    public  boolean updatecita(Cita citanueva, Cita citaantigua){
        int index=findCita(citaantigua);
        if(index>=0){
            citas.set(index,citanueva);
            return true;
        }else{
            return false;
        }
    }
    public  void printcita(){
        System.out.println("Tenemos " + citas.size() + " elementos en el arraylist");
        for(int i = 0; i< citas.size(); i++){
            System.out.print((i+1) + ".");
            System.out.println("ID_cita:" + citas.get(i).getID_cita() + " Fecha_cita " + citas.get(i).getFecha_cita() + " Hora_cita " + citas.get(i).getHora_cita() + " Diagnosis " + citas.get(i).getDiagnosis());
        }

    }
    public void printXML(){
        if(citas.isEmpty()){
            System.out.println("No hay ninguna cita disponible");
        }else{
            System.out.println("<CITAS>");
            for(int i=0;i<citas.size();i++){
                System.out.println("<CITA>");
                System.out.println("<ID_cita>" + citas.get(i).getID_cita() + "</ID_cita>");
                System.out.println("<fecha_cita>" + citas.get(i).getFecha_cita() + "</fecha_cita>");
                System.out.println("<hora_cita>" + citas.get(i).getHora_cita() + "</hora_cita>");
                System.out.println("<ID_Consulta>" + citas.get(i).getDiagnosis() + "</ID_Consulta>");
                System.out.println("</CITA>");
                System.out.println();
            }
        }
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
    public void PrintXMLFichero(){
        if(citas.isEmpty()){
            System.out.println("No se encontro ninguna cita");
        }else{
            infoclase(citas);
            try{
                FileWriter fileWriter=new FileWriter("XML.txt");
                BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
                bufferedWriter.write("<Citas>\n");
                for(Cita cita:citas){
                    bufferedWriter.write("</Cita>\n");
                    bufferedWriter.write(" <ID_cita> " + cita.getID_cita() + " </ID_cita>\n");
                    bufferedWriter.write("<Fecha_cita> " + cita.getFecha_cita() + "</Fecha_cita>\n");
                    bufferedWriter.write("<hora_cita> " + cita.getHora_cita() + "</Hora_cita>\n");
                    bufferedWriter.write("<ID_Consulta> " + cita.getDiagnosis() + "</ID_Consulta>\n");
                    bufferedWriter.write("</Cita>\n");

                }
                bufferedWriter.write("</Citas>");
                bufferedWriter.close();

            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}

