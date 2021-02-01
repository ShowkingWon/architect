package design.pattern.structural.facade.practice;

/**
 * @description .
 * @autuor Jerry Wan
 * @date 2021-02-01 16:42
 */
public class BitrateReader {
    public static VideoFile read(VideoFile file, Codec codec) {
        System.out.println("BitrateReader: reading file...");
        return file;
    }

    public static VideoFile convert(VideoFile buffer, Codec codec) {
        System.out.println("BitrateReader: writing file...");
        return buffer;
    }
}
