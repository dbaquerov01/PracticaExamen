import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Scanner;
public class Programa {
    static Scanner teclado = new Scanner(System.in);
    static DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static void main(String[] args) {
        Monstruo m1 = new Monstruo(pedirTexto(), pedirDouble(), pedirFecha());
        Monstruo m2 = crearMonstruo();
        mostrarMonstruo(m1);
        mostrarMonstruo(m2);
        teclado.close();
    }

    static String pedirTexto(){
        String texto;
        System.out.print("\n\tIntroduce el texto deseado: ");
        texto = teclado.nextLine();
        return texto;
    }

    static Double pedirDouble(){
        Double numero = 0.00;
        Boolean validado = false;
        do{
            try{
                System.out.print("\n\tIntroduce el numero con formato(0.00) deseado: ");
                numero = Double.valueOf(teclado.nextLine());
                validado= true;
            }
            catch(Exception e){
                System.out.println("\n\tError inesperado. Vuelva a intentar.");
            }
        }while(!validado);
        return numero;
    }

    static LocalDate pedirFecha(){
        String fecha;
        LocalDate fechaParseada = null;
        Boolean validado = false;
        do{
            try{
                System.out.print("\n\tIntroduce la fecha con formato DD/MM/YYY: ");
                fecha = teclado.nextLine();
                fechaParseada = LocalDate.parse(fecha, formateador);
                validado = true;
            }
            catch(Exception e){
                System.out.println("\n\tError inesperado. Vuelva a intentar.");
            }
        }while(!validado);
        return fechaParseada;
    }

    static Monstruo crearMonstruo(){
        String nombre;
        System.out.print("\n\tIntroduce el nombre del monstruo: ");
        nombre = teclado.nextLine().trim();
        Double peso = 0.00;
        Boolean validado = false;
        do{
            try{
                System.out.print("\n\tIntroduce el peso del monstruo: ");
                peso = Double.valueOf(teclado.nextLine().trim());
                validado= true;
            }
            catch(Exception e){
                System.out.println("\n\tError inesperado. Vuelva a intentar.");
            }
        }while(!validado);
        String fecha;
        LocalDate fechaParseada = null;
        validado = false;
        do{
            try{
                System.out.print("\n\tIntroduce la fecha de nacimiento del mostruo con formato DD/MM/YYY: ");
                fecha = teclado.nextLine().trim();
                fechaParseada = LocalDate.parse(fecha, formateador);
                validado = true;
            }
            catch(Exception e){
                System.out.println("\n\tError inesperado. Vuelva a intentar.");
            }
        }while(!validado);
        Monstruo monstruo = new Monstruo(nombre, peso, fechaParseada);
        return monstruo;
    }

    static void mostrarMonstruo(Monstruo monstruo){
        System.out.println("\n\n\t=== DATOS DEL MOSTRUO ===");
        System.out.println("\n\tEl nombre del monstruo es: " + monstruo.nombre);
        System.out.println("\n\tEl peso del monstruo es: " + monstruo.peso);
        System.out.println("\n\tLa fecha de nacimiento del monstruo es: " + monstruo.fechaNacimiento.format(formateador));
    }
}
