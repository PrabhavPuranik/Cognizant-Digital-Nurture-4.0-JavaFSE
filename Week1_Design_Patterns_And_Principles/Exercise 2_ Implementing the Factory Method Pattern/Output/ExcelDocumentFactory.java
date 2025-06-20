package Week_1.Design_Patterns.Factory_Pattern;

public class ExcelDocumentFactory extends DocumentFactory{

    public Document createDocument(){
        return new ExcelDocument();
    }
}
