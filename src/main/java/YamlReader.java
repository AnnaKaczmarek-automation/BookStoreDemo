import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.*;

public class YamlReader {

    private static Configuration configuration;

    public Configuration getConfiguration() {
        return configuration;
    }

    public YamlReader() {
        try {
//            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//            File file = new File(classLoader.getResource("config.yaml").getFile());

            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
//            this.configuration = objectMapper.readValue(file, Configuration.class);
            this.configuration = objectMapper.readValue(new File("src/main/resources/config.yaml"), Configuration.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
