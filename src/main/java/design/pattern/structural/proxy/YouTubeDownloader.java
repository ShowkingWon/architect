package design.pattern.structural.proxy;

import java.util.HashMap;

/**
 * 媒体下载应用。
 *
 * 客户端 （Client） ：能通过同一接口与服务或代理进行交互， 所以你可在一切需要服务对象的代码中使用代理。
 *
 * 代理模式是一种结构型设计模式， 让你能够提供对象的替代品或其占位符。 代理控制着对于原对象的访问， 并允许在将请求提交给对象前后进行一些处理。
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-31  0:04
 */
public class YouTubeDownloader {


    /**
     * 远程服务。
     */
    private ThirdPartyYouTubeLib api;


    public YouTubeDownloader(ThirdPartyYouTubeLib api) {
        this.api = api;
    }

    public void renderVideoPage(String videoId) {
        Video video = api.getVideo(videoId);
        System.out.println("\n-------------------------------");
        System.out.println("Video page (imagine fancy HTML)");
        System.out.println("ID: " + video.id);
        System.out.println("Title: " + video.title);
        System.out.println("Video: " + video.data);
        System.out.println("-------------------------------\n");
    }

    public void renderPopularVideos() {
        HashMap<String, Video> list = api.popularVideos();
        System.out.println("\n-------------------------------");
        System.out.println("Most popular videos on YouTube (imagine fancy HTML)");
        for (Video video : list.values()) {
            System.out.println("ID: " + video.id + " / Title: " + video.title);
        }
        System.out.println("-------------------------------\n");
    }
}
