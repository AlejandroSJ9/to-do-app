import com.alejo.to_do_app.model.Conection;

import java.sql.Connection;

public class Main {
    public static void main (String[] args) {
        System.out.println("Hola");
        Conection conection = new Conection();
        try{
            Connection cnx = conection.getConection();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
