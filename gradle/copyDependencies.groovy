configurations {
    copyDependencies
}

repositories {
    mavenCentral()
}

task copyDependencies(type: CopyDependenciesTask) {
    println 'Copy dependencies and other mandatory files to build dir.'
}

import java.io.File;
import java.nio.file.Files;

class CopyDependenciesTask extends DefaultTask {
    Boolean ignoreFailures = false
    Boolean showViolations = true
    Project gradleProject = project

    def CopyDependenciesTask() {
        description = 'Copy dependencies and other mandatory files to build dir.'
        group = 'build'
    }

    @TaskAction
    def copyDependencies() {
        //FileUtils.copyFile(new File(outputFile + "yugiohdb_empty.db"), new File(outputFile + "/build/yugiohdb.db"))
    }
}
