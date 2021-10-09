import java.util.*;

class Sentence
{
    private String plainText;
    private static WordToken toBeCapitalized;
    private int index;
    public Sentence(String plainText)
    {
        this.plainText = plainText;
        // todo
    }

    public WordToken getWord(int index)
    {
        // todo
        WordToken wt = new WordToken();
        String[] split = plainText.split(" ");
        wt.setWord(split[index]);
        wt.setIndex(index);
        this.index = index;
        return wt;
    }

    @Override
    public String toString()
    {
        // todo
        StringBuilder builder = new StringBuilder();
        String[] split = plainText.split(" ");
        for (int i=0; i< split.length;i++) {
            if(index==i){
                builder.append(split[i].toUpperCase());
            }else {
                builder.append(split[i]);
            }
            builder.append(" ");
        }

        return builder.toString().trim();
    }

    class WordToken
    {
        public boolean isCapitalize() {
            return capitalize;
        }

        public void setCapitalize(boolean capitalize) {
            this.capitalize = capitalize;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public boolean capitalize;
        private String word;
        private int index;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public WordToken() {

        }
    }
}