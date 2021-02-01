package design.pattern.structural.proxy;

import java.util.HashMap;

/**
 * 缓存代理.
 * <p>
 * 代理模式建议新建一个与原服务对象接口相同的代理类， 然后更新应用以将代理对象传递给所有原始对象客户端。
 * 代理类接收到客户端请求后会创建实际的服务对象， 并将所有工作委派给它。
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-31  0:02
 */
public class YouTubeCacheProxy implements ThirdPartyYouTubeLib {

    /*
     *
     * 程序库(ThirdPartyYouTubeLib)提供了视频下载类。 但是该类的效率非常低。
     * 如果客户端程序多次请求同一视频， 程序库会反复下载该视频， 而不会将首次下载的文件缓存下来复用。
     *
     * 代理类实现和原下载器相同的接口， 并将所有工作委派给原下载器。
     * 不过，代理类会保存所有的文件下载记录， 如果程序多次请求同一文件， 它会返回缓存的文件。
     *
     *
     * 为了节省网络带宽，我们可以将请求结果缓存下来并保存一段时间。但你可能无法直接将这些代码放入服务类中。
     * 比如该类可能是第三方程序库的一部分或其签名是`final（最终）`。因此我们会在一个实现了服务类接口的新代理类中放入缓存代码。
     * 当代理类接收到真实请求后，才会将其委派给服务对象。
     *
     */

    /**
     * 实际的服务对象.
     */
    private ThirdPartyYouTubeLib youtubeService;


    /**
     * 流行视频的缓存。
     */
    private HashMap<String, Video> cachePopular = new HashMap<String, Video>();

    /**
     * 所有视频的缓存。
     */
    private HashMap<String, Video> cacheAll = new HashMap<String, Video>();


    public YouTubeCacheProxy() {

        // 实际的服务对象.
        this.youtubeService = new ThirdPartyYouTubeClass();
    }


    @Override
    public HashMap<String, Video> popularVideos() {
        if (cachePopular.isEmpty()) {
            cachePopular = youtubeService.popularVideos();
        } else {
            System.out.println("Retrieved list from cache.");
        }
        return cachePopular;
    }

    @Override
    public Video getVideo(String videoId) {

        // 先从缓存查询， 找不到再请求远程服务。
        Video video = cacheAll.get(videoId);
        if (video == null) {
            video = youtubeService.getVideo(videoId);
            cacheAll.put(videoId, video);
        } else {
            System.out.println("Retrieved video '" + videoId + "' from cache.");
        }
        return video;
    }

    public void reset() {
        cachePopular.clear();
        cacheAll.clear();
    }
}
