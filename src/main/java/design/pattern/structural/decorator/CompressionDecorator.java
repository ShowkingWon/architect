package design.pattern.structural.decorator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/**
 * Concrete Decorators角色。
 * <p>
 * 压缩、解压缩
 *
 * @author JerryWan
 * @descripion TODO
 * @date 2021-01-30  0:00
 */
public class CompressionDecorator extends DataSourceDecorator {
    private int compLevel = 6;

    public CompressionDecorator(DataSource dataSource) {
        super(dataSource);
    }

    public int getCompLevel() {
        return compLevel;
    }

    public void setCompLevel(int compLevel) {
        this.compLevel = compLevel;
    }

    @Override
    public void writeData(String data) {
        System.out.println("要被压缩了。。。" );

        super.writeData(compress(data));
    }


    @Override
    public String readData() {
        System.out.println("要被解压缩了。。。" );
        return decompress(super.readData());
    }


    /**
     * 压缩。
     *
     * @creator wx
     * @date 2021/1/30 0:02
     * @description
     */
    private String compress(String stringData) {
        byte[] data = stringData.getBytes();
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream(512);

            /*
             * Deflate可以被认为是压缩算法的参考实现,而ZIP和GZIP则是“扩展”.后者支持“档案”的概念,
             * 这在ZipOutputStream的Java API中更加明显.
             * 如果你只是想压缩数据流,我建议使用DeflaterOutputStream,但是如果你正在创建一个存档,你应该看看ZipOutputStream.
             */
            DeflaterOutputStream dos = new DeflaterOutputStream(bout, new Deflater(compLevel));
            dos.write(data);
            dos.close();
            bout.close();
            return Base64.getEncoder().encodeToString(bout.toByteArray());
        } catch (IOException ex) {
            return null;
        }
    }


    /**
     * 解压缩。
     *
     * @creator wx
     * @date 2021/1/30 0:06
     * @description
     */
    private String decompress(String stringData) {
        byte[] data = Base64.getDecoder().decode(stringData);
        try {
            InputStream in = new ByteArrayInputStream(data);
            InflaterInputStream iin = new InflaterInputStream(in);
            ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
            int b;
            while ((b = iin.read()) != -1) {
                bout.write(b);
            }
            in.close();
            iin.close();
            bout.close();
            return new String(bout.toByteArray());
        } catch (IOException ex) {
            return null;
        }
    }


}
