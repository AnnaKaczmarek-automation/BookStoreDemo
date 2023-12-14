import model.EnvironmentTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Map;

public class ApplicationProperties {
    Logger log = LoggerFactory.getLogger("ApplicationProperties.class");

    public ApplicationProperties() {
        setPropertiesValuesFromYamlFileToSystem();
    }

    public void setPropertiesValuesFromYamlFileToSystem() {
        YamlReader yamlReader = new YamlReader();
        List<EnvironmentTemplate> lisOfEnvironments = yamlReader.getConfiguration().getEnvironment().getListOfEnvironments();
        boolean isActive = false;
        for (EnvironmentTemplate environment : lisOfEnvironments) {
            if (environment.isActive()) {
                isActive = true;
                Map<String, Object> environmentProperties = environment.getProperties();
                log.info("Amount of loaded environment properties is: " + environmentProperties.size());
                for (Map.Entry entry : environmentProperties.entrySet()) {
                    System.setProperty(entry.getKey().toString(), entry.getValue().toString());
                }
            }
            break;
        }
        Map<String, Object> browserProperties = yamlReader.getConfiguration().getBrowser().getProperties();
        log.info("Amount of loaded browser properties is: " + browserProperties.size());
        for (Map.Entry entry : browserProperties.entrySet()) {
            System.setProperty(entry.getKey().toString(), entry.getValue().toString());
        }

        if (isActive == false) {
            setSampleValuesForProperties();
        }
    }

    private void setSampleValuesForProperties() {
        YamlReader yamlReader = new YamlReader();
        Map<String, Object> environmentProperties = yamlReader.getConfiguration().getEnvironment().getTest2().getProperties();
        for (Map.Entry entry : environmentProperties.entrySet()) {
            System.getProperty(entry.getKey().toString(), entry.getValue().toString());
        }
    }
}
