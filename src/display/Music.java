/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package display;



import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Music {
    private Clip clip;
    private Clip clip2;
    private AudioInputStream audioInput;
    private AudioInputStream audioInput2;
    public void playInGameSound() {
        try {
            audioInput = AudioSystem.getAudioInputStream(new File("sound\\InGameSound.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInput);
            playSound();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void playMenuSound() {
        try {
            audioInput = AudioSystem.getAudioInputStream(new File("sound\\MenuSound.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInput);
            playSound();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void playSoundEffect() {
        try {
            audioInput2 = AudioSystem.getAudioInputStream(new File("sound\\Ugh.wav"));
            clip2 = AudioSystem.getClip();
            clip2.open(audioInput2);
            clip2.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void playGameOver() {
        try {
            audioInput = AudioSystem.getAudioInputStream(new File("sound\\GameOver.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void correctSound() {
        try {
            audioInput = AudioSystem.getAudioInputStream(new File("sound\\sound_Correct.wav"));
            clip2 = AudioSystem.getClip();
            clip2.open(audioInput);
            clip2.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void playSound() {
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stopSound() {
        clip.stop();
    }
}
