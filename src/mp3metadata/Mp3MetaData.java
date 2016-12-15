package mp3metadata;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;

public class Mp3MetaData {

        public static void main(String[] args) {
        try {
            Metadata m= new Metadata("D:\\musica\\penCoche\\nuevas");
            for (MP3File mp3 : m.getlMP3s()) {
                System.out.println(mp3.getMp3file().toPath());
            }
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
//            File song =new File("cancion.mp3");
//            org.farng.mp3.MP3File mp3= new MP3File(song);
//            Metadata.showTags(mp3);
            
            
            
//            mp3.getID3v2Tag().setSongGenre("xxx");
//            mp3.save();
            
//            Files.copy(song.toPath(), new File("C:\\Users\\pedro\\Desktop\\copia.mp3").toPath(),StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(song.toPath(), new File("C:\\Users\\pedro\\Desktop\\copia.mp3").toPath());
            
        }   catch (IOException ex) {
                Logger.getLogger(Mp3MetaData.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TagException ex) {
                Logger.getLogger(Mp3MetaData.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
}