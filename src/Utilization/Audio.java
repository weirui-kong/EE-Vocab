package Utilization;

import Expressions.Expression;
import Expressions.ExpressionType;
import javazoom.jl.player.Player;


import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;


public class Audio {
    public static final String HTTP_API = "http://dict.youdao.com/dictvoice?type=0&audio=";
    public static final String HTTP_API_SUFFIX = "";
    //public static final String HTTP_API = "https://ssl.gstatic.com/dictionary/static/sounds/oxford/";
    //public static final String HTTP_API_SUFFIX = "--_gb_1.mp3";
    public static final String TMP_DIR = "tmp/";

    public static void speak(Expression exp) {
        String[] contents = exp.getContent()
                .replace(".","")
                .replace("!","")
                .replace("\\?","")
                .replace(":","")
                .replace("\n","")
                .split(" ");
        downloadAudio(contents);
        playAudio(contents);
    }


    private static boolean downloadAudio(String[] contents) {
        if (!new File("tmp/").exists()){
            new File("tmp/").mkdir();
        }
        for (String content : contents) {
            String fName = TMP_DIR + content + ".mp3";
            String requestLink = HTTP_API + content +HTTP_API_SUFFIX;
            if (!new File(fName).exists()) {
                try {
                    URL website = new URL(requestLink);
                    ReadableByteChannel rbc = Channels.newChannel(website.openStream());
                    FileOutputStream fos = new FileOutputStream(fName);
                    fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                } catch (Exception e) {
                    return false;
                }
            }

        }
        return true;
    }

    private static void playAudio(String[] contents) {
        for (String content : contents) {
            String fName = TMP_DIR + content + ".mp3";
            try {
                File file = new File(fName);
                Player player = new Player(new FileInputStream(file));
                player.play();
            } catch (Exception ignored) {
            }
        }
    }

    //to be continued
    public static void main(String[] args) {
        speak(new Expression(ExpressionType.Phrase, "The Old Exe Bridge is a ruined medieval bridge in Exeter, England. Built from around 1190 and completed by 1214, it is the oldest surviving bridge of its size in England and the oldest bridge in Britain with a chapel on it. The project was the idea of influential local merchants Nicholas and Walter Gervase, father and son. The bridge was at least 590 feet (180 metres) long and probably had 17 or 18 arches, carrying the road across the flood plain of the River Exe. St Edmund's Church, the bridge chapel, was built into the bridge at the time of its construction. Later all but the central section carried buildings. The bridge collapsed and had to be partially rebuilt several times but remained in use for almost 600 years, until a replacement was built in 1778 and the arches across the river were demolished. In 1969 eight and a half arches of the medieval bridge were uncovered and restored. The bridge's remains are a scheduled monument and a Grade II listed building. (Full article...)", "", "", null, null));
    }
}
