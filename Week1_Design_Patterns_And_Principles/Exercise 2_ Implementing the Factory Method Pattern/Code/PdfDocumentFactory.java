package Week_1.Design_Patterns.Factory_Pattern;

public class PdfDocumentFactory extends DocumentFactory{

    public Document createDocument(){
        return new PdfDocument();
    }
}
