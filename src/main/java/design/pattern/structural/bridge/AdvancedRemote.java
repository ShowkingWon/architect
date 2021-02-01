package design.pattern.structural.bridge;

/**
 *  高级远程控制器.
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-02-01  23:46
 */
public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device device) {
        super.device = device;
    }

    public void mute() {
        System.out.println("Remote: mute");
        device.setVolume(0);
    }
}
