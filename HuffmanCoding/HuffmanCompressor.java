import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HuffmanCompressor {

    public static void compress(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        int[] counts = new int[256];
        for(int c = br.read(); c != -1; c = br.read()) {
            counts[c]++;
        }
        HuffmanTree ht = new HuffmanTree(counts);
        ht.write(changeExt(filename, "code"));
        ht.encode(new BitOutputStream(changeExt(filename, "short")), filename);
    }

    public static void expand(String codeFile, String fileName) throws FileNotFoundException {
        HuffmanTree ht = new HuffmanTree(codeFile);
        ht.decode(new BitInputStream(fileName), changeExt(fileName, "new"));
    }

    private static String changeExt(String filename, String ext) {
        return filename.substring(0, filename.lastIndexOf('.') + 1) + ext;
    }

    public static void main(String[] args) throws IOException {
        String fileTitle = "Hamlet";
        compress("src/" + fileTitle + ".txt");
        expand("src/" + fileTitle + ".code", "src/" + fileTitle + ".short");
    }
}