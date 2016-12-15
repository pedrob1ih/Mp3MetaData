package mp3metadata;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;


public class Mp3MetaData {

        public static void main(String[] args) {
        try {
            org.farng.mp3.MP3File mp3= new MP3File(new File("C:\\Users\\pedro\\Desktop\\cancion.mp3"));
            mp3.getID3v2Tag().setSongGenre("xxx");
            mp3.save();
            
        }
        catch (IOException ex) {
            Logger.getLogger(Mp3MetaData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TagException ex) {
            Logger.getLogger(Mp3MetaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}