plugins {
    id("my-java-base")
    id("application")
    id("test-report-aggregation")
    id("jacoco-report-aggregation")
}

// Integrate INTEGRATION_TEST results into the aggregated UNIT_TEST coverage results
tasks.testCodeCoverageReport {
    executionData.from(
        configurations.aggregateCodeCoverageReportResults.get()
                .incoming.artifactView {
                    lenient(true)
                    withVariantReselection()
                    attributes {
                        attribute(Category.CATEGORY_ATTRIBUTE, objects.named(Category.VERIFICATION))
                        attribute(TestSuiteName.TEST_SUITE_NAME_ATTRIBUTE, objects.named("integrationTest"))
                        attribute(VerificationType.VERIFICATION_TYPE_ATTRIBUTE, objects.named(VerificationType.JACOCO_RESULTS))
                        attribute(ArtifactTypeDefinition.ARTIFACT_TYPE_ATTRIBUTE, ArtifactTypeDefinition.BINARY_DATA_TYPE)
                    }

                }.files
    )
}

// Integrate INTEGRATION_TEST results into the aggregated UNIT_TEST test results
tasks.testAggregateTestReport {
    testResults.from(
        configurations.aggregateTestReportResults.get()
            .incoming.artifactView {
                lenient(true)
                withVariantReselection()
                attributes {
                    attribute(Category.CATEGORY_ATTRIBUTE, objects.named(Category.VERIFICATION))
                    attribute(TestSuiteName.TEST_SUITE_NAME_ATTRIBUTE, objects.named("integrationTest"))
                    attribute(VerificationType.VERIFICATION_TYPE_ATTRIBUTE, objects.named(VerificationType.TEST_RESULTS))
                }
            }.files
    )
}

tasks.check {
    dependsOn(tasks.testAggregateTestReport)
    dependsOn(tasks.testCodeCoverageReport)
}
