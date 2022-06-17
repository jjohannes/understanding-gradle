package org.example

import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

abstract class ApplicationReportTask extends DefaultTask {

    //abstract Property<String> getP1()
    //abstract Property<Int> getP2()
    //abstract Property<MyEnum> getP3()

    //abstract SetProperty<String> getP4()
    //abstract ListProperty<String> getP5()
    //abstract MapProperty<String, String> getP6()

    @InputDirectory
    abstract DirectoryProperty getClassesDir()

    @OutputFile
    abstract RegularFileProperty getReportFile()

    @TaskAction
    void report() {
        reportFile.get().asFile.text =
        """
            Application report:
            ===================
            Class File Count: ${classesDir.get().asFileTree.size()}
        """.stripIndent().trim()
    }

}
