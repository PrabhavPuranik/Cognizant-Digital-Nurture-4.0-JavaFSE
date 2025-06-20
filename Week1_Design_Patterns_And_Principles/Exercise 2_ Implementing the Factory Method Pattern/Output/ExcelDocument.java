package Week_1.Design_Patterns.Factory_Pattern;

public class ExcelDocument implements Document{

    public ExcelDocument(){
        System.out.println("Created Excel Document.");
    }

    public void open(){
        System.out.println("Opening Excel Document.");
    }
    public void save(){
        System.out.println("Saving Excel Document.");
    }
    public void close(){
        System.out.println("Closing Excel Document.");
    }
}
