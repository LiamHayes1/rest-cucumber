package example;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import rest.CucumberRestClient;
import rest.ResultOutput;

public class RestClientExample implements CucumberRestClient {
   public RestClientExample() {
   }

   public String getFeatureString(String testId) {
      return "Feature: Mock feature 1\n" + "Scenario: Creating a mock\n"
         + "Given I have 43 cukes in my belly\n" + "When I wait 1 hour\n"
         + "Then my belly should growl\n" + "Scenario: Creating a mock2\n"
         + "Given No oncoming traffic\n" + "When I cross the road\n"
         + "Then On the other side";
   }

   public boolean updateTest(ResultOutput resultOutput) {
      String testId = resultOutput.testId;
      String result = resultOutput.result;
      StringBuilder stepResults = new StringBuilder("\n");
      Map<String, String> results = resultOutput.scenarioResults;
      for (Map.Entry<String, String> entry : results.entrySet()) {
         stepResults.append(entry.getKey()).append(" - ").append(entry.getValue())
            .append("\n");
      }
      String summary =
         String.format("TestID: %s, Result: %s, Step Results: %s", testId, result,
            stepResults);
      System.out.println(summary);
      return true;
   }

   public Set<String> getTestIds() {
      Set<String> testIds = new HashSet<String>();
      testIds.add("testId123");
      return testIds;
   }
}
