package mp3metadata;

import java.io.File;
import org.blinkenlights.jid3.MP3File;


public class Mp3MetaData {

    public static void main(String[] args) {
        org.blinkenlights.jid3.MP3File mp3F= new MP3File(new File("bonita.mp3"));
        
    }
    
}
