plugins {
    id("my-java-base")
    id("application")
    id("test-report-aggregation")
    id("jacoco-report-aggregation")
}

tasks.testCodeCoverageReport {
    executionData.from(
        configurations["integrationTestCodeCoverageReportExecutionData"]
            .incoming.artifactView { lenient(true) }.files
    )
}

tasks.check {
    dependsOn(tasks.testAggregateTestReport)
    dependsOn(tasks.testCodeCoverageReport)
}
