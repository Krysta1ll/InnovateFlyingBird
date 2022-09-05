package com.example.innovateflyingbird.gaming;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class MusicPlayer extends Thread{
    GameFrame frame = null;
    private final int BUFFER_SIZE = 128000;
    private File soundFile;
    private AudioInputStream audioStream;
    private AudioFormat audioFormat;
    private SourceDataLine sourceLine;
    private List<String> musicFile = new ArrayList<>();

    public MusicPlayer(GameFrame frame) {
        this.frame = frame;
       musicFile.add("src/main/java/com/example/innovateflyingbird/gaming/music/love.wav");
        musicFile.add("src/main/java/com/example/innovateflyingbird/gaming/music/mean.wav");
       musicFile.add("src/main/java/com/example/innovateflyingbird/gaming/music/traceback.wav");
    }
    /**
     * @param filename the name of the file that is going to be played
     */
    public void playSound(String filename, int count){
        // 获取音乐文件地址
        String strFilename = filename;

        try {
            soundFile = new File(strFilename);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        // 文件转换成audio
        try {
            audioStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        // 获取audio格式
        audioFormat = audioStream.getFormat();

        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        try {
            sourceLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceLine.open(audioFormat);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        sourceLine.start();

        int nBytesRead = 0;
        byte[] abData = new byte[BUFFER_SIZE];
        // while (nBytesRead != -1)
        while(true) {
            if(nBytesRead == -1) {
                if(frame.count >= 100 && frame.count <= 102) {
                }
                try {
                    audioStream = AudioSystem.getAudioInputStream(soundFile);
                } catch (Exception e){
                    e.printStackTrace();
                    System.exit(1);
                }
            }
            try {
                nBytesRead = audioStream.read(abData, 0, abData.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (nBytesRead >= 0) {
                @SuppressWarnings("unused")
                int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
            }
            if(frame.count >= count) {
                sourceLine.drain();
                sourceLine.close();
                break;
            }
        }
//        sourceLine.drain();
//        sourceLine.close();
    }

    @Override
    public void run() {
        this.playSound(musicFile.get(0), 100);
        this.playSound(musicFile.get(1), 300);
        this.playSound(musicFile.get(2), Integer.MAX_VALUE);
    }

}