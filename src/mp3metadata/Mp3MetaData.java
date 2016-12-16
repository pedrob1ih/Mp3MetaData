package mp3metadata;

import org.farng.mp3.MP3File;

public class Mp3MetaData {

        public static void main(String[] args) throws InterruptedException {
//        try {
            Metadata m = new Metadata("/home/pedroaznar/Desktop/dora/musica");
//            m.exportBy(Metadata.tagType.SongGenre, "");
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
            
//        catch (IOException ex) {
//                Logger.getLogger(Mp3MetaData.class.getName()).log(Level.SEVERE, null, ex);
//            }
            System.out.println("main finalizado");
        }
    
}