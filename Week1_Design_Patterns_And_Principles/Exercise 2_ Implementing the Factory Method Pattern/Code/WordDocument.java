package Week_1.Design_Patterns.Factory_Pattern;

public class WordDocument implements Document {

    public WordDocument(){
        System.out.println("Created Word Document.");
    }

    public void open(){
        System.out.println("Opening Word Document.");
    }
    public void save(){
        System.out.println("Saving Word Document.");
    }
    public void close(){
        System.out.println("Closing Word Document.");
    }
}
