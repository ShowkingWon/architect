package design.pattern.structural.proxy;

import java.util.HashMap;

/**
 * 远程服务接口.
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-30  23:58
 */
public interface ThirdPartyYouTubeLib {


    /**
     * 获取所有流行视频。
     *
     * @return 流行视频
     */
    HashMap<String, Video> popularVideos();


    /**
     * 查询指定视频。
     *
     * @param videoId
     * @return 视频
     */
    Video getVideo(String videoId);

}
