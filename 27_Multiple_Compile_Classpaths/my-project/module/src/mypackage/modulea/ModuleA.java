package mypackage.modulea;

import org.apache.commons.io.FilenameUtils;
import javax.activation.MimeType;

public class ModuleA extends MimeType {

    public String doWork() {
        return FilenameUtils.normalize("/a/../b");
    }
}
