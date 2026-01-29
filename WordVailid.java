public class WordVailid {
    private String[] words;
    private int wordCount;
    
    public WordVailid(int size) {
        this.words = new String[size];
        this.wordCount = 0;
    }
    
    public void storeWord(String word) {
        if (wordCount < words.length) {
            words[wordCount] = word;
            wordCount++;
        }
    }
    
    public boolean isValid(String s) {
        // Convert word string into character array
        char[] charArray = s.toCharArray();
        
        // Check if word length is <= 4
        if (charArray.length > 4) {
            return false;
        }
        
        // Check if each character in array is only a-z or A-Z
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        
        return true;
    }
    
    public void validateAllWords() {
        System.out.println("Validating all stored words:");
        for (int i = 0; i < wordCount; i++) {
            System.out.println(words[i] + " -> " + isValid(words[i]));
        }
    }
    
    public static void main(String[] args) {
        WordVailid wordVailid = new WordVailid(5);
        
        // Store words in array
        wordVailid.storeWord("Test");
        wordVailid.storeWord("Hello");
        wordVailid.storeWord("Hi1");
        wordVailid.storeWord("Java");
        wordVailid.storeWord("LongWord");
        
        // Validate all stored words
        wordVailid.validateAllWords();
    }
}