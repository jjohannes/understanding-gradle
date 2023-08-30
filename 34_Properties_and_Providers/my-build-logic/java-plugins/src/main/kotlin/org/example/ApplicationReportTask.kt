package org.example

import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

abstract class ApplicationReportTask : DefaultTask() {

    //abstract val p1: Property<String>
    //abstract val p2: Property<Int>
    //abstract val p3: Property<MyEnum>

    //abstract val p4: SetProperty<String>
    //abstract val p5: ListProperty<String>
    //abstract val p6: MapProperty<String, String>

    @get:InputDirectory
    abstract val classesDir: DirectoryProperty

    @get:OutputFile
    abstract val reportFile: RegularFileProperty

    @TaskAction
    fun report() {
        reportFile.get().asFile.writeText(
        """
            Application report:
            ===================
            Class File Count: ${classesDir.get().asFileTree.count()}
        """.trimIndent())
    }

}
