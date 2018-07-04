package task2;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        try {
            Locale locale = new Locale("de");
            WorkWithProperties worker = new WorkWithProperties("MyBundle", locale);
            System.out.println(worker.getValue("1"));
        } catch (NoKeyException e) {
            System.out.println(e.toString());
        }catch (NoPropFileException e){
            System.out.println(e.toString());
        }
    }
}
