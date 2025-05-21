import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import com.intuit.karate.Runner;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class TestRunner {
    @Test
    void runTest() {
        var results = Runner.path(
            "classpath:functional")
            .outputCucumberJson(true)
            .outputJunitXml(true)
            .tags("~@skipme")
            .parallel(1);
        
        generateReport(results.getReportDir(), "karate-demo");
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }

    private void generateReport(String karateOutputPath, String projectName) {
        var jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] { "json" }, true);
        var jsonPaths = new ArrayList<String>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        var config = new Configuration(new File("target"), projectName);
        var reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }
}
