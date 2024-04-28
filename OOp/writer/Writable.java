package OOp.writer;
import java.io.*;

public interface Writable {
    boolean save(Serializable serializable, String filePath);

    Object read(String filePath);
    
}
