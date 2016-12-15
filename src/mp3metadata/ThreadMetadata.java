package mp3metadata;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.farng.mp3.TagException;

public class ThreadMetadata extends Thread{
    private Metadata m;

    public ThreadMetadata(Metadata m) {
        this.m = m;
        this.start();
    }
    
    @Override
    public void run() {
        try {
            super.run(); //To change body of generated methods, choose Tools | Templates.
            m.algo();
        } catch (IOException ex) {
            Logger.getLogger(ThreadMetadata.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TagException ex) {
            Logger.getLogger(ThreadMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
