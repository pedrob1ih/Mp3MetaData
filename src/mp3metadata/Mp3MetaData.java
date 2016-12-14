package mp3metadata;

import java.io.File;
import org.blinkenlights.jid3.ID3Exception;
import org.blinkenlights.jid3.MP3File;
import org.blinkenlights.jid3.MediaFile;
import org.blinkenlights.jid3.v1.ID3V1Tag;
import org.blinkenlights.jid3.v1.ID3V1_0Tag;
import org.blinkenlights.jid3.v2.ID3V2_3_0Tag;
import org.blinkenlights.jid3.v2.TIT2TextInformationID3V2Frame;
import org.blinkenlights.jid3.v2.TPE1TextInformationID3V2Frame;
import org.blinkenlights.jid3.v2.TRCKTextInformationID3V2Frame;


public class Mp3MetaData {

    public static void main(String[] args) throws ID3Exception {
//            MP3File mp3F= new MP3File(new File("/home/pedroaznar/Desktop/Mp3MetaData/bonita.mp3"));
//        // the file we are going to modify
        File oSourceFile = new File("/home/pedroaznar/Desktop/Mp3MetaData/bonita.mp3");

        // create an MP3File object representing our chosen file
        MediaFile oMediaFile = new MP3File(oSourceFile);

        // create a v1.0 tag object, and set some values
        ID3V1_0Tag oID3V1_0Tag = new ID3V1_0Tag();
        System.out.println(oMediaFile.getID3V1Tag().getAlbum());
        oID3V1_0Tag.setAlbum("holana");
        oID3V1_0Tag.setArtist("Artist");
        oID3V1_0Tag.setComment("Comment");
        oID3V1_0Tag.setGenre(ID3V1Tag.Genre.Blues);
        oID3V1_0Tag.setTitle("Title");
        oID3V1_0Tag.setYear("1999");
       
        // set this v1.0 tag in the media file object
        oMediaFile.setID3Tag(oID3V1_0Tag);
       
        // create a v2.3.0 tag object, and set some frames
        ID3V2_3_0Tag oID3V2_3_0Tag = new ID3V2_3_0Tag();
        TPE1TextInformationID3V2Frame oTPE1 = new TPE1TextInformationID3V2Frame("Lead Performer");
        oID3V2_3_0Tag.setTPE1TextInformationFrame(oTPE1);
        TRCKTextInformationID3V2Frame oTRCK = new TRCKTextInformationID3V2Frame(3, 9);
        oID3V2_3_0Tag.setTRCKTextInformationFrame(oTRCK);
        TIT2TextInformationID3V2Frame oTIT2 = new TIT2TextInformationID3V2Frame("Song Title");
        oID3V2_3_0Tag.setTIT2TextInformationFrame(oTIT2);
       
        // set this v2.3.0 tag in the media file object
        oMediaFile.setID3Tag(oID3V2_3_0Tag);
       
        // update the actual file to reflect the current state of our object 
        oMediaFile.sync();
    }
    
}
