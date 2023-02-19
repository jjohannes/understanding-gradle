package mypackage.modulea;

import org.apache.commons.io.FilenameUtils;
import javax.activation.MimeType;

public class ModuleA {

    public String doWork(MimeType mimeType) {
        return FilenameUtils.normalize("/a/../b");
    }
}
