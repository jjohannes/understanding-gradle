package myproject.data.serialization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.ConstructorDetector;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import myproject.data.MessageModel;

import java.io.File;
import java.io.IOException;

public class Serializer {

    private final ObjectMapper mapper = JsonMapper.builder()
            .constructorDetector(ConstructorDetector.USE_PROPERTIES_BASED)
            .addModule(new ParameterNamesModule(JsonCreator.Mode.PROPERTIES)).build();

    private final File location;

    public Serializer(File dataFolder) {
        this.location = new File(dataFolder, "message.json");
    }

    public MessageModel parse() {
        try {
            return mapper.readValue(location, MessageModel.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void print(MessageModel model) {
        try {
            mapper.writeValue(location, model);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
