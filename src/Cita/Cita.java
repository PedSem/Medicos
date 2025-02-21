package Cita;

import java.util.Date;
    public class Cita {
        protected int ID_cita;
        protected Date fecha_cita;
        protected int hora_cita;
        protected String diagnosis;

        public Cita(int ID_cita, Date fecha_cita, int hora_cita, String diagnosis) {
            this.ID_cita = ID_cita;
            this.fecha_cita = fecha_cita;
            this.hora_cita = hora_cita;
            this.diagnosis=diagnosis;
        }

        public int getID_cita() {
            return ID_cita;
        }

        public Date getFecha_cita() {
            return fecha_cita;
        }
        public int getHora_cita() {
            return hora_cita;
        }
        public String getDiagnosis() {
            return diagnosis;
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
}
