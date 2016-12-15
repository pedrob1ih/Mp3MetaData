package mp3metadata;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.farng.mp3.id3.AbstractID3v2;



public class Metadata {
    
    private ArrayList<MP3File> lMP3s;

    public Metadata(String musicFolder) throws IOException, TagException {
        File lFiles[]=new File(musicFolder).listFiles();
        lMP3s= new ArrayList<>();
        for (int i = 0; i < lFiles.length; i++) {
            lMP3s.add(new MP3File(lFiles[i]));
        }        
    }

    public ArrayList<MP3File> getlMP3s() {
        return lMP3s;
    }
    
    
    private enum tagType{AlbumTitle, SongComment, AuthorComposer,
        DuplicateFrameId, Identifier, LeadArtist, SongGenre, SongLyric,
        SongTitle, TrackNumberOnAlbum, Size}
    
    //editar metadatos
    public static void editTags(){
        
    }
    
    public void exportBy(tagType by,String paht) throws IOException {
        switch(by){
            case AlbumTitle:
                copyFiles(getFilesBy(by.toString()), paht);
                //methot to get a List of mp3s
                //methot to copy to a folder the list
            break;
            case SongComment:
                
            break;
            case AuthorComposer:
                
            break;
            case DuplicateFrameId:
                
            break;
            case Identifier:
                
            break;
            case LeadArtist:
                
            break;
            case SongGenre:
                
            break;
            case SongLyric:
                
            break;
            case SongTitle:
                
            break;
            case TrackNumberOnAlbum:
                
            break;
            case Size:
                
            break;
        }
    }
    
    private ArrayList<MP3File> getFilesBy(String by){
        ArrayList<ArrayList> lTypes= new ArrayList<>();
        
        ArrayList<MP3File> l= new ArrayList<>();
        for (MP3File mP3File : l) {
            
        }
        return l;
    }
    
    private int copyFiles(ArrayList<MP3File> l,String paht) throws IOException{
        int i=0;
        for (MP3File mP3File : l) {            
            Files.copy(mP3File.getMp3file().toPath(), new File(paht+mP3File.getMp3file().getName()).toPath());   
            i++;
        }
        return i;
    }
    
    public static void showTags(MP3File mp3) {
        AbstractID3v2 mp3TagsV2=mp3.getID3v2Tag();
        System.out.println("Album "+mp3TagsV2.getAlbumTitle());
        System.out.println("Comment "+mp3TagsV2.getSongComment());            
        System.out.println("getAuthorComposer "+mp3TagsV2.getAuthorComposer());            
        System.out.println("getDuplicateFrameId "+mp3TagsV2.getDuplicateFrameId());            
        System.out.println("getIdentifier "+mp3TagsV2.getIdentifier());            
        System.out.println("getLeadArtist "+mp3TagsV2.getLeadArtist());
        System.out.println("getSongComment "+mp3TagsV2.getSongComment());
        System.out.println("getSongGenre "+mp3TagsV2.getSongGenre());
        System.out.println("getSongLyric "+mp3TagsV2.getSongLyric());
        System.out.println("getSongTitle "+mp3TagsV2.getSongTitle());
        System.out.println("getTrackNumberOnAlbum "+mp3TagsV2.getTrackNumberOnAlbum());
        System.out.println("getYearReleased "+mp3TagsV2.getYearReleased());
        System.out.println("getSize "+mp3TagsV2.getSize());        
    }
    //buscar por metadatos
    public static void searchByTags(String str){
        
    }
    
}
