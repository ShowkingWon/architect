package design.pattern.structural.facade.practice;

import java.io.File;

/**
 * @description .
 * @autuor Jerry Wan
 * @date 2021-02-01 16:42
 */
public class AudioMixer {
    public File fix(VideoFile result){
        System.out.println("AudioMixer: fixing audio...");
        return new File("tmp");
    }
}
