package design.pattern.structural.facade.practice;

import java.io.File;

/**
 * 客户端代码.
 *
 * @description .
 * @autuor Jerry Wan
 * @date 2021-02-01 16:44
 */
public class Demo {

    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
        // ...
    }
}
