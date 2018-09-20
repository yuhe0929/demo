import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author yuhea
 * @date 16:37 2018/5/16
 */
public class TestNIO {
    @Test
    public void testNio() throws Exception {
        URI path = this.getClass().getClassLoader().getResource("testNio.txt").toURI();
        try (FileInputStream fi = new FileInputStream(new File(path))) {
            try (FileOutputStream fo = new FileOutputStream(new File("copyedFile.txt"))) {
                FileChannel inChannel = fi.getChannel();
                FileChannel outChannel = fo.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(2048);
                while (inChannel.read(buffer) != -1) {
                    buffer.flip();
                    outChannel.write(buffer);
                    buffer.clear();
                }
            }
        }
    }
}
