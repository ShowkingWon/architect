package design.pattern.structural.proxy;

/**
 * 视频文件.
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-30  23:59
 */
public class Video {

    public String id;

    public String title;

    public String data;

    Video(String id, String title) {
        this.id = id;
        this.title = title;
        this.data = "Random video.";
    }
    
}
