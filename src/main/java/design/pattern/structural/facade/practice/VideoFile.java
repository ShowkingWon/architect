package design.pattern.structural.facade.practice;

/**
 * 复杂视频转换程序库.
 *
 * @description .
 * @autuor Jerry Wan
 * @date 2021-02-01 16:39
 */
public class VideoFile {

    private String name;
    private String codecType;

    public VideoFile(String name) {
        this.name = name;
        this.codecType = name.substring(name.indexOf(".") + 1);
    }

    public String getCodecType() {
        return codecType;
    }

    public String getName() {
        return name;
    }
}
