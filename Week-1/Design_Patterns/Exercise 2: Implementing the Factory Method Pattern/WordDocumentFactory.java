package Week_1.Design_Patterns.Factory_Pattern;

public class WordDocumentFactory extends DocumentFactory {

    public Document createDocument(){
        return new WordDocument();
    }
}
