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
    private String musicFolder;
    private ThreadMetadata tM;
    private ArrayList<String> lTypes;
    private ArrayList<ArrayList> lMp3BT;
    public enum tagType{AlbumTitle, SongComment, AuthorComposer,
        DuplicateFrameId, Identifier, LeadArtist, SongGenre, SongLyric,
        SongTitle, TrackNumberOnAlbum, Size}
    

    public Metadata( String musicFolder) {
        this.lMP3s = new ArrayList();
        this.musicFolder = musicFolder;
        this.tM= new ThreadMetadata(this);
        lTypes= new ArrayList<>();
    }

    public void scanMp3() throws IOException, TagException{
        String lFiles[]=new File(musicFolder).list();
        
        for (String lFile : lFiles) {
            if(lFile.endsWith(".mp3") || lFile.endsWith(".flac") ||lFile.endsWith(".aiff")|| lFile.endsWith(".m4a")||lFile.endsWith(".wav")){
                String pahtSong=musicFolder+"/"+lFile;
                File fileCambiado=eraseParuntesis(pahtSong);
                //System.out.println("fileCambiado: "+fileCambiado.getAbsolutePath());
                lMP3s.add(new MP3File(fileCambiado));
            }
            else{
                scanMp3(musicFolder+"/"+lFile);
            }
        }
    }
    
    public void scanMp3(String musicFolder) throws IOException, TagException{
        String lFiles[]=new File(musicFolder).list();
        
        for (String lFile : lFiles) {
            if(lFile.endsWith(".mp3") || lFile.endsWith(".flac") ||lFile.endsWith(".aiff")|| lFile.endsWith(".m4a")||lFile.endsWith(".wav")){
                String pahtSong=musicFolder+"/"+lFile;
                File fileCambiado=eraseParuntesis(pahtSong);
                //System.out.println("fileCambiado: "+fileCambiado.getAbsolutePath());
                lMP3s.add(new MP3File(fileCambiado));
            }
            else{
                scanMp3(musicFolder+"/"+lFile);
            }
        }
    }
    
    public void exportBy(tagType by,String paht) throws IOException {
        switch(by){
            case AlbumTitle:
                scanTagTypeInFolder(by);
                for (String lType : lTypes) {
                    getFilesBy(by);
                    for (ArrayList l : lMp3BT) {
                        //System.out.println("By : "+by);
                        for (Object o : l) {
                            //System.out.println(((MP3File)o).getID3v2Tag().getSongTitle());
                        }
                    }
                    //copyFiles(getFilesBy(by));
                }
                
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
    
    private void scanTagTypeInFolder(tagType by){
        switch(by){
            case AlbumTitle:
                for (MP3File lMP3 : lMP3s) {
                    String byy=lMP3.getID3v2Tag().getAlbumTitle();
                    if(!lTypes.contains(byy))
                        lTypes.add(byy);
                }
            break;
            case SongComment:
                for (MP3File lMP3 : lMP3s) {
                    String byy=lMP3.getID3v2Tag().getSongComment();
                    if(!lTypes.contains(byy))
                        lTypes.add(byy);
                }
            break;
            case AuthorComposer:
                for (MP3File lMP3 : lMP3s) {
                    String byy=lMP3.getID3v2Tag().getAuthorComposer();
                    if(!lTypes.contains(byy))
                        lTypes.add(byy);
                }
            break;
            case DuplicateFrameId:
                for (MP3File lMP3 : lMP3s) {
                    String byy=lMP3.getID3v2Tag().getDuplicateFrameId();
                    if(!lTypes.contains(byy))
                        lTypes.add(byy);
                }
            break;
            case Identifier:
                for (MP3File lMP3 : lMP3s) {
                    String byy=lMP3.getID3v2Tag().getIdentifier();
                    if(!lTypes.contains(byy))
                        lTypes.add(byy);
                }
            break;
            case LeadArtist:
                for (MP3File lMP3 : lMP3s) {
                    String byy=lMP3.getID3v2Tag().getLeadArtist();
                    if(!lTypes.contains(byy))
                        lTypes.add(byy);
                }
            break;
            case SongGenre:
                for (MP3File lMP3 : lMP3s) {
                    String byy=lMP3.getID3v2Tag().getSongGenre();
                    if(!lTypes.contains(byy))
                        lTypes.add(byy);
                }
            break;
            case SongLyric:
                for (MP3File lMP3 : lMP3s) {
                    String byy=lMP3.getID3v2Tag().getSongLyric();
                    if(!lTypes.contains(byy))
                        lTypes.add(byy);
                }
            break;
            case SongTitle:
                for (MP3File lMP3 : lMP3s) {
                    String byy=lMP3.getID3v2Tag().getSongTitle();
                    if(!lTypes.contains(byy))
                        lTypes.add(byy);
                }
            break;
            case TrackNumberOnAlbum:
                for (MP3File lMP3 : lMP3s) {
                    String byy=lMP3.getID3v2Tag().getTrackNumberOnAlbum();
                    if(!lTypes.contains(byy))
                        lTypes.add(byy);
                }
            break;
            case Size:
                for (MP3File lMP3 : lMP3s) {
                    int byy=lMP3.getID3v2Tag().getSize();
                    if(!lTypes.contains(byy))
                        lTypes.add(String.valueOf(byy));
                }
            break;
        }
    }
    //editar metadatos
    public static void editTags(){
        
    }
    
    private ArrayList<MP3File> getFilesBy(tagType tT){
        
        lMp3BT= new ArrayList<>();
        ArrayList<MP3File> l= new ArrayList<>();
        switch(tT){
                    case AlbumTitle:
                        for (String str : lTypes) {
                            for (MP3File mP3File : lMP3s) {
                                if(str.compareTo(mP3File.getID3v2Tag().getAlbumTitle())==0)
                                    l.add(mP3File);
                            }
                            lMp3BT.add(l);
                        }
                    break;
                    case SongComment:
                        for (String str : lTypes) {
                            for (MP3File mP3File : lMP3s) {
                                if(str.compareTo(mP3File.getID3v2Tag().getSongComment())==0)
                                    l.add(mP3File);
                            }
                            lMp3BT.add(l);
                        }
                    break;
                    case AuthorComposer:
                        for (String str : lTypes) {
                            for (MP3File mP3File : lMP3s) {
                                if(str.compareTo(mP3File.getID3v2Tag().getAuthorComposer())==0)
                                    l.add(mP3File);
                            }
                            lMp3BT.add(l);
                        }
                    break;
                    case DuplicateFrameId:
                        for (String str : lTypes) {
                            for (MP3File mP3File : lMP3s) {
                                if(str.compareTo(mP3File.getID3v2Tag().getDuplicateFrameId())==0)
                                    l.add(mP3File);
                            }
                            lMp3BT.add(l);
                        }
                    break;
                    case Identifier:
                        for (String str : lTypes) {
                            for (MP3File mP3File : lMP3s) {
                                if(str.compareTo(mP3File.getID3v2Tag().getIdentifier())==0)
                                    l.add(mP3File);
                            }
                            lMp3BT.add(l);
                        }
                    break;
                    case LeadArtist:
                        for (String str : lTypes) {
                            for (MP3File mP3File : lMP3s) {
                                if(str.compareTo(mP3File.getID3v2Tag().getLeadArtist())==0)
                                    l.add(mP3File);
                            }
                            lMp3BT.add(l);
                        }
                    break;
                    case SongGenre:
                        for (String str : lTypes) {
                            for (MP3File mP3File : lMP3s) {
                                if(str.compareTo(mP3File.getID3v2Tag().getSongGenre())==0)
                                    l.add(mP3File);
                            }
                            lMp3BT.add(l);
                        }
                    break;
                    case SongLyric:
                        for (String str : lTypes) {
                            for (MP3File mP3File : lMP3s) {
                                if(str.compareTo(mP3File.getID3v2Tag().getSongLyric())==0)
                                    l.add(mP3File);
                            }
                            lMp3BT.add(l);
                        }
                    break;
                    case SongTitle:
                        for (String str : lTypes) {
                            for (MP3File mP3File : lMP3s) {
                                if(str.compareTo(mP3File.getID3v2Tag().getSongTitle())==0)
                                    l.add(mP3File);
                            }
                            lMp3BT.add(l);
                        }
                    break;
                    case TrackNumberOnAlbum:
                        for (String str : lTypes) {
                            for (MP3File mP3File : lMP3s) {
                                if(str.compareTo(mP3File.getID3v2Tag().getTrackNumberOnAlbum())==0)
                                    l.add(mP3File);
                            }
                            lMp3BT.add(l);
                        }
                    break;
                    case Size:
                        for (String str : lTypes) {
                            for (MP3File mP3File : lMP3s) {
                                if(Integer.valueOf(str)==mP3File.getID3v2Tag().getSize())
                                    l.add(mP3File);
                            }
                            lMp3BT.add(l);
                        }
                    break;
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
    
    public static String showTags(MP3File mp3) {
        AbstractID3v2 mp3TagsV2=mp3.getID3v2Tag();
        String str="";
        str+="Album "+mp3TagsV2.getAlbumTitle();
        str+="Comment "+mp3TagsV2.getSongComment();
        str+="getAuthorComposer "+mp3TagsV2.getAuthorComposer();
        str+="getDuplicateFrameId "+mp3TagsV2.getDuplicateFrameId();
        str+="getIdentifier "+mp3TagsV2.getIdentifier(); 
        str+="getLeadArtist "+mp3TagsV2.getLeadArtist();
        str+="getSongComment "+mp3TagsV2.getSongComment();
        str+="getSongGenre "+mp3TagsV2.getSongGenre();
        str+="getSongLyric "+mp3TagsV2.getSongLyric();
        str+="getSongTitle "+mp3TagsV2.getSongTitle();
        str+="getTrackNumberOnAlbum "+mp3TagsV2.getTrackNumberOnAlbum();
        str+="getYearReleased "+mp3TagsV2.getYearReleased();
        str+="getSize "+Integer.valueOf(mp3TagsV2.getSize());
        return str;
    }
    //buscar por metadatos
    public static void searchByTags(String str){
        
    }
    
    public ArrayList<MP3File> getlMP3s() throws InterruptedException {
        while(tM.isAlive()){
            Thread.sleep(1000);
            System.out.println("Cargando discoteca");
        }
            
        return lMP3s;
    }
    
    public static File eraseParuntesis(String sFile) throws IOException{
        File file = new File(sFile);
        if(sFile.contains("(") || sFile.contains(")") || sFile.contains("[") || sFile.contains("]") || sFile.contains(",")) {
            sFile=sFile.replace("(", "-");
            sFile=sFile.replace(")", "-");
            sFile=sFile.replace("[", "-");
            sFile=sFile.replace("]", "-");
            sFile=sFile.replace(",", "");
            
            File file2 = new File(sFile);

            if (file2.exists())
               throw new java.io.IOException("file exists");

            boolean success = file.renameTo(file2);

            if (success) 
                return file2;
            
            return null;
        }
        
        return file;
    }
}
