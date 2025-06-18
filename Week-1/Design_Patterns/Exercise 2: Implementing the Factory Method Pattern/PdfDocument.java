package Week_1.Design_Patterns.Factory_Pattern;

public class PdfDocument implements Document{

    public PdfDocument(){
        System.out.println("Created PDF Document.");
    }

    public void open(){
        System.out.println("Opening PDF Document.");
    }
    public void save(){
        System.out.println("Saving PDF Document.");
    }
    public void close(){
        System.out.println("Closing PDF Document.");
    }
}
