plugins {
    id("my-java-base")
    id("application")
    id("test-report-aggregation")
    id("jacoco-report-aggregation")
}

tasks.testCodeCoverageReport {
    executionData.from(
        configurations["aggregateCodeCoverageReportResults"]
                .incoming.artifactView {
                    lenient(true)
                    withVariantReselection()
                    attributes {
                        attribute(Category.CATEGORY_ATTRIBUTE, objects.named(Category.VERIFICATION))
                        attribute(TestSuiteType.TEST_SUITE_TYPE_ATTRIBUTE, objects.named(TestSuiteType.INTEGRATION_TEST))
                        attribute(VerificationType.VERIFICATION_TYPE_ATTRIBUTE, objects.named(VerificationType.JACOCO_RESULTS))
                        attribute(ArtifactTypeDefinition.ARTIFACT_TYPE_ATTRIBUTE, ArtifactTypeDefinition.BINARY_DATA_TYPE)
                    }
                }.files
    )
}

tasks.check {
    dependsOn(tasks.testAggregateTestReport)
    dependsOn(tasks.testCodeCoverageReport)
}
